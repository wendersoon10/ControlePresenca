package com.gestaopresenca.sistema.repositories;

import com.gestaopresenca.sistema.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryTeacher extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByName(String name);


}
