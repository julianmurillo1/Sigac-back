package com.digitallab.sigac.repositories;

import com.digitallab.sigac.models.Student;
import com.digitallab.sigac.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher, String> {
    Teacher findById(int idTeacher);
}

