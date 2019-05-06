package com.digitallab.sigac.controllers;

import com.digitallab.sigac.models.Matricula;
import com.digitallab.sigac.modelsVO.MatriculaVO;
import com.digitallab.sigac.repositories.CourseRepository;
import com.digitallab.sigac.repositories.MatriculaRepository;
import com.digitallab.sigac.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class MatriculaController {

    private final MatriculaRepository matriculaRepository;
    private final StudentRepository studentRepository ;
    private final CourseRepository courseRepository;

    public MatriculaController(
            MatriculaRepository matriculaRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository){
        this.matriculaRepository = matriculaRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Matricula>> findAll() {
        return ResponseEntity.ok(this.matriculaRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable("id") int id) {
        Matricula matricula = this.matriculaRepository.findByIdMatricula(id);
        if(matricula != null){
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }


    @PostMapping("/")
    public ResponseEntity<Matricula> createMatricula(@RequestBody MatriculaVO matriculaVO){
        Matricula matricula = this.setMatricula(matriculaVO);
        return  new ResponseEntity<>(this.matriculaRepository.save(matricula), HttpStatus.CREATED);
    }


    @PutMapping("/{idMatricula}")
    public ResponseEntity<Matricula> updateMatricula(@PathVariable("idMatricula") int idMatricula, @RequestBody MatriculaVO matriculaVO){
        Matricula matricula = this.matriculaRepository.findByIdMatricula(idMatricula);
        if (matricula == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            matricula = this.setMatricula(matriculaVO);
            matricula.setIdMatricula(idMatricula);
            return  new ResponseEntity<>(this.matriculaRepository.save(matricula), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<Matricula> deleteMatricula(@PathVariable("idMatricula") int idMatricula){
        Matricula matricula = this.matriculaRepository.findByIdMatricula(idMatricula) ;
        if(matricula == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            this.matriculaRepository.delete(matricula);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

    private Matricula setMatricula(MatriculaVO matriculaVO ){
        Matricula matricula = new Matricula();
        matricula.setIdStudent(this.studentRepository.findByIdOrDocumentNumber(matriculaVO.getIdStudent()));
        matricula.setIdCourse(this.courseRepository.findById(matriculaVO.getIdCourse()));

        return  matricula ;
    }
}
