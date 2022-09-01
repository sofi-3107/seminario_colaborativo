package com.uesiglo21.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Producto {
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column(length=25)
	private String nombre;
	
	
	//Set<DetallePedido>detallePedido;

	
	@Column
	private double precioUnitario;
	

	@Column
	private int cantidadEnStock;
	
	@Column(length=50)
	private String imagen;


	public String getImagen() {
		return imagen;	
	}



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
