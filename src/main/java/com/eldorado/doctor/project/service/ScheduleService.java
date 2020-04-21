package com.eldorado.doctor.project.service;


import com.eldorado.doctor.project.builder.ScheduleBuilder;
import com.eldorado.doctor.project.dto.ScheduleDto;
import com.eldorado.doctor.project.model.Schedule;
import com.eldorado.doctor.project.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    public List<ScheduleDto> findAll() {
        return ScheduleBuilder.convert(this.scheduleRepository.findAll());
    }


    public ScheduleDto findById(Long id) {
        return new ScheduleDto(this.scheduleRepository.findById(id).get());
    }

    public ScheduleDto save(ScheduleDto scheduleDto) {
        Schedule schedule = ScheduleBuilder.convert(scheduleDto);
        return new ScheduleDto(this.scheduleRepository.save((schedule)));
    }

    public ScheduleDto update(ScheduleDto scheduleDto, Long id) {
        Schedule scheduleBase = this.scheduleRepository.getOne(id);
        Schedule schedule = ScheduleBuilder.merge(scheduleBase, scheduleDto);
        schedule.setDt_update(new Date());
        return new ScheduleDto(this.scheduleRepository.save((schedule)));
    }

    public void delete(Long id) {
        this.scheduleRepository.deleteById(id);
    }

}
