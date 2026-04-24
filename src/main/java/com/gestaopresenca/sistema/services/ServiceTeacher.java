package com.gestaopresenca.sistema.services;

import com.gestaopresenca.sistema.dto.TeacherDTO;
import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.repositories.RepositoryTeacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTeacher {

    private final RepositoryTeacher repositoryTeacher;

    public ServiceTeacher(RepositoryTeacher repositoryTeacher) {
        this.repositoryTeacher = repositoryTeacher;
    }


    public TeacherDTO save(TeacherDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setShift(dto.getShift());

        Teacher saved = repositoryTeacher.save(teacher);

        return toDTO(saved);
    }

    public List<TeacherDTO> findAll() {
        return repositoryTeacher.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }


    public TeacherDTO findById(Long id) {
        Teacher teacher = repositoryTeacher.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado: " + id));

        return toDTO(teacher);
    }


    public TeacherDTO findByName(String name) {
        Teacher teacher = repositoryTeacher.findByName(name)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        return toDTO(teacher);
    }


    public TeacherDTO update(Long id, TeacherDTO dto) {
        Teacher teacher = repositoryTeacher.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado: " + id));

        teacher.setName(dto.getName());
        teacher.setShift(dto.getShift());

        Teacher updated = repositoryTeacher.save(teacher);

        return toDTO(updated);
    }


    public void delete(Long id) {
        if (!repositoryTeacher.existsById(id)) {
            throw new RuntimeException("Professor não encontrado: " + id);
        }
        repositoryTeacher.deleteById(id);
    }


    private TeacherDTO toDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setShift(teacher.getShift());
        return dto;
    }
}