package com.digitallab.sigac.controllers;

import com.digitallab.sigac.models.Program;
import com.digitallab.sigac.models.Student;
import com.digitallab.sigac.modelsVO.StudentVO;
import com.digitallab.sigac.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") int id) {
        Student student = this.studentRepository.findById(id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentVO studentVO){
        Student student = this.setStudent(studentVO);
        return  new ResponseEntity<>(this.studentRepository.save(student), HttpStatus.CREATED);
    }


    @PutMapping("/{idStudent}")
    public ResponseEntity<Student> updateStudent(@PathVariable("idStudent") int idStudent, @RequestBody StudentVO studentVO){
        Student student = this.studentRepository.findById(idStudent);
        System.out.println(student.getCode());
        if (student == null) {
            return  new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        } else {
             student = this.setStudent(studentVO);
             student.setId(idStudent);
            return  new ResponseEntity<>(this.studentRepository.save(student), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idStudent}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("idStudent") int idStudent){
        Student student = this.studentRepository.findById(idStudent) ;
        if(student == null){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }else{
            this.studentRepository.delete(student);
            return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
        }
    }

    private Student setStudent(StudentVO studentVO ){
        Student student = new Student();
        student.setFullName(studentVO.getFullName());
        student.setCc(studentVO.getCc());
        student.setCode(studentVO.getCode());
        student.setEmail(studentVO.getEmail());
        student.setPhone(studentVO.getPhone());
        return  student ;
    }


}
