package com.servicebooking.repository;

import com.servicebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findBySecretCode(String secretCode);
    boolean existsBySecretCode(String secretCode);
}
