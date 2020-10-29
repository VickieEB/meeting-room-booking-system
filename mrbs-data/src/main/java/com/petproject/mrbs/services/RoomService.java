package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Room;

import java.util.List;

public interface RoomService extends CrudService<Room, Long> {
    List<Room> findByNameLowerCaseLike(String name);
}
