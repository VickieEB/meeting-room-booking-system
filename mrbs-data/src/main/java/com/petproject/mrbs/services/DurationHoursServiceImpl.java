package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.DurationHours;
import com.petproject.mrbs.repositories.DurationHoursRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DurationHoursServiceImpl implements DurationHoursService {

    private DurationHoursRepository durationHoursRepository;

    public DurationHoursServiceImpl(DurationHoursRepository durationHoursRepository) {
        this.durationHoursRepository = durationHoursRepository;
    }

    @Override
    public Set<DurationHours> findAll() {
        Set<DurationHours> durationHours = new HashSet<>();
        durationHoursRepository.findAll().forEach(durationHours::add);
        return durationHours;
    }

    @Override
    public DurationHours findById(Long aLong) {
        return durationHoursRepository.findById(aLong).orElse(null);
    }

    @Override
    public DurationHours save(DurationHours object) {
        return durationHoursRepository.save(object);
    }

    @Override
    public void delete(DurationHours object) {
        durationHoursRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        durationHoursRepository.deleteById(aLong);
    }
}
