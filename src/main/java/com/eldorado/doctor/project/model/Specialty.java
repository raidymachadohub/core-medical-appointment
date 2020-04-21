package com.eldorado.doctor.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specialty")
    private Long id;

    @Setter
    @Column(name = "str_name")
    private String name;

    @Setter
    @Column(name = "dt_update")
    private Date dt_update;


    public Specialty(){}

    public Specialty(String name, Date dt_update){
        this.name = name;
        this.dt_update = dt_update;
    }

}
