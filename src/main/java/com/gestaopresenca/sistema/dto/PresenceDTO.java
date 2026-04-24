package com.gestaopresenca.sistema.dto;

import com.gestaopresenca.sistema.enums.AttendanceType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PresenceDTO {

    private Long id;

    @NotNull(message = "Data é obrigatória")
    private LocalDate date;

    @NotNull(message = "Horário de entrada é obrigatório")
    private LocalDateTime entryTime;

    @NotNull(message = "Horário de saída é obrigatório")
    private LocalDateTime exitTime;

    @NotNull(message = "Tipo de presença é obrigatório")
    private AttendanceType attendanceType;

    @NotNull(message = "Aluno é obrigatório")
    private Long studentId;


    public PresenceDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}