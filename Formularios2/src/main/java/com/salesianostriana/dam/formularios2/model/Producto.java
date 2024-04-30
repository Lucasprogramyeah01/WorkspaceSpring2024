package com.salesianostriana.dam.formularios2.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Producto {

	/*Atributo para el tipo de cerveza. Aunque se trabajará con él usando 
	 * radioButtons, lo usamos con tipo String que es lo que devuelven 
	 * estos radios al ser marcados.*/
	private long id;
	private String name;
	private String description;
	private double price;
	
	private String tipo;
	
	//El trabajo con fechas se verá en un ejemplo más adelante.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate FCaducidad;
	
}
