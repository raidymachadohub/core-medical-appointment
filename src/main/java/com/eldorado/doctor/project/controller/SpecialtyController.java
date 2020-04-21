package com.eldorado.doctor.project.controller;

import com.eldorado.doctor.project.dto.SpecialtyDto;
import com.eldorado.doctor.project.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SpecialtyController extends BaseController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping(path = "/specialty")
    public List<SpecialtyDto> findAll() {
        return this.specialtyService.findAll();
    }


    @GetMapping(path = "/specialty/{id}")
    public SpecialtyDto findById(@PathVariable("id") Long id) {
        return this.specialtyService.findById(id);
    }

    @PostMapping("/specialty")
    public SpecialtyDto save(@RequestBody SpecialtyDto specialtyDto) {
        return this.specialtyService.save(specialtyDto);
    }

    @PutMapping(path = "/specialty/{id}")
    public SpecialtyDto update(@RequestBody SpecialtyDto specialtyDto, @PathVariable("id") Long id) {
        return this.specialtyService.update(specialtyDto, id);
    }

    @DeleteMapping(path = "/specialty/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            this.specialtyService.delete(id);
            return new ResponseEntity<String>("Delete success!",
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.toString(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
