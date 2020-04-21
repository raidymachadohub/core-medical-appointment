package com.eldorado.doctor.project.service;

import com.eldorado.doctor.project.builder.SpecialtyBuilder;
import com.eldorado.doctor.project.dto.SpecialtyDto;
import com.eldorado.doctor.project.model.Specialty;
import com.eldorado.doctor.project.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyDto> findAll() {
        return SpecialtyBuilder.convert(this.specialtyRepository.findAll());
    }


    public SpecialtyDto findById(Long id) {
        return new SpecialtyDto(this.specialtyRepository.findById(id).get());
    }

    public SpecialtyDto save(SpecialtyDto specialtyDto) {
        Specialty specialty = SpecialtyBuilder.convert(specialtyDto);
        return new SpecialtyDto(this.specialtyRepository.save((specialty)));
    }

    public SpecialtyDto update(SpecialtyDto specialtyDto, Long id) {
        Specialty specialtyBase = this.specialtyRepository.getOne(id);
        Specialty specialty = SpecialtyBuilder.merge(specialtyBase, specialtyDto);
        specialty.setDt_update(new Date());
        return new SpecialtyDto(this.specialtyRepository.save((specialty)));
    }

    public void delete(Long id) {
        this.specialtyRepository.deleteById(id);
    }

}
