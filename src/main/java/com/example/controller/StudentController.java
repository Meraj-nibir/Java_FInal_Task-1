package com.example.controller;

import com.example.dao.StudentDao;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable("id") Integer id, Model model) {
        Student student = studentDao.getStudentById(id);
        model.addAttribute("student", student);
        return "student/view";
    }

    @GetMapping("/{id}/edit")
    public String editStudentForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentDao.getStudentById(id);
        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("/{id}/edit")
    public String editStudent(@PathVariable("id") Integer id, @Valid @ModelAttribute("student") Student student,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "student/edit";
        }
        studentDao.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentDao.deleteStudent(id);
        return "redirect:/students";
    }

}
