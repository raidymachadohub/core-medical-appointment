package com.eldorado.doctor.project.controller;

import com.eldorado.doctor.project.dto.ScheduleDto;
import com.eldorado.doctor.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController extends BaseController{

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path = "/schedule")
    public List<ScheduleDto> findAll() {
        return this.scheduleService.findAll();
    }


    @GetMapping(path = "/schedule/{id}")
    public ScheduleDto findById(@PathVariable("id") Long id) {
        return this.scheduleService.findById(id);
    }

    @PostMapping("/schedule")
    public ScheduleDto save(@RequestBody ScheduleDto scheduleDto) {
        return this.scheduleService.save(scheduleDto);
    }

    @PutMapping(path = "/schedule/{id}")
    public ScheduleDto update(@RequestBody ScheduleDto scheduleDto, @PathVariable("id") Long id) {
        return this.scheduleService.update(scheduleDto, id);
    }

    @DeleteMapping(path = "/schedule/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            this.scheduleService.delete(id);
            return new ResponseEntity<String>("Delete success!",
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.toString(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
