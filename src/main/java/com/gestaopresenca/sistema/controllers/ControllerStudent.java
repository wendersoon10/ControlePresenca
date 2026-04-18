package com.gestaopresenca.sistema.controllers;

import com.gestaopresenca.sistema.dto.StudentDTO;
import com.gestaopresenca.sistema.entities.DayOfWeek;
import com.gestaopresenca.sistema.entities.Shift;
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

    // ---------------- CREATE ----------------
    @PostMapping
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO dto) {

        Student saved = serviceStudent.save(dto);

        StudentDTO response = toDTO(saved);

        return ResponseEntity.status(201).body(response);
    }

    // ---------------- FIND ALL ----------------
    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {

        List<StudentDTO> list = serviceStudent.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    // ---------------- FIND BY ID ----------------
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {

        Student student = serviceStudent.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return ResponseEntity.ok(toDTO(student));
    }

    // ---------------- SEARCH BY NAME ----------------
    @GetMapping("/search")
    public ResponseEntity<List<StudentDTO>> findByName(@RequestParam String name) {

        List<StudentDTO> list = serviceStudent.findByName(name)
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    // ---------------- FILTER ----------------
    @GetMapping("/filter")
    public ResponseEntity<List<StudentDTO>> filter(
            @RequestParam Shift shift,
            @RequestParam DayOfWeek day) {

        List<StudentDTO> list = serviceStudent.findByShiftAndDay(shift, day)
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    // ---------------- UPDATE ----------------
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id,
                                             @RequestBody StudentDTO dto) {

        Student updated = serviceStudent.update(id, dto);

        return ResponseEntity.ok(toDTO(updated));
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        serviceStudent.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ---------------- MAPPER (TEMPORÁRIO) ----------------
    private StudentDTO toDTO(Student s) {
        StudentDTO dto = new StudentDTO();
        dto.setName(s.getName());
        dto.setWeeklyWorkload(s.getWeeklyWorkload());
        dto.setShift(s.getShift());
        dto.setDayOfWeek(s.getDayOfWeek());

        if (s.getTeacher() != null) {
            dto.setTeacherId(s.getTeacher().getId());
        }

        return dto;
    }
}