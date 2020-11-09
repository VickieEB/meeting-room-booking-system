package com.petproject.mrbs.controller;

import com.petproject.mrbs.domain.Booking;
import com.petproject.mrbs.services.BookedHoursService;
import com.petproject.mrbs.services.BookingService;
import com.petproject.mrbs.services.DurationHoursService;
import com.petproject.mrbs.services.DurationTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    private final BookedHoursService bookedHoursService;

    private final DurationTypeService durationTypeService;

    private final DurationHoursService durationHoursService;

    public BookingController(BookingService bookingService, BookedHoursService bookedHoursService, DurationTypeService durationTypeService, DurationHoursService durationHoursService) {
        this.bookingService = bookingService;
        this.bookedHoursService = bookedHoursService;
        this.durationTypeService = durationTypeService;
        this.durationHoursService = durationHoursService;
    }

    @GetMapping("/booking/new")
    public String newBookingForm(Model model){
        model.addAttribute("booking", new Booking());
        model.addAttribute("durationtypes", durationTypeService.findAll());
        return "booking/bookingform";
    }

}
