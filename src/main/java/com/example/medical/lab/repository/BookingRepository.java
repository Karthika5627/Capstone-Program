package com.example.medical.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medical.lab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}