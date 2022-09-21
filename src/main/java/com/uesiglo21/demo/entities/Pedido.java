package com.uesiglo21.demo.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	


	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER,orphanRemoval=true)
	Set<DetallePedido>detallePedido;
	
	@Column
	Double importeTotal;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	Cliente cliente;
	


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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

	public Set<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(Set<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
	
	

	}
