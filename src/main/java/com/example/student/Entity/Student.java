package com.example.student.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer marks;
    private String grade;
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {

        this.marks = marks;
        this.grade = calculateGrade(marks); // Automatically set grade when marks are updated
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    private String calculateGrade(Integer marks) {
        if (marks >= 90 && marks <= 100) {
            return "A";
        } else if (marks >= 60 && marks < 90) {
            return "B";
        } else if (marks >= 40 && marks < 60) {
            return "C";
        } else if (marks >= 0 && marks < 40) {
            return "Fail";
        } else {
            return "Invalid Marks";// In case the marks are not in the valid range
        }

    }

}
