package com.eldorado.doctor.project.repository;

import com.eldorado.doctor.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
