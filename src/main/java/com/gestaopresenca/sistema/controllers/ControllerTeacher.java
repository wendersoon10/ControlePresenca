package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.dto.TeacherDTO;
import com.gestaopresenca.sistema.services.ServiceTeacher;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class ControllerTeacher {

    private final ServiceTeacher serviceTeacher;

    public ControllerTeacher(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }


    @PostMapping
    public ResponseEntity<TeacherDTO> insert(@RequestBody @Valid TeacherDTO dto) {
        TeacherDTO saved = serviceTeacher.save(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll() {
        return ResponseEntity.ok(serviceTeacher.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceTeacher.findById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<TeacherDTO> findByName(@RequestParam String name) {
        return ResponseEntity.ok(serviceTeacher.findByName(name));
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> update(@PathVariable Long id,
                                             @RequestBody TeacherDTO dto) {
        return ResponseEntity.ok(serviceTeacher.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceTeacher.delete(id);
        return ResponseEntity.noContent().build();
    }
}