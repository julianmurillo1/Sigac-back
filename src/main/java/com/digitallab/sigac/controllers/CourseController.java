package com.digitallab.sigac.controllers;

import com.digitallab.sigac.models.Course;
import com.digitallab.sigac.modelsVO.CourseVO;
import com.digitallab.sigac.repositories.CourseRepository;
import com.digitallab.sigac.repositories.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class CourseController {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository, TeacherRepository teacherRepository){
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(this.courseRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") int id) {
        Course course = this.courseRepository.findById(id);
        if(course != null){
            return new ResponseEntity<>(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }


    @PostMapping("/")
    public ResponseEntity<Course> createCourse(@RequestBody CourseVO courseVO){
        Course course = this.setCourse(courseVO);
        return  new ResponseEntity<>(this.courseRepository.save(course), HttpStatus.CREATED);
    }


    @PutMapping("/{idCourse}")
    public ResponseEntity<Course> updateCourse(@PathVariable("idCourse") int idCourse, @RequestBody CourseVO courseVO){
        Course course = this.courseRepository.findById(idCourse);
        if (course == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            course = this.setCourse(courseVO);
            course.setId(idCourse);
            return  new ResponseEntity<>(this.courseRepository.save(course), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idCourse}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("idCourse") int idCourse){
        Course course = this.courseRepository.findById(idCourse) ;
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            this.courseRepository.delete(course);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

    private Course setCourse(CourseVO courseVO ){
        Course course = new Course();
        course.setName(courseVO.getName());
        course.setGrade(courseVO.getGrade());
        course.setGradeNumber(courseVO.getGradeNumber());
        course.setDescription(courseVO.getDescription());
        course.setIdTeacher(this.teacherRepository.findById(courseVO.getIdTeacher()));



        return  course ;
    }

}
