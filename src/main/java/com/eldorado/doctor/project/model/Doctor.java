package com.eldorado.doctor.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long id;

    @Setter
    @Column(name = "str_name")
    private String name;


    @Setter
    @Column(name = "str_crm")
    private String crm;

    @Setter
    @Column(name = "dt_update")
    private Date dt_update;

    @ManyToOne
    @Setter
    @JoinColumn(name = "id_specialty")
    private Specialty specialty;

    public Doctor(){}

    public Doctor(String name, String crm, Date dt_update, Specialty specialty){
        this.name = name;
        this.crm = crm;
        this.dt_update = dt_update;
        this.specialty = specialty;
    }
}
