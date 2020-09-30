package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class RoomService implements CrudService<Room, Long> {
    @Override
    public Set<Room> findAll() {
        return null;
    }

    @Override
    public Room findById(Long aLong) {
        return null;
    }

    @Override
    public Room save(Room object) {
        return null;
    }

    @Override
    public void delete(Room object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
