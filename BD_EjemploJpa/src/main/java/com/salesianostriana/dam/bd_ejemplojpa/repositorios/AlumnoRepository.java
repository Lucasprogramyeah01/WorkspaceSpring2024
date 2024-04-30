package com.salesianostriana.dam.bd_ejemplojpa.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.bd_ejemplojpa.modelo.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}