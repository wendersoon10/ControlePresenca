package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.entities.Student;


import com.gestaopresenca.sistema.services.ServiceStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class ControllerStudent {

    private final ServiceStudent serviceStudent;

    public ControllerStudent(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    @PostMapping
    public Student insert(@RequestBody Student student){
        return serviceStudent.save(student);
    }

    @GetMapping
    public List<Student> findAll(){
        return serviceStudent.findAll();
    }

    @GetMapping("/search")
    public List<Student> findByName(@RequestParam String name){
        return serviceStudent.findByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Student updated = serviceStudent.update(id, student);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceStudent.delete(id);
        return ResponseEntity.noContent().build();
    }



}
