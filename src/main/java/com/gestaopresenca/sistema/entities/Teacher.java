package com.gestaopresenca.sistema.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Student> students = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(@JsonProperty("name") String name, @JsonProperty("shift") Shift shift) {
        this.name = name;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Shift getShift() {
        return shift;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}