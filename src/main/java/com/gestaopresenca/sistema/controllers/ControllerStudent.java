package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.repositories.RepositoryTeacher;
import com.gestaopresenca.sistema.services.ServiceStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class ControllerStudent {

    private final ServiceStudent serviceStudent;
    private final RepositoryTeacher teacherRepository;

    public ControllerStudent(ServiceStudent serviceStudent, RepositoryTeacher teacherRepository) {
        this.serviceStudent = serviceStudent;
        this.teacherRepository = teacherRepository;
    }

    // Criar aluno
    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student) {
        // Buscar professor pelo ID, se fornecido
        if (student.getTeacher() != null && student.getTeacher().getId() != null) {
            Teacher teacher = teacherRepository.findById(student.getTeacher().getId())
                    .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
            student.setTeacher(teacher);
        }

        Student saved = serviceStudent.save(student);
        return ResponseEntity.ok(saved);
    }

    // Listar todos os alunos
    @GetMapping
    public List<Student> findAll() {
        return serviceStudent.findAll();
    }

    // Buscar alunos por nome
    @GetMapping("/search")
    public List<Student> findByName(@RequestParam String name) {
        return serviceStudent.findByName(name);
    }

    // Atualizar aluno
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        // Atualizar professor se fornecido
        if (student.getTeacher() != null && student.getTeacher().getId() != null) {
            Teacher teacher = teacherRepository.findById(student.getTeacher().getId())
                    .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
            student.setTeacher(teacher);
        }

        Student updated = serviceStudent.update(id, student);
        return ResponseEntity.ok(updated);
    }

    // Deletar aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceStudent.delete(id);
        return ResponseEntity.noContent().build();
    }
}