package com.uesiglo21.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetallePedido {

	@Id
	@GeneratedValue
	
	private Integer id;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="pedido_id")
	Pedido pedido;
	
	
	
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)	
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
