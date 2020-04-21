package com.eldorado.doctor.project.builder;

import com.eldorado.doctor.project.dto.ScheduleDto;
import com.eldorado.doctor.project.model.Schedule;


import java.util.List;
import java.util.stream.Collectors;

public class ScheduleBuilder {

    public static Schedule convert(ScheduleDto dto){
        return new Schedule(dto.getDt_appointment(), dto.getStr_appointment(), dto.getCustomer_obj(), dto.getDoctor_obj(), dto.getDt_update());
    }

    public static List<ScheduleDto> convert(List<Schedule> schedules){
        return schedules.stream().map(ScheduleDto::new).collect(Collectors.toList());
    }


    public static Schedule merge(Schedule baseSchedule, ScheduleDto dto){
        Schedule schedule = baseSchedule;
        schedule.setDt_appointment(dto.getDt_appointment());
        schedule.setStr_appointment(dto.getStr_appointment());
        schedule.setCustomer(dto.getCustomer_obj());
        schedule.setDoctor(dto.getDoctor_obj());
        return schedule;
    }
}
