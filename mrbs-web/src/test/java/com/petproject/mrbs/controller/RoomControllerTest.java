package com.petproject.mrbs.controller;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.services.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    MockMvc mockMvc;

    Room room;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
        room = Room.builder().id(1L).name("Small Conference Room").address("Ikoyi").build();
    }

    @Test
    void initializeRoomCreationForm()throws Exception{
        //when(roomService.findById(anyLong())).thenReturn(room);

        mockMvc.perform(get("/admin/rooms/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("room"))
                .andExpect(view().name("admin/rooms/roomform"));

    }

    @Test
    void listRooms() {
    }

    @Test
    void adminRoomList() {
    }
}