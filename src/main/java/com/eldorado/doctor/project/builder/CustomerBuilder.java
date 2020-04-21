package com.eldorado.doctor.project.builder;

import com.eldorado.doctor.project.dto.CustomerDto;
import com.eldorado.doctor.project.model.Customer;

import java.util.List;
import java.util.stream.Collectors;


public class CustomerBuilder {


    public static Customer convert(CustomerDto dto){
        return new Customer(dto.getName(), dto.getPhoto(), dto.getDt_update(), dto.getUsername(), dto.getPassword());
    }

    public static List<CustomerDto> convert(List<Customer> customers){
        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
    }


    public static Customer merge(Customer baseCustomer, CustomerDto dto){
        Customer customer = baseCustomer;
        customer.setName(dto.getName());
        customer.setPhoto(dto.getPhoto());
        customer.setDt_update(dto.getDt_update());
        customer.setUsername(dto.getUsername());
        customer.setPassword(dto.getPassword());
        return customer;
    }
}
