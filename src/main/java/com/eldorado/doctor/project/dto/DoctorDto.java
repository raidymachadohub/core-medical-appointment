package com.eldorado.doctor.project.dto;

import com.eldorado.doctor.project.model.Doctor;
import com.eldorado.doctor.project.model.Specialty;
import lombok.Getter;

import java.util.Date;


@Getter
public class DoctorDto {

    private long id;

    private String name;

    private String crm;

    private Date dt_update;

    private Specialty specialty_obj;

    public DoctorDto() {
    }

    public DoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.crm = doctor.getCrm();
        this.dt_update = doctor.getDt_update();
        this.specialty_obj = doctor.getSpecialty();
    }

}
