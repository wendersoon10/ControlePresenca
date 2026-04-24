package com.gestaopresenca.sistema.services;

import com.gestaopresenca.sistema.dto.PresenceDTO;
import com.gestaopresenca.sistema.entities.PresenceRegistration;
import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.repositories.RepositoryPresence;
import com.gestaopresenca.sistema.repositories.RepositoryStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePresenceRegistration {

    private final RepositoryPresence repositoryPresence;
    private final RepositoryStudent repositoryStudent;

    public ServicePresenceRegistration(RepositoryPresence repositoryPresence,
                                       RepositoryStudent repositoryStudent) {
        this.repositoryPresence = repositoryPresence;
        this.repositoryStudent = repositoryStudent;
    }


    public PresenceDTO save(PresenceDTO dto) {

        Student student = repositoryStudent.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        PresenceRegistration pr = new PresenceRegistration();
        pr.setDate(dto.getDate());
        pr.setEntryTime(dto.getEntryTime());
        pr.setExitTime(dto.getExitTime());
        pr.setAttendanceType(dto.getAttendanceType());
        pr.setStudent(student);

        PresenceRegistration saved = repositoryPresence.save(pr);

        return toDTO(saved);
    }


    public List<PresenceDTO> findAll() {
        return repositoryPresence.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }


    public PresenceDTO findById(Long id) {
        PresenceRegistration pr = repositoryPresence.findById(id)
                .orElseThrow(() -> new RuntimeException("Presença não encontrada"));

        return toDTO(pr);
    }


    public PresenceDTO update(Long id, PresenceDTO dto) {

        PresenceRegistration pr = repositoryPresence.findById(id)
                .orElseThrow(() -> new RuntimeException("Presença não encontrada"));

        pr.setDate(dto.getDate());
        pr.setEntryTime(dto.getEntryTime());
        pr.setExitTime(dto.getExitTime());
        pr.setAttendanceType(dto.getAttendanceType());

        if (dto.getStudentId() != null) {
            Student student = repositoryStudent.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
            pr.setStudent(student);
        }

        return toDTO(repositoryPresence.save(pr));
    }


    public void delete(Long id) {
        if (!repositoryPresence.existsById(id)) {
            throw new RuntimeException("Presença não encontrada");
        }
        repositoryPresence.deleteById(id);
    }


    private PresenceDTO toDTO(PresenceRegistration pr) {
        PresenceDTO dto = new PresenceDTO();
        dto.setId(pr.getId());
        dto.setDate(pr.getDate());
        dto.setEntryTime(pr.getEntryTime());
        dto.setExitTime(pr.getExitTime());
        dto.setAttendanceType(pr.getAttendanceType());

        if (pr.getStudent() != null) {
            dto.setStudentId(pr.getStudent().getId());
        }

        return dto;
    }
}