package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.repositories.RepositoryTeacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class ControllerTeacher {

    private final RepositoryTeacher repositoryTeacher;

    public ControllerTeacher(RepositoryTeacher repositoryTeacher) {
        this.repositoryTeacher = repositoryTeacher;
    }

    @PostMapping
    public Teacher insert(@RequestBody Teacher teacher) {
        return repositoryTeacher.save(teacher);
    }

    @GetMapping
    public List<Teacher> findAll() {
        return repositoryTeacher.findAll();
    }

    @GetMapping("/search")
    public List<Teacher> findByName(@RequestParam String name) {
        return repositoryTeacher.findByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        return repositoryTeacher.findById(id)
                .map(teacher -> {
                    teacher.setName(updatedTeacher.getName());
                    Teacher savedTeacher = repositoryTeacher.save(teacher);
                    return ResponseEntity.ok(savedTeacher);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        return repositoryTeacher.findById(id)
                .map(teacher -> {
                    repositoryTeacher.delete(teacher);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}