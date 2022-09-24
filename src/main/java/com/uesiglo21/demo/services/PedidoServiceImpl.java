package com.uesiglo21.demo.services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesiglo21.demo.entities.Cliente;
import com.uesiglo21.demo.entities.DetallePedido;
import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.repositories.ClienteRepository;
import com.uesiglo21.demo.repositories.PedidoRepository;
import com.uesiglo21.demo.services.interfaces.PedidoService;
import com.uesiglo21.demo.services.interfaces.ProductoService;

@Service
public class PedidoServiceImpl  implements PedidoService{

	@Autowired 
	PedidoRepository rep;
	@Autowired
	ProductoService prodService;
	@Autowired
	ClienteRepository cliRep;
	@Override
	public Pedido crearPedido(Pedido pedido) throws Exception {
		//double totalPedido=0;
		if(pedido.getDetallePedido()!=null) {
			for(DetallePedido dp:pedido.getDetallePedido()) {
				prodService.updateCantidad(dp.getProducto(), dp.getCantidad());
				//totalPedido+=dp.getCantidad()*dp.getProducto().getPrecioUnitario();
				
			}
			
		}else {
				System.out.println(pedido.getDetallePedido());
			}
		Calendar hoy=new GregorianCalendar();
		pedido.setFecha(hoy);
			
				Cliente cl= cliRep.findByDocumento(pedido.getCliente().getDocumento());
				if(cl!=null) {
					pedido.setCliente(cl);
				}
				
				
		//pedido.setImporteTotal(totalPedido);
				
		
		return rep.save(pedido);
	}
	@Override
	public List<Pedido> listAllPedidos() {
		
		return (List<Pedido>) rep.findAll();
	}
	
	
	
	
}
