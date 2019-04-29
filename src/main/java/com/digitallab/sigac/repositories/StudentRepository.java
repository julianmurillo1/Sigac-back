package com.digitallab.sigac.repositories;

import com.digitallab.sigac.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, String> {

     Student findById(int documentNumber);


}

