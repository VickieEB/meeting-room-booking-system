package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.Booking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class BookingService implements CrudService<Booking, Long>{
    @Override
    public Set<Booking> findAll() {
        return null;
    }

    @Override
    public Booking findById(Long aLong) {
        return null;
    }

    @Override
    public Booking save(Booking object) {
        return null;
    }

    @Override
    public void delete(Booking object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
