package com.petproject.mrbs.controller;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoomController {

    public static final String ADMIN_ROOMS_ROOMFORM = "admin/rooms/roomform";
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
        return ADMIN_ROOMS_ROOMFORM;
    }

    @PostMapping("/admin/rooms/new")
    public String saveNewRoom(@Valid Room room, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("room", new Room());
            return ADMIN_ROOMS_ROOMFORM;
        }else{
            roomService.save(room);
            return "redirect:/admin/rooms/list";
        }
    }


}
