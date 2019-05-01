package com.digitallab.sigac.repositories;

import com.digitallab.sigac.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
  Course  findById(int id);
}
