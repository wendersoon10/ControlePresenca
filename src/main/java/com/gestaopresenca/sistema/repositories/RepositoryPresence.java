package com.gestaopresenca.sistema.repositories;

import com.gestaopresenca.sistema.entities.PresenceRegistration;
import com.gestaopresenca.sistema.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryPresence extends JpaRepository<PresenceRegistration, Long> {
    List<PresenceRegistration> findByStudent(Student student);
}
