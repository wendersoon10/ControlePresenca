package com.gestaopresenca.sistema.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gestaopresenca.sistema.enums.DayOfWeek;
import com.gestaopresenca.sistema.enums.Shift;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer weeklyWorkload;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;

    public Student(){
    }

    public Student(Long id, String name, Integer weeklyWorkload, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.weeklyWorkload = weeklyWorkload;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeeklyWorkload() {
        return weeklyWorkload;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeeklyWorkload(int weeklyWorkload) {
        this.weeklyWorkload = weeklyWorkload;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
