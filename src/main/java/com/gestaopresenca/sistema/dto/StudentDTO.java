package com.gestaopresenca.sistema.dto;

import com.gestaopresenca.sistema.enums.DayOfWeek;
import com.gestaopresenca.sistema.enums.Shift;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {

    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @NotNull(message = "Carga horária é obrigatória")
    @Min(value = 1, message = "Carga horária deve ser maior que 0")
    private Integer weeklyWorkload;
    @NotNull(message = "Turno é obrigatório")
    private Shift shift;
    @NotNull(message = "Dia da semana é obrigatório")
    private DayOfWeek dayOfWeek;
    @NotNull(message = "Professor é obrigatório")
    private Long teacherId;

    public StudentDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeeklyWorkload() {
        return weeklyWorkload;
    }

    public void setWeeklyWorkload(Integer weeklyWorkload) {
        this.weeklyWorkload = weeklyWorkload;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
