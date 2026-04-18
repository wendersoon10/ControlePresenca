package com.gestaopresenca.sistema.dto;

import com.gestaopresenca.sistema.entities.DayOfWeek;
import com.gestaopresenca.sistema.entities.Shift;

public class StudentDTO {

    private String name;
    private Integer weeklyWorkload;
    private Shift shift;
    private DayOfWeek dayOfWeek;
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
