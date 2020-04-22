package com.eldorado.doctor.project.service;

import com.eldorado.doctor.project.enumerable.RolesEnum;
import com.eldorado.doctor.project.model.Customer;
import com.eldorado.doctor.project.model.Roles;
import com.eldorado.doctor.project.repository.RolesRepository;
import com.eldorado.doctor.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RolesRepository roleRepository;

    public Integer existsByUsername(String Username){
        return this.userRepository.existsByUsername(Username);
    }

    public Optional<Customer> findByUsername( String username){
        return this.userRepository.findByUsername(username);
    }

    public Roles findById(Long id){
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Cause: User Role not find."));
    }
}
