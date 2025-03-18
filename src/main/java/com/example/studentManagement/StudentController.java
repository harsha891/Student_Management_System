package com.example.studentManagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentservice;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentservice.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "new-student";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if(result.hasErrors()) {
            return "new-student";
        }
        studentservice.addStudent(student);
        return "redirect:/students";
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentservice.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/json")
    public ResponseEntity<List<Student>> getAllStudentsjson() {
        return ResponseEntity.ok(studentservice.getAllStudents());
    }
}
