package com.uesiglo21.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.repositories.ProductoRepository;
import com.uesiglo21.demo.services.interfaces.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository rep;

	@Override
	public List<Producto> getAllProductos() throws Exception {
		
		return (List<Producto>) rep.findAll();
	}

	@Override
	public Producto updateCantidad(Producto producto) throws Exception {
		Producto foundProducto=rep.findById(producto.getId()).get();
		if (foundProducto!=null) {
			foundProducto.setCantidadEnStock(producto.getCantidadEnStock());
			rep.save(foundProducto);
		}
		return foundProducto;
	}

}
