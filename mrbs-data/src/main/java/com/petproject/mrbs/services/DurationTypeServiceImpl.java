package com.petproject.mrbs.services;

import com.petproject.mrbs.domain.DurationType;
import com.petproject.mrbs.repositories.DurationTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DurationTypeServiceImpl implements DurationTypeService {

    private DurationTypeRepository durationTypeRepository;

    public DurationTypeServiceImpl(DurationTypeRepository durationTypeRepository) {
        this.durationTypeRepository = durationTypeRepository;
    }

    @Override
    public Set<DurationType> findAll() {
        Set<DurationType> durationTypes = new HashSet<>();
        durationTypeRepository.findAll().forEach(durationTypes::add);
        return durationTypes;
    }

    @Override
    public DurationType findById(Long aLong) {
        return durationTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public DurationType save(DurationType object) {
        return durationTypeRepository.save(object);
    }

    @Override
    public void delete(DurationType object) {
        durationTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        durationTypeRepository.deleteById(aLong);
    }
}
