package com.example.studentManagement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testlistStudents_200() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("students"));
    }

    @Test
    public void testSaveStudentInvalidData() throws Exception {
        mockMvc.perform(post("/students/save")
                        .param("name", "H")
                        .param("email", "gharsha")
                        .param("age", "17"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("student", "name", "email", "age")) // Validation errors
                .andExpect(view().name("new-student"));
    }
}
