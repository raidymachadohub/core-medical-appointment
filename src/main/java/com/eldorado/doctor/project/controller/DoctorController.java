package com.eldorado.doctor.project.controller;


import com.eldorado.doctor.project.dto.DoctorDto;
import com.eldorado.doctor.project.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DoctorController extends BaseController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "/doctor")
    public List<DoctorDto> findAll() {
        return this.doctorService.findAll();
    }


    @GetMapping(path = "/doctor/{id}")
    public DoctorDto findById(@PathVariable("id") Long id) {
        return this.doctorService.findById(id);
    }

    @PostMapping("/doctor")
    public DoctorDto save(@RequestBody DoctorDto doctorDto) {
        return this.doctorService.save(doctorDto);
    }

    @PutMapping(path = "/doctor/{id}")
    public DoctorDto update(@RequestBody DoctorDto doctor, @PathVariable("id") Long id) {
        return this.doctorService.update(doctor, id);
    }

    @DeleteMapping(path = "/doctor/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            this.doctorService.delete(id);
            return new ResponseEntity<String>("Delete success!",
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.toString(),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
