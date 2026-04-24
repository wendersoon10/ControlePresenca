package com.gestaopresenca.sistema.services;

import com.gestaopresenca.sistema.dto.StudentDTO;
import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.enums.DayOfWeek;
import com.gestaopresenca.sistema.enums.Shift;
import com.gestaopresenca.sistema.exceptions.ResourceNotFoundException;
import com.gestaopresenca.sistema.repositories.RepositoryStudent;
import com.gestaopresenca.sistema.repositories.RepositoryTeacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStudent {

    private final RepositoryStudent repositoryStudent;
    private final RepositoryTeacher repositoryTeacher;

    public ServiceStudent(RepositoryStudent repositoryStudent,
                          RepositoryTeacher repositoryTeacher) {
        this.repositoryStudent = repositoryStudent;
        this.repositoryTeacher = repositoryTeacher;
    }


    public Student save(StudentDTO dto) {

        if (dto.getTeacherId() == null) {
            throw new RuntimeException("Teacher ID é obrigatório para criar um estudante");
        }

        Teacher teacher = repositoryTeacher.findById(dto.getTeacherId())
                .orElseThrow(() ->
                        new RuntimeException("Professor não encontrado: " + dto.getTeacherId())
                );

        Student student = new Student();
        student.setName(dto.getName());
        student.setWeeklyWorkload(dto.getWeeklyWorkload());
        student.setShift(dto.getShift());
        student.setDayOfWeek(dto.getDayOfWeek());
        student.setTeacher(teacher);

        return repositoryStudent.save(student);
    }


    public List<Student> findByShiftAndDay(Shift shift, DayOfWeek dayOfWeek){
        return repositoryStudent.findByShiftAndDayOfWeek(shift, dayOfWeek);
    }

    public List<Student> findAll(){
        return repositoryStudent.findAll();
    }


    public List<Student> findByName(String name){
        return repositoryStudent.findByName(name);
    }


    public Student update(Long id, StudentDTO dto){

        Student s = repositoryStudent.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado: " + id));

        s.setName(dto.getName());
        s.setWeeklyWorkload(dto.getWeeklyWorkload());
        s.setShift(dto.getShift());
        s.setDayOfWeek(dto.getDayOfWeek());

        if (dto.getTeacherId() != null) {
            Teacher teacher = repositoryTeacher.findById(dto.getTeacherId())
                    .orElseThrow(() ->
                            new RuntimeException("Professor não encontrado: " + dto.getTeacherId())
                    );
            s.setTeacher(teacher);
        }

        return repositoryStudent.save(s);
    }


    public void delete(Long id){
        if(!repositoryStudent.existsById(id)){
            throw new RuntimeException("Estudante não encontrado: " + id);
        }
        repositoryStudent.deleteById(id);
    }

    public Student findById(Long id){
        return repositoryStudent.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudante não encontrado com id"));
    }
}