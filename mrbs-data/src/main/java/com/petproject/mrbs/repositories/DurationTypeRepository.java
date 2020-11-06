package com.petproject.mrbs.repositories;

import com.petproject.mrbs.domain.DurationType;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface DurationTypeRepository extends CrudRepository<DurationType, Long> {
}
