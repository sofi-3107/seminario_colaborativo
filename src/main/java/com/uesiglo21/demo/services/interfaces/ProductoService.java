package com.uesiglo21.demo.services.interfaces;

import java.util.List;

import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.exceptions.ProductNotFoundException;

public interface ProductoService {
	
	public List<Producto>getAllProductos() ;
	
	public Producto updateCantidad(Producto producto, int cantidadComprada) throws ProductNotFoundException ;
	public Producto findById(Integer id) throws ProductNotFoundException;
	public void deleteProducto( Integer id);
	public Producto guardarProducto (Producto producto);
	
}
