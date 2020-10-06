package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Room;
import com.petproject.mrbs.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Set<Room> findAll() {
        Set<Room> rooms = new HashSet<>();
        roomRepository.findAll().forEach(rooms::add);

        return rooms;
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room save(Room object) {
        return roomRepository.save(object);
    }

    @Override
    public void delete(Room object) {
        roomRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
