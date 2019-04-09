package com.digitallab.sigac.controllers;

import com.digitallab.sigac.models.Teacher;
import com.digitallab.sigac.repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController   {



    private final TeacherRepository teacherRepository;
    public TeacherController(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }



    @GetMapping
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(this.teacherRepository.findAll());
    }
}
