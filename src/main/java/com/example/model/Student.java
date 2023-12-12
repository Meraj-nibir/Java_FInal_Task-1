package com.example.model;

import com.sun.istack.NotNull;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Pattern(regexp = "N/A|Yes")
    private String quota = "N/A";

    @NotNull
    private String country;

    {
        country = "Bangladeshi";
    }
}
