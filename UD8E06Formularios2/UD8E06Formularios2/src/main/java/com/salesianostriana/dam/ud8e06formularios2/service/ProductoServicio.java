package com.salesianostriana.dam.ud8e06formularios2.service;

import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

	/*Simulamos un servicio que nos da la lista de tipos de cerveza que hay, es de tipos 
	 * String para traajar con dichos nombres en los radio buttons*/
	public String [] getTipos() {
		String[] tipos = new String[] { "Lager", "Pilsen", "Guiness", "Sin filtrar" }; 
		return tipos;		
	}
}
