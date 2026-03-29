package com.gestaopresenca.sistema.repositories;

import com.gestaopresenca.sistema.entities.PresenceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPresence extends JpaRepository<PresenceRegistration, Long> {
}
