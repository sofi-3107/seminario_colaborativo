package com.uesiglo21.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.services.PedidoServiceImpl;
import com.uesiglo21.demo.services.ProductoServiceImpl;

@RestController
public class CafeteriaController {
	
	@Autowired
	ProductoServiceImpl productoService;
	
	@Autowired
	PedidoServiceImpl pedidoService;

	@GetMapping("/productos")	
	public List<Producto>getProductos() throws Exception{
		return productoService.getAllProductos();		
	}
	
	@PostMapping("/pedidos")
	public void guardarPedido(@RequestBody Pedido pedido) throws Exception {
		pedidoService.crearPedido(pedido);
		
	}
}
