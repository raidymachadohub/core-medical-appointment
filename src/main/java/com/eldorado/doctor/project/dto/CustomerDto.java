package com.eldorado.doctor.project.dto;


import com.eldorado.doctor.project.model.Customer;
import lombok.Getter;

import java.util.Date;

@Getter
public class CustomerDto {

    private long id;

    private String name;

    private String photo;

    private Date dt_update;

    private String username;

    private String password;

    public CustomerDto(){}

    public CustomerDto(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.photo = customer.getPhoto();
        this.dt_update = customer.getDt_update();
        this.username = customer.getUsername();
    }
}
