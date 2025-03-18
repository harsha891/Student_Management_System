package com.example.studentManagement;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private int id;

    @NotNull
    @Size(min = 2, max = 40)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(value = 18)
    private int age;
}
