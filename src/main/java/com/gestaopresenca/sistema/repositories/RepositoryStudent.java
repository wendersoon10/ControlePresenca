package com.gestaopresenca.sistema.repositories;

import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.enums.DayOfWeek;
import com.gestaopresenca.sistema.enums.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryStudent extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByShiftAndDayOfWeek(Shift shift, DayOfWeek dayOfWeek);


}
