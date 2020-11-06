package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Booking;

import javax.transaction.Transactional;


@Transactional
public interface BookingService extends CrudService<Booking, Long>{
}
