package com.uesiglo21.demo.services.interfaces;

import java.util.List;

import com.uesiglo21.demo.entities.Producto;

public interface ProductoService {
	
	public List<Producto>getAllProductos() throws Exception;
	
	public Producto updateCantidad(Producto producto, int cantidadComprada) throws Exception;
	public Producto findById(Integer id) throws Exception;
}
