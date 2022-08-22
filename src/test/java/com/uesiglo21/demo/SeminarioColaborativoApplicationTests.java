package com.uesiglo21.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uesiglo21.demo.entities.DetallePedido;
import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.repositories.DetallePedidoRepository;
import com.uesiglo21.demo.repositories.PedidoRepository;
import com.uesiglo21.demo.repositories.ProductoRepository;

@SpringBootTest
class SeminarioColaborativoApplicationTests {

	@Autowired
	ProductoRepository prodRep;
	
	@Autowired
	PedidoRepository pedRep;
	
	@Autowired
	DetallePedidoRepository detRep;
	
	@Test
	void contextLoads() {
		DateFormat df=new SimpleDateFormat("dd/M/yy");
		Calendar cal= new GregorianCalendar();
		
		try {
			Date fecha= df.parse("21/08/022");
		} catch (ParseException e) {
			System.out.println(e);
			
		}
		
		Producto p1=new Producto();
		Producto p2=new Producto();
		
		p1.setNombre("cafe con leche");
		p1.setCantidadEnStock(15);
		p1.setPrecioUnitario(50.0);
		
		p2.setNombre("submarino");
		p2.setCantidadEnStock(10);
		p2.setPrecioUnitario(150.0);
		
		prodRep.save(p1);
		prodRep.save(p2);
		
		Set<DetallePedido>productos = new LinkedHashSet<DetallePedido>();
		DetallePedido dp= new DetallePedido();
		Pedido pedido=new Pedido();	
		Producto cafe= prodRep.findById(1).orElse(new Producto());		
		pedido.setFecha(cal);
		pedido.setDetallePedido(productos);
		Pedido savedP=pedRep.save(pedido);
		dp.setCantidad(3);
		dp.setProducto(cafe);
		System.out.println("Id del pedido guardado: "+savedP.getId());
		dp.setPedido(savedP);
		detRep.save(dp);

		
		
		
		
		
		
		
	}

}
