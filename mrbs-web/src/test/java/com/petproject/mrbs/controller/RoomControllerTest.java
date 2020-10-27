package com.petproject.mrbs.controller;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.services.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        mockMvc.perform(get("/admin/rooms/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("room"))
                .andExpect(view().name("admin/rooms/roomform"));

    }

    @Test
    @Disabled
    void postRoomCreationForm()throws Exception{
        Room room = Room.builder().id(1L).name("Small Conference Room").build();

        MockMultipartFile  image = new MockMultipartFile("layout1.png", "image_file".getBytes());

        when(roomService.save(any())).thenReturn(room);

//        mockMvc.perform(post("/admin/rooms/new")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("id","")
//                .param("name", "Small Conference Room")
//        )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/admin/rooms/list"));

        mockMvc.perform(multipart("/admin/rooms/new")
                .file(image)
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","")
                .param("name", "Small Conference Room")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/admin/rooms/list"));

        verify(roomService).save(any());
    }

    @Test
    void initEditForm() throws Exception{
        when(roomService.findById(anyLong())).thenReturn(room);

        mockMvc.perform(get("/admin/rooms/1/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("room"))
                .andExpect(view().name("admin/rooms/roomform"));
    }

    @Test
    void processEditRoom() throws Exception{
        Room room = Room.builder().id(1L).name("Cozy Room").build();

        when(roomService.save(any())).thenReturn(room);

        mockMvc.perform(post("/admin/rooms/1/edit")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","1")
                .param("name", "Cozy Room")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/admin/rooms/list"));

        verify(roomService).save(any());
    }

    @Test
    void deleteRoom() throws Exception{
        mockMvc.perform(get("/admin/rooms/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/admin/rooms/list"));

        verify(roomService, times(1)).deleteById(anyLong());
    }

    @Test
    void listRooms() {
    }

    @Test
    void adminRoomList() {
    }
}