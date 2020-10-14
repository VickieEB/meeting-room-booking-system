package com.petproject.mrbs.controller;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping({"/rooms/list", "/rooms/index", "/rooms/"})
    public String listRooms(Model model){
        model.addAttribute("rooms", roomService.findAll());
        return "rooms/roomsList";
    }

    @GetMapping({"/admin/rooms/list", "/admin/rooms/index", "/admin/rooms/"})
    public String adminRoomList(Model model){
        model.addAttribute("rooms", roomService.findAll());
        return "admin/rooms/roomsList";
    }

    @GetMapping("/admin/rooms/new")
    public String newRoom(Model model){
        model.addAttribute("room", new Room());
        return "admin/rooms/roomform";
    }


}
