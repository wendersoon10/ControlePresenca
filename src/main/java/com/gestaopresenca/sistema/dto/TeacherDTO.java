package com.gestaopresenca.sistema.dto;

import com.gestaopresenca.sistema.enums.Shift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TeacherDTO {

    @NotBlank(message = "Nome não pode ser vazio")
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

    public void setId(Long id) {

    }
}
