package com.eldorado.doctor.project.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specialty")
    private Long id;


    @Column(name = "str_name")
    private String name;


    @Column(name = "dt_update")
    private Date dt_update;


    public Specialty(){}

    public Specialty(String name, Date dt_update){
        this.name = name;
        this.dt_update = dt_update;
    }

}
