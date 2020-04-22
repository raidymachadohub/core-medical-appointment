package com.eldorado.doctor.project.controller;

import com.eldorado.doctor.project.dto.CustomerDto;
import com.eldorado.doctor.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController  extends BaseController{

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customer")
    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }


    @GetMapping(path = "/customer/{id}")
    public CustomerDto findById(@PathVariable("id") Long id) {
        return this.customerService.findById(id);
    }

    @PostMapping("/customer")
    public CustomerDto save(@RequestBody CustomerDto customerDto) {
        return this.customerService.save(customerDto);
    }

    @PutMapping(path = "/customer/{id}")
    public CustomerDto update(@RequestBody CustomerDto customerDto, @PathVariable("id") Long id) {
        return this.customerService.update(customerDto, id);
    }

    @DeleteMapping(path = "/customer/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            this.customerService.delete(id);
            return new ResponseEntity<String>("Delete success!",
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.toString(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
