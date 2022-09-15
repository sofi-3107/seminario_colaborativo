package com.uesiglo21.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uesiglo21.demo.entities.DetallePedido;
import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.exceptions.ProductNotFoundException;
import com.uesiglo21.demo.repositories.PedidoRepository;
import com.uesiglo21.demo.repositories.ProductoRepository;
import com.uesiglo21.demo.services.interfaces.PedidoService;
import com.uesiglo21.demo.services.interfaces.ProductoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CafeteriaController {
	
	@Autowired
	ProductoService prodService;


	@Autowired
	PedidoRepository pedRep;
	@Autowired
	ProductoRepository prodRep;
	
	@Autowired
	PedidoService pedService;


	
	@GetMapping("/")
	public List<Producto>getAllProductos(){
		
			
		List<Producto> productos=new ArrayList<Producto>();
		try {
			productos= (List<Producto>) prodService.getAllProductos();
		} catch (Exception e) {
			System.out.println(e);
		}
		return productos; 
	}
	
	
	@PostMapping("/pedido")
	public Pedido crearPedido(@RequestBody Pedido pedido) throws Exception {

		return pedService.crearPedido(pedido);
		
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
/*Calendar hoy=new GregorianCalendar();
pedido.setFecha(hoy);
for( DetallePedido dp: pedido.getDetallePedido()) {
	Producto p= prodRep.findById(dp.getProducto().getId()).orElseThrow();
	p.setCantidadEnStock(p.getCantidadEnStock()-dp.getCantidad());
}*/
