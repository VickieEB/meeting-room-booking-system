package com.petproject.mrbs.bootstrap;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.domain.enums.Status;
import com.petproject.mrbs.repositories.BookingRepository;
import com.petproject.mrbs.repositories.RoomRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

        Room panoramic = Room.builder().id(1L)
                .name("Panoramic Room")
                .description("Situated in an Instantly recognised address, a short walk from Four Points Sheraton, Oniru")
                .capacity(20)
                .price(250.00)
                .address("Oniru, Lagos")
                .status(Status.ACTIVE)
                .build();

        rooms.add(panoramic);

        return rooms;

    }
}
