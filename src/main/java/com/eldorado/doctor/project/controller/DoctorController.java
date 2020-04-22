package com.eldorado.doctor.project.controller;


import com.eldorado.doctor.project.dto.DoctorDto;
import com.eldorado.doctor.project.model.Message;
import com.eldorado.doctor.project.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
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
    public DoctorDto update(@PathVariable("id") Long id, @RequestBody DoctorDto doctor) {
        return this.doctorService.update(doctor, id);
    }

    @DeleteMapping(path = "/doctor/{id}")
    public Message delete(@PathVariable("id") Long id) {
        Message message = new Message();
        try {
            this.doctorService.delete(id);
            message.setCode(200);
            message.setMessage("Deletado com sucesso");
            return message;
        } catch (Exception ex) {
            message.setCode(400);
            message.setMessage(ex.getMessage());
            return message;
        }
    }

}
