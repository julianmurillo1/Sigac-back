package com.digitallab.sigac.repositories;

import com.digitallab.sigac.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, String> {
    Matricula findByIdMatricula(int id);
}
