package com.salesianostriana.dam.formularios2.service;

import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

	public String[] getTipos() {
		String[] tipos = new String[] {"Lager", "Pilsen", "Guiness", "Sin filtrar", "Serranito"};
		return tipos;
	}
}
