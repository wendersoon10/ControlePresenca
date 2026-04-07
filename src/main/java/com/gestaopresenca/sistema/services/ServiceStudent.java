package com.gestaopresenca.sistema.services;

import com.gestaopresenca.sistema.entities.Student;
import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.repositories.RepositoryStudent;
import com.gestaopresenca.sistema.repositories.RepositoryTeacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStudent {

    private final RepositoryStudent repositoryStudent;
    private final RepositoryTeacher repositoryTeacher;

    public ServiceStudent(RepositoryStudent repositoryStudent, RepositoryTeacher repositoryTeacher) {
        this.repositoryStudent = repositoryStudent;
        this.repositoryTeacher = repositoryTeacher;
    }


    public Student save(Student student) {

        if (student.getTeacher() == null || student.getTeacher().getName() == null) {
            throw new RuntimeException("Nome do teacher é obrigatório para criar um estudante");
        }

        String teacherName = student.getTeacher().getName();

        Teacher teacher = repositoryTeacher.findByName(teacherName)
                .orElseThrow(() -> new RuntimeException("Teacher not found: " + teacherName));

        student.setTeacher(teacher);

        return repositoryStudent.save(student);
    }


    public List<Student> findAll(){
        return repositoryStudent.findAll();
    }

    public List<Student> findByName(String name){
        return repositoryStudent.findByName(name);
    }

    public Student update(Long id, Student student){
        Student s = repositoryStudent.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado: " + id));

        s.setName(student.getName());
        s.setWeeklyWorkload(student.getWeeklyWorkload());
        s.setTeacher(student.getTeacher());


        return repositoryStudent.save(s);
    }

    public void delete(Long id){
        if(!repositoryStudent.existsById(id)){
            throw new RuntimeException("Estudante não encontrado: " + id);
        }
        repositoryStudent.deleteById(id);
    }

    public Optional<Student> findById(Long id)  {
        return repositoryStudent.findById(id);
    }
}
