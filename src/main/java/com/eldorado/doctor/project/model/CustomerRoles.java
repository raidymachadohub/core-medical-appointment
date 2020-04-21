package com.eldorado.doctor.project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "customer_roles")
public class CustomerRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_roles")
    private Long id;

//    @ManyToOne
//    @Setter
//    @JoinColumn(name = "id_customer")
//    private Customer customer;
//
//
//    @ManyToOne
//    @Setter
//    @JoinColumn(name = "id_roles")
//    private Roles roles;


    public CustomerRoles(){}
}
