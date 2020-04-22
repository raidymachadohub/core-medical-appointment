package com.eldorado.doctor.project.model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Long id;


    @Column(name = "str_name")
    private String name;


    public Roles(){}

    public Roles(String name){
        this.name = name;
    }
}
