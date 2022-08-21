package com.uesiglo21.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesiglo21.demo.entities.Pedido;
import com.uesiglo21.demo.repositories.PedidoRepository;
import com.uesiglo21.demo.services.interfaces.PedidoService;

@Service
public class PedidoServiceImpl  implements PedidoService{

	@Autowired 
	PedidoRepository rep;

	@Override
	public void crearPedido(Pedido pedido) throws Exception {
		rep.save(pedido);		
	}
	
	
	
	
}
