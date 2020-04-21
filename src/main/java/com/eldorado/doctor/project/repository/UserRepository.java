package com.eldorado.doctor.project.repository;

import com.eldorado.doctor.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;


public interface UserRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT NEW com.eldorado.doctor.project.model.Customer(" +
            " name, photo, dt_update, username, password )" +
            " FROM Customer WHERE username = :p_user ")
    Optional<Customer> findByUsername(@Param("p_user") String username);

    @Query(value = "SELECT id FROM Customer WHERE username = :p_user")
    Integer existsByUsername(@Param("p_user") String username);

    // Boolean existsByEmail(String email);
}
