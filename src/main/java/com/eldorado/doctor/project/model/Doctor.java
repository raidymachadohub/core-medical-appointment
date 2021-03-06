package com.eldorado.doctor.project.model;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long id;

    @Column(name = "str_name")
    private String name;


    @Column(name = "str_crm")
    private String crm;

    @Column(name = "dt_update")
    private Date dt_update;

    @ManyToOne
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
