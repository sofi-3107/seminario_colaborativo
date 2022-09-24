
package com.uesiglo21.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.exceptions.ProductNotFoundException;
import com.uesiglo21.demo.repositories.ProductoRepository;
import com.uesiglo21.demo.services.interfaces.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository rep;

	@Override
	public List<Producto> getAllProductos()  {	
		return (List<Producto>) rep.findByCantidadEnStockGreaterThan(0);
	}

	@Override
	public Producto updateCantidad(Producto producto,int cantidadComprada) throws ProductNotFoundException {
		Producto foundProducto=rep.findById(producto.getId()).get();
		if (foundProducto!=null) {
			foundProducto.setCantidadEnStock(foundProducto.getCantidadEnStock()-cantidadComprada);
			rep.save(foundProducto);
		}else {
			throw new ProductNotFoundException("El producto que intenta actualizar no existe");
		}
		return foundProducto;
	}

	@Override
	public Producto findById(Integer id) throws ProductNotFoundException {
		Producto p=rep.findById(id).get();
		if(p==null) {
			throw new ProductNotFoundException("El producto con id "+id+" no existe");
		}
		return p;
	}

	@Override
	public void deleteProducto(Integer id){
		rep.deleteById(id);
		
	}

	@Override
	public Producto guardarProducto(Producto producto) {// TODO Auto-generated method stub
		return rep.save(producto);
	}

}
