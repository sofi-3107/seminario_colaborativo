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
	
	@Column
	private int cantidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	
	
}
