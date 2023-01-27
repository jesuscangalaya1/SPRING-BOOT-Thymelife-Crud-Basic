package com.crud.crudspringboot1.services;

import com.crud.crudspringboot1.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAllStudent();
    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student putStudent(Student student);

    void deleteStudent(Long id);

}
