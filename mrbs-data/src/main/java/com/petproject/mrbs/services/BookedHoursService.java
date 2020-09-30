package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.BookedHours;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class BookedHoursService implements CrudService<BookedHours, Long>{
    @Override
    public Set<BookedHours> findAll() {
        return null;
    }

    @Override
    public BookedHours findById(Long aLong) {
        return null;
    }

    @Override
    public BookedHours save(BookedHours object) {
        return null;
    }

    @Override
    public void delete(BookedHours object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
