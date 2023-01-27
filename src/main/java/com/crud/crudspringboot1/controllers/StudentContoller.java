package com.crud.crudspringboot1.controllers;

import com.crud.crudspringboot1.entities.Student;
import com.crud.crudspringboot1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentContoller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.listAllStudent());
        return "student";
    }

    @GetMapping("/students/new")
    public String showFormStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showFormEditStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "editt_student";
    }

    @PostMapping("/students/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student studentExist = studentService.getStudentById(id);
        studentExist.setId(id);
        studentExist.setName(student.getName());
        studentExist.setSurname(student.getSurname());
        studentExist.setEmail(student.getEmail());
        studentService.putStudent(studentExist);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String removeStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
