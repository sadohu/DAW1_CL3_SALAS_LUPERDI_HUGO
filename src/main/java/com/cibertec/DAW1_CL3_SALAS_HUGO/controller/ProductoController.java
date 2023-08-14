package com.cibertec.DAW1_CL3_SALAS_HUGO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.DAW1_CL3_SALAS_HUGO.business.ProductoService;
import com.cibertec.DAW1_CL3_SALAS_HUGO.model.Producto;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/")
	public String listarProducto(Model model) {
		model.addAttribute("listarProducto", service.listarProducto());
		return "index";
	}
	
	@GetMapping("/nuevoProducto")
	public String registrarProductoFormulario(Model model) {
		Producto item = new Producto();
		model.addAttribute("item", item);
		return "registrarProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String registrarProducto(@ModelAttribute("item") Producto item) {
		service.registrarProducto(item);
		return "redirect:/";
	}
	
	@GetMapping("/actualizarProducto/{id}")
	public String actualizarProductoFormulario(@PathVariable(value="id") int id, Model model) {
		Producto item = service.buscarProducto(id);
		model.addAttribute("item", item);
		return "actualizarProducto";
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable(value="id") int id) {
		service.eliminarProducto(id);
		return "redirect:/";
	}
}
