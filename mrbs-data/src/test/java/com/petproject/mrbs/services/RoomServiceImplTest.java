package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.repositories.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceImplTest {

    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    RoomServiceImpl roomService;

    Room returnedRoom;

    @BeforeEach
    void setUp() {
        returnedRoom = Room.builder().id(1L).name("Lounge Room").price(128.0).build();
    }

    @Test
    void findAll() {
        Set<Room> rooms = new HashSet<>();
        rooms.add(Room.builder().id(1L).build());
        rooms.add(Room.builder().id(2L).build());

        when(roomRepository.findAll()).thenReturn(rooms);
        Set<Room> allRooms = roomService.findAll();
        assertNotNull(allRooms);

        verify(roomRepository).findAll();
    }

    @Test
    void findById() {
        when(roomRepository.findById(anyLong())).thenReturn(Optional.of(returnedRoom));

        Room room = roomService.findById(1L);
        assertNotNull(room);
        assertEquals("Lounge Room", room.getName());
        assertEquals(1, room.getId());

        verify(roomRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        when(roomRepository.findById(anyLong())).thenReturn(Optional.empty());
        Room room = roomService.findById(1L);
        assertNull(room);
    }

    @Test
    void save() {
        when(roomRepository.save(any())).thenReturn(returnedRoom);
        Room saveRoom = roomService.save(Room.builder().id(1L).name("Ocean View").build());
        assertNotNull(saveRoom);
        assertEquals(1L, saveRoom.getId());

        verify(roomRepository).save(any());
    }

    @Test
    void deleteById() {
        roomService.deleteById(1L);
        verify(roomRepository).deleteById(anyLong());
    }

    @Test
    void delete() {
        roomService.delete(returnedRoom);
        verify(roomRepository).delete(any());

    }
}