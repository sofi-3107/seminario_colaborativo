package com.uesiglo21.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.services.interfaces.PedidoService;
import com.uesiglo21.demo.services.interfaces.ProductoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CafeteriaController {
	
	@Autowired
	ProductoService prodService;
	@Autowired
	PedidoService pedService;


	
	@GetMapping("/")
	public List<Producto>getAllProductos(){		
		return (List<Producto>) prodService.getAllProductos();
	}
	
	@Secured({"CLIENTE","ADMIN"})
	@PostMapping("/nuevo-pedido")
	public Pedido crearPedido(@RequestBody Pedido pedido) throws Exception {
		return pedService.crearPedido(pedido);
		
	}
	
	@Secured("ADMIN")
	@GetMapping("/pedidos")
	public List<Pedido>getAllPedidos(){
		return pedService.listAllPedidos();
	}
	
	@Secured("ADMIN")
	@PostMapping("/crear-producto")
	
	public Producto crearProducto(@RequestBody Producto producto) {
		return prodService.guardarProducto(producto);	
	}
	
	@PutMapping("/modificar-producto")	
	public Producto modificarProducto(@RequestBody Producto producto) {
		return prodService.guardarProducto(producto);		
	}
	
	@DeleteMapping("/eliminar-producto/{id}")
	public ResponseEntity<String> deleteProducto (@PathVariable int id) {	
				prodService.deleteProducto(id);
			return  ResponseEntity.ok("Producto "+id+ " eliminado correctamente");
	}

}

