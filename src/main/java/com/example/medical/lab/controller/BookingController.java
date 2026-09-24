package com.example.medical.lab.controller;

import com.example.medical.lab.model.Booking;
import com.example.medical.lab.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }
}