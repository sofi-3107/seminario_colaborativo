package com.uesiglo21.demo.entities;

import java.net.InetAddress;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

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
	
	public void setImagen(String img) {
		this.imagen=img;
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
