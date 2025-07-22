package com.example.student.Service;

import com.example.student.Entity.Student;

public interface IStudentService {
    public Object saveOrUpdateStudent(Student student);
    public Object getAllStudent();
    public void deleteStudentById(Long id) throws Exception;
}
