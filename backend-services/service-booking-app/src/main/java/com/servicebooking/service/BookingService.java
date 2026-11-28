package com.servicebooking.service;

import com.servicebooking.model.Booking;
import com.servicebooking.model.ServiceItem;
import com.servicebooking.repository.BookingRepository;
import com.servicebooking.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CatalogService catalogService;
    private final JwtUtil jwtUtil;
    private final SecureRandom random = new SecureRandom();

    public BookingService(BookingRepository bookingRepository,
                          CatalogService catalogService,
                          JwtUtil jwtUtil) {
        this.bookingRepository = bookingRepository;
        this.catalogService = catalogService;
        this.jwtUtil = jwtUtil;
    }

    @Transactional
    public Booking createBooking(Long serviceId, String customerName, String customerPhone, LocalDate appointmentDate) {
        ServiceItem service = catalogService.getServiceById(serviceId);

        Booking booking = new Booking();
        booking.setServiceItem(service);
        booking.setCustomerName(customerName);
        booking.setCustomerPhone(customerPhone);
        booking.setAppointmentDate(appointmentDate);
        booking.setSecretCode(generateUnique6DigitCode());

        return bookingRepository.save(booking);
    }

    public Optional<Map<String, Object>> verifyCodeAndIssueToken(String secretCode) {
        return bookingRepository.findBySecretCode(secretCode)
                .map(booking -> Map.of(
                        "token", jwtUtil.generateTokenForCode(booking.getSecretCode()),
                        "booking", booking
                ));
    }

    public Optional<Booking> getBookingByCode(String secretCode) {
        return bookingRepository.findBySecretCode(secretCode);
    }

    @Transactional
    public Optional<Booking> updateAppointmentDate(String secretCode, LocalDate newDate) {
        return bookingRepository.findBySecretCode(secretCode)
                .map(booking -> {
                    booking.setAppointmentDate(newDate);
                    return bookingRepository.save(booking);
                });
    }

    @Transactional
    public boolean deleteBooking(String secretCode) {
        return bookingRepository.findBySecretCode(secretCode)
                .map(booking -> {
                    bookingRepository.delete(booking);
                    return true;
                })
                .orElse(false);
    }

    private String generateUnique6DigitCode() {
        String code;
        do {
            code = String.valueOf(100000 + random.nextInt(900000));
        } while (bookingRepository.existsBySecretCode(code));
        return code;
    }
}
