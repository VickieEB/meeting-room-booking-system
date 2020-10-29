package com.petproject.mrbs.repositories;

import com.petproject.mrbs.domain.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    @Query("select r from Room r where lower(r.name) like lower(concat('%', :name, '%'))")
    List<Room> findByNameLowerCaseLike(@Param("name") String name);
}
