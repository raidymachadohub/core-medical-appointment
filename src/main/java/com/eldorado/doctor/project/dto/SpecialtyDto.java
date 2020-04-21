package com.eldorado.doctor.project.dto;


import com.eldorado.doctor.project.model.Specialty;
import lombok.Getter;

import java.util.Date;

@Getter
public class SpecialtyDto {

    private Long id;

    private String name;

    private Date dt_update;

    public SpecialtyDto() {}

    public SpecialtyDto(Specialty specialty){
        this.id = specialty.getId();
        this.name = specialty.getName();
        this.dt_update = specialty.getDt_update();
    }
}
