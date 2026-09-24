package com.bootcamp.springedumanager.repository;

import com.bootcamp.springedumanager.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}