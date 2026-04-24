package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.dto.PresenceDTO;
import com.gestaopresenca.sistema.services.ServicePresenceRegistration;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presence")
public class ControllerPresence {

    private final ServicePresenceRegistration service;

    public ControllerPresence(ServicePresenceRegistration service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PresenceDTO> insert(@RequestBody @Valid PresenceDTO dto) {
        return ResponseEntity.status(201).body(service.save(dto));
    }


    @GetMapping
    public ResponseEntity<List<PresenceDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenceDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PresenceDTO> update(@PathVariable Long id,
                                              @RequestBody PresenceDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}