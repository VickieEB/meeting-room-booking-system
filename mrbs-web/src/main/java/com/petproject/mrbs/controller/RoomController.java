package com.petproject.mrbs.controller;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.services.ImageService;
import com.petproject.mrbs.services.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class RoomController {

    public static final String ADMIN_ROOMS_ROOMFORM = "admin/rooms/roomform";
    private final RoomService roomService;
    private final ImageService imageService;

    public RoomController(RoomService roomService, ImageService imageService) {
        this.roomService = roomService;
        this.imageService = imageService;
    }

    @GetMapping({"/rooms/list", "/rooms/index", "/rooms/"})
    public String listRooms(Model model){
        model.addAttribute("rooms", roomService.findAll());
        return "rooms/roomsList";
    }

    @GetMapping({"/admin/rooms/list", "/admin/rooms/index", "/admin/rooms/"})
    public String adminRoomList(Model model){
        model.addAttribute("room", new Room());
        model.addAttribute("rooms", roomService.findAll());
        return "admin/rooms/roomsList";
    }

    @GetMapping("/admin/rooms/new")
    public String newRoom(Model model){
        model.addAttribute("room", new Room());
        return ADMIN_ROOMS_ROOMFORM;
    }

    @PostMapping("/admin/rooms/new")
    public String saveNewRoom(@Valid Room room, BindingResult bindingResult, Model model, @RequestParam("image") MultipartFile file){

//        if(bindingResult.hasErrors()){
//            model.addAttribute("room", new Room());
//            return ADMIN_ROOMS_ROOMFORM;
//        }else{
            Byte[] imageBytes = imageService.processImageFile(file);
            room.setImage(imageBytes);
            roomService.save(room);
            return "redirect:/admin/rooms/list";
        //}
    }


    @GetMapping("/admin/rooms/{roomId}/edit")
    public String loadRoomToEdit(@PathVariable Long roomId, Model model){
        model.addAttribute("room", roomService.findById(roomId));
        return ADMIN_ROOMS_ROOMFORM;
    }

    @PostMapping("/admin/rooms/{roomId}/edit")
    public String editRoom(@Valid Room room, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("room", room);
            return ADMIN_ROOMS_ROOMFORM;
        }else{
            roomService.save(room);
            return "redirect:/admin/rooms/list";
        }
    }

    @GetMapping("/admin/rooms/{roomId}/delete")
    public String deleteRoom(@PathVariable Long roomId){
        roomService.deleteById(roomId);
        log.debug("Room " + roomId  +  "Successfully Deleted.");
        return "redirect:/admin/rooms/list";
    }

    @GetMapping("/admin/find/room")
    public String findRoom(@Valid Room room, BindingResult result, Model model){
        if(room.getName() == null){
            room.setName("");
        }

        List<Room> roomList = roomService.findByNameLowerCaseLike(room.getName());
        log.debug("Size of search result " + roomList.size());

        if(roomList.isEmpty() || roomList.size() == 0){
            result.rejectValue("name", "notFount","Room Not Found");
            return "admin/rooms/roomsList";
        }else if(roomList.size() == 1){
            room = roomList.get(0);
            return "redirect:/admin/rooms/" + room.getId() + "/edit";
        } else {
            model.addAttribute("rooms", roomList);
            return "admin/rooms/roomsList";

        }
    }


}
