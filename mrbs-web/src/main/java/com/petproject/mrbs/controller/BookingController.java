package com.petproject.mrbs.controller;

import com.petproject.mrbs.services.BookedHoursService;
import com.petproject.mrbs.services.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    private final BookedHoursService bookedHoursService;

    public BookingController(BookingService bookingService, BookedHoursService bookedHoursService) {
        this.bookingService = bookingService;
        this.bookedHoursService = bookedHoursService;
    }
}
