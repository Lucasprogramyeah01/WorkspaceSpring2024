package com.salesianostriana.dam.ejemplocrudcompleto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplocrudcompleto.model.Alumno;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long>{

}
