package com.petproject.mrbs.repositories;

import com.petproject.mrbs.domain.BookedHours;
import org.springframework.data.repository.CrudRepository;

public interface BookedHoursRepository extends CrudRepository<BookedHours, Long> {
}
