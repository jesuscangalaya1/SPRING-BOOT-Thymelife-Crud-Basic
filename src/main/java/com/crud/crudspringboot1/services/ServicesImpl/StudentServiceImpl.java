package com.crud.crudspringboot1.services.ServicesImpl;


import com.crud.crudspringboot1.entities.Student;
import com.crud.crudspringboot1.repositoy.RepositoryStudent;
import com.crud.crudspringboot1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private RepositoryStudent repositoryStudent;

    @Override
    public List<Student> listAllStudent() {
        return repositoryStudent.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repositoryStudent.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repositoryStudent.findById(id).get();
    }

    @Override
    public Student putStudent(Student student) {
        return repositoryStudent.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repositoryStudent.deleteById(id);
    }

}
