package com.digitallab.sigac.repositories;

import com.digitallab.sigac.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, String> {

     @Query("select s from Student s where s.id =:id or s.documentNumber =:id")
     Student findByIdOrDocumentNumber(final Long id);


}

