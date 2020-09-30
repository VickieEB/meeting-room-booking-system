package com.petproject.mrbs.repositories;

import com.petproject.mrbs.domain.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
