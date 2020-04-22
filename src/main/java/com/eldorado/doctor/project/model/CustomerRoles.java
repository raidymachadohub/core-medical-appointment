package com.eldorado.doctor.project.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_roles")
public class CustomerRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_roles")
    private Long id;

    public CustomerRoles(){}
}
