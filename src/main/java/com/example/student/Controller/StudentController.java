package com.example.student.Controller;

import com.example.student.Entity.Student;
import com.example.student.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @PostMapping("/saveOrUpdateStudent")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student student){

        return new ResponseEntity<>(iStudentService.saveOrUpdateStudent(student), HttpStatus.OK);
    }
    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(iStudentService.getAllStudent(),HttpStatus.FOUND);
    }
    @PostMapping("/deleteStudent/{Id}")
    public void deleteStudentyById(@PathVariable Long id) throws Exception {
        iStudentService.deleteStudentById(id) ;
    }
}
