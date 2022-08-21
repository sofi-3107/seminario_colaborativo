package com.uesiglo21.demo.entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	@ManyToMany
	@JoinTable(
	name="producto_pedido",
	joinColumns=@JoinColumn(name="id_pedido"),
	inverseJoinColumns=@JoinColumn(name="id_producto"))
	List<Producto>productos;
	
	@Column
	Double importeTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
	
	
}
