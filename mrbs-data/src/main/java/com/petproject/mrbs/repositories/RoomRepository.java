package com.petproject.mrbs.repositories;

import com.petproject.mrbs.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
