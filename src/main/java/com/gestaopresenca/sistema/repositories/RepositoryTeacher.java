package com.gestaopresenca.sistema.repositories;

import com.gestaopresenca.sistema.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryTeacher extends JpaRepository<Teacher, Long> {
    List<Teacher> findByName(String name);
}
