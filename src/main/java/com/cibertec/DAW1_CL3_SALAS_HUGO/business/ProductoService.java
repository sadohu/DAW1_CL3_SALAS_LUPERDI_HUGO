package com.cibertec.DAW1_CL3_SALAS_HUGO.business;

import java.util.List;

import com.cibertec.DAW1_CL3_SALAS_HUGO.model.Producto;

public interface ProductoService {
	Producto buscarProducto(int id);
	List<Producto> listarProducto();
	void registrarProducto(Producto producto);
	void eliminarProducto(int id);
}
