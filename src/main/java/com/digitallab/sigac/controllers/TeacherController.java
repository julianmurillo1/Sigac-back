package com.digitallab.sigac.controllers;

import com.digitallab.sigac.models.Teacher;
import com.digitallab.sigac.modelsVO.TeacherVO;
import com.digitallab.sigac.repositories.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable("id") int id){
        Teacher teacher = this.teacherRepository.findById(id);
        if(teacher != null){
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Teacher> createStudent(@RequestBody TeacherVO teacherVO){
        Teacher teacher = this.setTeacher(teacherVO);
        return new ResponseEntity<>(this.teacherRepository.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{idTeacher}")
    public  ResponseEntity<Teacher> updateTeacher(@PathVariable("idTeacher") int idTeacher, @RequestBody TeacherVO teacherVO){
        Teacher teacher = this.teacherRepository.findById(idTeacher);
        if(teacher == null){
            return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
        }else {
            teacher = this.setTeacher(teacherVO);
            teacher.setId(idTeacher);
            return new ResponseEntity<>(this.teacherRepository.save(teacher), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idTeacher}")
    public ResponseEntity<Teacher> deteteTeacher(@PathVariable("idTeacher") int idTeacher){
        Teacher teacher = this.teacherRepository.findById(idTeacher);
        if(teacher == null){
            return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
        }else {
            this.teacherRepository.delete(teacher);
            return new ResponseEntity<Teacher>(HttpStatus.ACCEPTED);
        }
    }


    private Teacher setTeacher(TeacherVO teacherVO){
        Teacher teacher = new Teacher();
        teacher.setFullName(teacherVo.getFullName());
        teacher.setCc(teacherVo.getCc());
        teacher.setCode(teacherVo.getCode());
        teacher.setEmail(teacherVo.getEmail());
        teacher.setPhone(teacherVo.getPhone());
        return teacher ;
    }
}
