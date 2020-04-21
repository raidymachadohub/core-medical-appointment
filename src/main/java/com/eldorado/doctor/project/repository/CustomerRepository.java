package com.eldorado.doctor.project.repository;

import com.eldorado.doctor.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT  C.id_customer as id,C.username, C.password FROM Customer C WHERE C.username = ?1 and c.password = ?2", nativeQuery = true)
    Customer findUserByPassword(@Param("p_user") String username, @Param("p_password") String password);

    @Query(value = "SELECT  C.id_customer as id,C.username, C.password FROM Customer C WHERE C.username = ?1 ", nativeQuery = true)
    Customer findUserByEmail(@Param("p_user") String username);
}
