package com.eldorado.doctor.project.repository;

import com.eldorado.doctor.project.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
