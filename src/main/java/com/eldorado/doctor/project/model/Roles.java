package com.eldorado.doctor.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Long id;

    @Setter
    @Column(name = "str_name")
    private String name;


    public Roles(){}

    public Roles(String name){
        this.name = name;
    }
}
