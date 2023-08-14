package com.cibertec.DAW1_CL3_SALAS_HUGO.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.DAW1_CL3_SALAS_HUGO.business.ProductoService;
import com.cibertec.DAW1_CL3_SALAS_HUGO.dao.ProductoRepository;
import com.cibertec.DAW1_CL3_SALAS_HUGO.model.Producto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{

	private ProductoRepository repository;

	@Override
	public Producto buscarProducto(int id) {
		Optional<Producto> obj = repository.findById(id);
		Producto producto = null;
		if(obj.isPresent()) {
			producto = obj.get();
		}else {
			throw new RuntimeException("ID incorrecto: Producto no fue encontrado.");
		}
		return producto;
	}
	
	@Override
	public List<Producto> listarProducto() {
		return repository.findAll();
	}

	@Override
	public void registrarProducto(Producto producto) {
		repository.save(producto);	
	}

	@Override
	public void eliminarProducto(int id) {
		repository.deleteById(id);
	}
}
