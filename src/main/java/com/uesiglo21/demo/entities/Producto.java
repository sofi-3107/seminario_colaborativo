package com.uesiglo21.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producto {
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column(length=25)
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="producto",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	Set<DetallePedido>detallePedido;
	
	@Column
	private double precioUnitario;
	

	@Column
	private int cantidadEnStock;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<DetallePedido> getDetallePedido() {
		return detallePedido;
	}


	public void setDetallePedido(Set<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public int getCantidadEnStock() {
		return cantidadEnStock;
	}


	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	



}
