package com.gestaopresenca.sistema.repositories;

import com.gestaopresenca.sistema.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStudent extends JpaRepository<Student, Long> {
}
