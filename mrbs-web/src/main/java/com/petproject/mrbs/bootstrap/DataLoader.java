package com.petproject.mrbs.bootstrap;

import com.petproject.mrbs.domain.BookedHours;
import com.petproject.mrbs.domain.Booking;
import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.domain.enums.Duration;
import com.petproject.mrbs.domain.enums.Status;
import com.petproject.mrbs.repositories.BookingRepository;
import com.petproject.mrbs.repositories.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RoomRepository roomRepository;
    private BookingRepository bookingRepository;

    public DataLoader(RoomRepository roomRepository, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Loading Bootstrap Data");
        getRooms();
        log.debug("Data Loaded");

    }

    private List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();

        Room smallConference = Room.builder().id(1L)
                .name("Small Conference Room")
                .description("The Workspace gives business and mobile travellers privacy to work undisturbed.")
                .capacity(12)
                .price(69.00)
                .address("Osborne Road, Ikoyi, Lagos")
                .status(Status.ACTIVE)
                .build();
        rooms.add(smallConference);

        Room panoramic = Room.builder().id(2L)
                .name("Panoramic Room")
                .description("Situated in an Instantly recognised address, a short walk from Four Points Sheraton, Oniru")
                .capacity(30)
                .price(250.00)
                .address("Oniru, Lagos")
                .status(Status.ACTIVE)
                .build();
        rooms.add(panoramic);

        roomRepository.saveAll(rooms);

        List<Booking> bookingList  = new ArrayList<>();

        Booking booking1 = Booking.builder().id(1L).attendees(10).customerName("Lola Malo")
                .duration(Duration.HALFDAYMORNING).bookeddate(LocalDate.of(2020, Month.OCTOBER, 10))
                .transDate(LocalDate.of(2020, Month.OCTOBER, 1))
                .note("Please make available Ushers").status(Status.CONFIRMED).room(smallConference).build();
        booking1.getBookedHours().add(new BookedHours("08:00", "12:00", booking1));

        bookingList.add(booking1);

        Booking booking2 = Booking.builder().id(2L).attendees(30).customerName("Rick Martins")
                .duration(Duration.HOUR).bookeddate(LocalDate.of(2020, Month.DECEMBER, 12))
                .transDate(LocalDate.of(2020, Month.SEPTEMBER, 15))
                .note("What happens if we come with 2 more guests").status(Status.PENDING).room(panoramic).build();

        booking2.addBookedHours(new BookedHours("08:00", "17:00"));
        bookingList.add(booking2);
        bookingRepository.saveAll(bookingList);

        return rooms;

    }

}
