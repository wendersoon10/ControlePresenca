package com.gestaopresenca.sistema.services;


import com.gestaopresenca.sistema.entities.Teacher;
import com.gestaopresenca.sistema.repositories.RepositoryTeacher;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceTeacher {

    private RepositoryTeacher repositoryTeacher;

    public ServiceTeacher(RepositoryTeacher repositoryTeacher) {
        this.repositoryTeacher = repositoryTeacher;
    }

    public Teacher save(Teacher teacher) {
        return repositoryTeacher.save(teacher);
    }

   public List<Teacher> findAll(){
        return repositoryTeacher.findAll();
   }

   public Optional<Teacher> findByName(String name){
        return repositoryTeacher.findByName(name);
   }

   public Teacher update(Long id, Teacher teacher){
        Teacher t = repositoryTeacher.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado: " + id));

        t.setName(teacher.getName());
        t.setShift(teacher.getShift());

        return repositoryTeacher.save(t);
   }

   public void delete(Long id){
        if(!repositoryTeacher.existsById(id)){
            throw new RuntimeException("Professor não encontrado: " + id);
        }
        repositoryTeacher.deleteById(id);
   }

    public Optional<Teacher> findById(Long id)  {
        return repositoryTeacher.findById(id);
    }
}
