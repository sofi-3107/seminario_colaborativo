package com.uesiglo21.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.repositories.PedidoRepository;
import com.uesiglo21.demo.repositories.ProductoRepository;
import com.uesiglo21.demo.services.interfaces.PedidoService;

@RestController
public class CafeteriaController {
	
	@Autowired
	ProductoRepository prodService;
	
	

	@Autowired
	PedidoRepository pedRep;
	@Autowired
	ProductoRepository prodRep;
	
	@Autowired
	PedidoService pedService;
	
	@GetMapping("/productos")
	public List<Producto>getAllProductos(){
		
		List<Producto> productos=new ArrayList<Producto>();
		try {
			productos= (List<Producto>) prodService.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return productos; 
	}
	
	
	@PostMapping("/pedido")
	public Pedido crearPedido(@RequestBody Pedido pedido) {
		
		return pedRep.save(pedido);
		
	}
	
	@GetMapping("/pedidos")
	public List<Pedido>getAllPedidos(){
		return (List<Pedido>) pedRep.findAll();
	}
	
	
	@PostMapping("/crear-producto")
	
	public Producto crearProducto(@RequestBody Producto producto) {
		return prodRep.save(producto);
	}

}
