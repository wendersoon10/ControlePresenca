package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.entities.PresenceRegistration;
import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.services.ServicePresenceRegistration;
import com.gestaopresenca.sistema.services.ServiceStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presences")
public class ControllerPresence {

    private final ServicePresenceRegistration servicePresenceRegistration;
    private final ServiceStudent studentService;

    public ControllerPresence(ServicePresenceRegistration servicePresenceRegistration,
                              ServiceStudent studentService) {
        this.servicePresenceRegistration = servicePresenceRegistration;
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<PresenceRegistration> insert(@RequestBody PresenceRegistration pr){
        PresenceRegistration saved = servicePresenceRegistration.save(pr);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<PresenceRegistration> findAll(){
        return servicePresenceRegistration.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenceRegistration> findById(@PathVariable Long id){
        PresenceRegistration pr = servicePresenceRegistration.findById(id)
                .orElseThrow(() -> new RuntimeException("Presença não encontrada"));
        return ResponseEntity.ok(pr);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PresenceRegistration> update(@PathVariable Long id,
                                                       @RequestBody PresenceRegistration presenceRegistration){
        PresenceRegistration updated = servicePresenceRegistration.update(id, presenceRegistration);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/student/{id}")
    public List<PresenceRegistration> findByStudent(@PathVariable Long id){

        Student student = studentService.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return servicePresenceRegistration.findByStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        servicePresenceRegistration.delete(id);
        return ResponseEntity.noContent().build();
    }
}