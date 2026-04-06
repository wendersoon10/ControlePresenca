package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.services.ServiceTeacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class ControllerTeacher {

    private final ServiceTeacher serviceTeacher;

    public ControllerTeacher(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    @PostMapping
    public Teacher insert(@RequestBody Teacher teacher) {
        return serviceTeacher.save(teacher);
    }

    @GetMapping
    public List<Teacher> findAll() {
        return serviceTeacher.findAll();
    }

    @GetMapping("/search")
    public Optional<Teacher> findByName(@RequestParam String name) {
        return serviceTeacher.findByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updated = serviceTeacher.update(id, teacher);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceTeacher.delete(id);
        return ResponseEntity.noContent().build();
    }
}