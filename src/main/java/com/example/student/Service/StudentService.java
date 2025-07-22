package com.example.student.Service;

import com.example.student.Entity.Student;
import com.example.student.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Object saveOrUpdateStudent(Student student)  {
        if (studentRepo.existsById(student.getId())) {
            Student student1= studentRepo.findById(student.getId()).get();
            student1.setId(student.getId());
            student1.setName(student.getName());
            student1.setAge(student.getAge());
            student1.setEmail(student.getEmail());
            student1.setMarks((student.getMarks()));
            studentRepo.save(student);
            return "Updated Successfully!!!";
        } else {
            studentRepo.save(student);
            return "Inserted Successfully!!!";
        }
    }

    @Override
    public Object getAllStudent() {
        return studentRepo.findAll();
    }
    @Override
    public void deleteStudentById(Long id) throws Exception {
        Optional<Student> optional = studentRepo.findById(id) ;
        if(optional.isPresent()){
            Student student = optional.get() ;
            studentRepo.deleteById(student.getId());
        }else{
            throw new Exception("Id not Found!!!") ;
        }
    }
}
