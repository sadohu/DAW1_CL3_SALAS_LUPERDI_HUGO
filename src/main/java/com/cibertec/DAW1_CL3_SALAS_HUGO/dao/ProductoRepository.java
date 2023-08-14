package com.cibertec.DAW1_CL3_SALAS_HUGO.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.DAW1_CL3_SALAS_HUGO.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
