package com.eldorado.doctor.project.dto;


import com.eldorado.doctor.project.model.Customer;
import com.eldorado.doctor.project.model.Doctor;
import com.eldorado.doctor.project.model.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleDto {

    private long id;

    private Date dt_appointment;

    private String str_appointment;

    private Customer customer_obj;

    private Doctor doctor_obj;

    private Date dt_update;

    public ScheduleDto(){}

    public ScheduleDto(Schedule schedule)
    {
        this.id = schedule.getId();
        this.dt_appointment = schedule.getDt_appointment();
        this.str_appointment = schedule.getStr_appointment();
        this.customer_obj = schedule.getCustomer();
        this.doctor_obj = schedule.getDoctor();
        this.dt_update = schedule.getDt_update();
    }

}
