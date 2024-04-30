package com.salesianostriana.dam.bd_ejemplojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.bd_ejemplojpa.modelo.Alumno;
import com.salesianostriana.dam.bd_ejemplojpa.repositorios.AlumnoRepository;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {

    @Autowired
    private AlumnoRepository repo;

    @PostConstruct
    public void ejecutar() {
        repo.save(new Alumno("Luis Miguel","López Magaña","luismi.lopez@salesianos.edu"));
        repo.save(new Alumno("Ángel","Naranjo González","angel.naranjo@salesianos.edu"));
        repo.save(new Alumno("Rafael", "Villar Liñán", "rafael.villar@salesianos.edu"));

        repo.findAll().forEach(System.out::println);
    }
}