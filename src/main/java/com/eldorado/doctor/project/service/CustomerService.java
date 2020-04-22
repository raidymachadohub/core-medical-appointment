package com.eldorado.doctor.project.service;

import com.eldorado.doctor.project.builder.CustomerBuilder;
import com.eldorado.doctor.project.dto.CustomerDto;
import com.eldorado.doctor.project.model.Customer;
import com.eldorado.doctor.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> findAll() {
        return CustomerBuilder.convert(this.customerRepository.findAll());
    }

    public CustomerDto findById(Long id) {
        return new CustomerDto(this.customerRepository.findById(id).get());
    }

    public CustomerDto save(CustomerDto dto) {
        Customer customer = CustomerBuilder.convert(dto);
        return new CustomerDto(this.customerRepository.save(customer));
    }

    public CustomerDto update(CustomerDto dto, Long id) {
        Customer customerBase = this.customerRepository.getOne(id);
        Customer customer = CustomerBuilder.merge(customerBase, dto);
        customer.setDt_update(new Date());
        return new CustomerDto(this.customerRepository.save((customer)));
    }

    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

}
