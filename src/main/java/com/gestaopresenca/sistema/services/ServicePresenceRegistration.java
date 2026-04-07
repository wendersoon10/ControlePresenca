package com.gestaopresenca.sistema.services;


import com.gestaopresenca.sistema.entities.PresenceRegistration;
import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.repositories.RepositoryPresence;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePresenceRegistration {

    private final RepositoryPresence repositoryPresence;

    public ServicePresenceRegistration(RepositoryPresence repositoryPresence) {
        this.repositoryPresence = repositoryPresence;
    }

    public PresenceRegistration save(PresenceRegistration presenceRegistration) {
        return repositoryPresence.save(presenceRegistration);
    }

    public List<PresenceRegistration> findAll() {
        return repositoryPresence.findAll();
    }

    public Optional<PresenceRegistration> findById(Long id) {
        return repositoryPresence.findById(id);
    }

    public PresenceRegistration update(Long id, PresenceRegistration presenceRegistration) {
        PresenceRegistration pr = repositoryPresence.findById(id)
                .orElseThrow(() -> new RuntimeException("Presença não registrada"));
        pr.setDate(presenceRegistration.getDate());
        pr.setEntryTime(presenceRegistration.getEntryTime());
        pr.setExitTime(presenceRegistration.getExitTime());
        pr.setAttendanceType(presenceRegistration.getAttendanceType());

        return repositoryPresence.save(pr);
    }

    public void delete(Long id){
        if(!repositoryPresence.existsById(id)){
            throw new RuntimeException("Presença não registrada");
        }
        repositoryPresence.deleteById(id);
    }

    public List<PresenceRegistration> findByStudent(Student student){
        return repositoryPresence.findByStudent(student);
    }


}