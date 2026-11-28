package com.servicebooking.controller;

import com.servicebooking.model.Booking;
import com.servicebooking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Map<String, String> payload) {
        Booking saved = bookingService.createBooking(
                Long.parseLong(payload.get("serviceId")),
                payload.get("customerName"),
                payload.get("customerPhone"),
                LocalDate.parse(payload.get("appointmentDate"))
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "Booking confirmed",
                "secretCode", saved.getSecretCode(),
                "serviceTitle", saved.getServiceItem().getTitle(),
                "category", saved.getServiceItem().getCategory(),
                "price", saved.getServiceItem().getPrice(),
                "appointmentDate", saved.getAppointmentDate()
        ));
    }

    @PostMapping("/verify-code")
    public ResponseEntity<?> verifyCode(@RequestBody Map<String, String> payload) {
        return bookingService.verifyCodeAndIssueToken(payload.get("secretCode"))
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Invalid 6-digit booking code")));
    }

    @GetMapping("/manage")
    public ResponseEntity<?> getMyBooking(Authentication auth) {
        return bookingService.getBookingByCode(auth.getName())
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Booking not found")));
    }

    @PatchMapping("/manage")
    public ResponseEntity<?> updateAppointmentDate(@RequestBody Map<String, String> payload, Authentication auth) {
        LocalDate newDate = LocalDate.parse(payload.get("appointmentDate"));

        return bookingService.updateAppointmentDate(auth.getName(), newDate)
                .<ResponseEntity<?>>map(updated -> ResponseEntity.ok(Map.of(
                        "message", "Appointment date updated",
                        "booking", updated
                )))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Booking not found")));
    }

    @DeleteMapping("/manage")
    public ResponseEntity<?> deleteBooking(Authentication auth) {
        if (bookingService.deleteBooking(auth.getName())) {
            return ResponseEntity.ok(Map.of("message", "Booking deleted successfully"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Booking not found"));
    }
}
