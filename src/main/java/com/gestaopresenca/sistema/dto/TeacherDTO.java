package com.gestaopresenca.sistema.dto;

import com.gestaopresenca.sistema.entities.Shift;

public class TeacherDTO {

    private String name;
    private Shift shift;

    public TeacherDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
