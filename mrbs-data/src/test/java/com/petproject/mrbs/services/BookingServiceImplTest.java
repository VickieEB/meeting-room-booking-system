package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Booking;
import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.repositories.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    Booking returnedBooking;

    @BeforeEach
    void setUp() {
        returnedBooking = Booking.builder().id(1L).room(Room.builder().id(1L).name("Small Conference Room").build()).attendees(12).build();
    }

    @Test
    void findAll() {
        Set<Booking> bookingSet = new HashSet<>();
        bookingSet.add(Booking.builder().id(1L).attendees(20).build());
        bookingSet.add(Booking.builder().id(2L).attendees(12).build());

        when(bookingRepository.findAll()).thenReturn(bookingSet);

        Set<Booking> bookings = bookingService.findAll();
        assertNotNull(bookings);
        assertEquals(2, bookings.size());

    }

    @Test
    void findById() {
        when(bookingRepository.findById(anyLong())).thenReturn(Optional.of(returnedBooking));

        Booking booking = bookingService.findById(1L);

        assertNotNull(booking);
        assertEquals(1, booking.getId());
        assertEquals("Small Conference Room", booking.getRoom().getName());
    }

    @Test
    void save() {
        Booking booking = Booking.builder().id(1L).attendees(10).build();

        when(bookingRepository.save(any())).thenReturn(booking);

        Booking savedBooking = bookingService.save(booking);
        assertNotNull(savedBooking);

        verify(bookingRepository).save(any());

    }

    @Test
    void delete() {
        Booking booking = Booking.builder().id(1L).attendees(10).build();
        bookingService.delete(booking);

        verify(bookingRepository).delete(any());
    }

    @Test
    void deleteById() {
        bookingService.deleteById(1L);
        verify(bookingRepository).deleteById(anyLong());
    }
}