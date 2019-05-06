package com.digitallab.sigac.repositories;

import com.digitallab.sigac.models.Student;
import com.digitallab.sigac.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository  extends JpaRepository<Teacher, String> {
    @Query("select t from Teacher t where t.id =:id or t.documentNumber =:id")
    Teacher findByIdOrDocumentNumber(final Long id);
}

