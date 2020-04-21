package com.eldorado.doctor.project.repository;

import com.eldorado.doctor.project.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
}
