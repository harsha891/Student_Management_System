package com.example.studentManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void testAddStudentIncreaseListSize() {
        Student student = new Student();
        student.setName("harsha");
        student.setEmail("harsha@gmail.com");
        student.setAge(20);

        int initialSize = studentService.getAllStudents().size();
        studentService.addStudent(student);

        assertEquals(initialSize + 1, studentService.getAllStudents().size());
    }
}
