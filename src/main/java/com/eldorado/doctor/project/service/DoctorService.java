package com.eldorado.doctor.project.service;

import com.eldorado.doctor.project.builder.DoctorBuilder;
import com.eldorado.doctor.project.dto.DoctorDto;
import com.eldorado.doctor.project.model.Doctor;
import com.eldorado.doctor.project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDto> findAll() {
        return DoctorBuilder.convert(this.doctorRepository.findAll());
    }


    public DoctorDto findById(Long id) {
        return new DoctorDto(this.doctorRepository.findById(id).get());
    }

    public DoctorDto save(DoctorDto doctorDto) {
        Doctor doctor = DoctorBuilder.convert(doctorDto);
        return new DoctorDto(this.doctorRepository.save((doctor)));
    }

    public DoctorDto update(DoctorDto doctorDto, Long id) {
        Doctor doctorBase = this.doctorRepository.getOne(id);
        Doctor doctor = DoctorBuilder.merge(doctorBase, doctorDto);
        doctor.setDt_update(new Date());
        return new DoctorDto(this.doctorRepository.save((doctor)));
    }

    public void delete(Long id) {
        this.doctorRepository.deleteById(id);
    }

}
