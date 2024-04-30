package com.salesianostriana.dam.ud8e04fragmentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	/*
	 * Ruta de inicio, es decir, petición a la que atiende, 
	 * sin poner nada en el navegador después de localhost:9000
	 * Solo se muestra la plantilla index
	 * */
	@GetMapping("/")
	public String index() {
		return "index";//Mostramos la plantilla index
	}
	
	//Muestra otra página atendiendo a /otra con el mensaje de texto dado al model
	@GetMapping("/otra") 
	public String otra(Model model){
		model.addAttribute("mensaje", "Este es un mensaje en una cadena de caracteres llamada mensaje");
		return "otrapagina";
	}
}
