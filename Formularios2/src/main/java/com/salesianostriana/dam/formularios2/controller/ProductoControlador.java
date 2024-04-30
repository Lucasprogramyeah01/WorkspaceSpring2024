package com.salesianostriana.dam.formularios2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.formularios2.model.Producto;
import com.salesianostriana.dam.formularios2.service.ProductoServicio;

@Controller
public class ProductoControlador {

	@Autowired
	private ProductoServicio service;
	
	@GetMapping("/producto")
	public String showFormProducto(Model model) {
		
		/*Agregamos al modelo un 
		
		Producto producto = new Producto();
		model.addAttribute("productoForm", producto);
		
		/*Traemos la lista de tipos de cerveza, simulando de nuevo con
		 * el servicio que viene de la base de datos.
		 */
		model.addAttribute("tipos", service.getTipos());
		
		return "formProducto";
	}
	
	/*Como hemos visto, los formularios son atendidos por peticiones post,*/
	
	@PostMapping("/addProducto")
	public String submit(@ModelAttribute("productForm") Producto producto, Model model) {
		model.addAttribute("producto", producto);
		
		return "view";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
