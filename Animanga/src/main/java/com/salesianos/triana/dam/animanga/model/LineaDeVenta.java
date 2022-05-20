package com.salesianos.triana.dam.animanga.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineaDeVenta {

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Manga manga;
	private int cantidad;
	private double subtotal;
	@ManyToOne
	private Carrito carrito;
	
	
	public void addToTicket(Carrito carrito) {
		this.carrito=carrito;
		carrito.getLineaDeVenta().add(this);
	}
	
	public void removeFromTicket(Carrito carrito) {
		carrito.getLineaDeVenta().remove(this);
		this.carrito = null;
		
	}
	
}