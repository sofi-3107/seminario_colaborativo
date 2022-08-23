package com.uesiglo21.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
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
		
		Set<DetallePedido>productos = new HashSet<DetallePedido>();
		DetallePedido dp= new DetallePedido();
		DetallePedido dp2= new DetallePedido();
		Pedido pedido=new Pedido();	
		Producto cafe= prodRep.findById(1).orElse(new Producto());	
		Producto submarino=prodRep.findById(2).orElse(new Producto());
		
		/*LA entidad o entidades propietarias( las que son referenciadas con clave foranea)
		 * deben tener cascade persist para guardarse y guardar tambien la ref en la tabla
		 * intermedia, o en la tabla que las referencia.
		 * y éste debe asignarla explicitamente.
		 * En este caso tanto producto como pedido deben setear el detalle y solo se persisten
		 * las primeras.
		 */
		
		dp2.setProducto(submarino);
		dp2.setCantidad(1);
		
		dp.setProducto(cafe);
		dp.setCantidad(3);
		
		productos.add(dp);
		productos.add(dp2);
		double total = 0;
		for(DetallePedido p : productos) {
			total+=p.getCantidad()*p.getProducto().getPrecioUnitario();
			System.out.println(productos.size());
			System.out.println(p.getProducto().getNombre());
			System.out.println(total);
		
		}
		
		
		pedido.setFecha(cal);
		pedido.setImporteTotal(total);
		dp.setPedido(pedido);
		dp2.setPedido(pedido);
		cafe.setDetallePedido(productos);
		submarino.setDetallePedido(productos);
		pedido.setDetallePedido(productos);
		pedRep.save(pedido);
		prodRep.save(cafe);
		

		
		
		
		
		
		
		
	}

}
