package com.eldorado.doctor.project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;


    @Column(name = "str_name")
    private String name;



    @Column(name = "str_photo")
    private String photo;


    @Column(name = "dt_update")
    private Date dt_update;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_roles",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_roles"))
    private Set<Roles> roles = new HashSet<>();


    public Customer() {
    }

    public Customer(String name, String photo, Date dt_update, String username, String password) {
        this.name = name;
        this.photo = photo;
        this.dt_update = dt_update;
        this.username = username;
        this.password = password;
    }
}
