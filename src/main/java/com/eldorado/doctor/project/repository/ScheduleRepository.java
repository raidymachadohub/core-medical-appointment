package com.eldorado.doctor.project.repository;

import com.eldorado.doctor.project.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
