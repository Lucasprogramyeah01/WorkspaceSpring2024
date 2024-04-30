package com.salesianostriana.dam.bd_manytomany.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
	
	// Resto del código
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "matricula",
			joinColumns = @JoinColumn(name="alumno_id"),
			inverseJoinColumns = @JoinColumn(name="asignatura_id")
	)
	@Builder.Default
	private List<Asignatura> asignaturas = new ArrayList<>();
	
	// Resto del código
	
	// Alumno - Asignaturas
	public void addAsignatura(Asignatura a) {
		this.asignaturas.add(a);
		a.getAlumnos().add(this);
	}
	
	public void removeAsignatura(Asignatura a) {
		a.getAlumnos().remove(this);
		this.asignaturas.remove(a);
	}
}