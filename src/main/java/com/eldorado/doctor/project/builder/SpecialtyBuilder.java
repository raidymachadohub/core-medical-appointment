package com.eldorado.doctor.project.builder;


import com.eldorado.doctor.project.dto.SpecialtyDto;
import com.eldorado.doctor.project.model.Specialty;

import java.util.List;
import java.util.stream.Collectors;

public class SpecialtyBuilder {

    public static Specialty convert(SpecialtyDto dto){
        return new Specialty(dto.getName(), dto.getDt_update());
    }

    public static List<SpecialtyDto> convert(List<Specialty> specialties){
        return specialties.stream().map(SpecialtyDto::new).collect(Collectors.toList());
    }


    public static Specialty merge(Specialty baseSpecialty, SpecialtyDto dto){
        Specialty specialty = baseSpecialty;
        specialty.setName(dto.getName());
        specialty.setDt_update(dto.getDt_update());
        return specialty;
    }
}
