package com.example.studentManagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private static int idCounter = 1;

    private final List<Student> students= new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(idCounter++);
        students.add(student);
    }

    public void deleteStudentById(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public Optional<Student> getStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }
}
