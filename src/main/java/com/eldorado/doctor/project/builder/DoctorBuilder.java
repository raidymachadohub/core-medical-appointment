package com.eldorado.doctor.project.builder;

import com.eldorado.doctor.project.dto.DoctorDto;
import com.eldorado.doctor.project.model.Doctor;

import java.util.List;
import java.util.stream.Collectors;


public class DoctorBuilder {

    public static Doctor convert(DoctorDto dto){
        return new Doctor(dto.getName(),dto.getCrm(),dto.getDt_update(), dto.getSpecialty_obj());
    }

    public static List<DoctorDto> convert(List<Doctor> doctors){
        return doctors.stream().map(DoctorDto::new).collect(Collectors.toList());
    }

    public static Doctor merge(Doctor baseDoctor, DoctorDto dto){
        Doctor doctor = baseDoctor;
        doctor.setName(dto.getName());
        doctor.setCrm(dto.getCrm());
        doctor.setSpecialty(dto.getSpecialty_obj());
        doctor.setDt_update(dto.getDt_update());
        return doctor;
    }
}
