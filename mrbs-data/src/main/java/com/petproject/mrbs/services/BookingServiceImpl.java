package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Booking;
import com.petproject.mrbs.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Set<Booking> findAll() {
        Set<Booking> bookings = new HashSet<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking save(Booking object) {
        return bookingRepository.save(object);
    }

    @Override
    public void delete(Booking object) {
        bookingRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }
}
