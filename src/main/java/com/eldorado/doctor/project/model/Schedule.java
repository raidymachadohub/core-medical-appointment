package com.eldorado.doctor.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule")
    private Long id;

    @Setter
    @Column(name = "dt_appointment")
    private Date dt_appointment;

    @Setter
    @Column(name = "str_appointment")
    private String str_appointment;

    @ManyToOne
    @Setter
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @Setter
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @Setter
    @Column(name = "dt_update")
    private Date dt_update;


    public Schedule(){}

    public Schedule(Date dt_appointment, String str_appointment, Customer customer, Doctor doctor, Date dt_update){
        this.dt_appointment = dt_appointment;
        this.str_appointment = str_appointment;
        this.customer = customer;
        this.doctor = doctor;
        this.dt_update = dt_update;
    }


}
