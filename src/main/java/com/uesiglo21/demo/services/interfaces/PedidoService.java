package com.uesiglo21.demo.services.interfaces;

import java.util.List;

import com.uesiglo21.demo.entities.Pedido;

public interface PedidoService {
	
	public Pedido crearPedido(Pedido pedido) throws Exception;
	public List<Pedido>listAllPedidos();

}
