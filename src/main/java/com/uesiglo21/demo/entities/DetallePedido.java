package com.uesiglo21.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetallePedido {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	Pedido pedido;
	@ManyToOne
	@JoinColumn(name="producto_id")
	Producto producto;
	
	
}
