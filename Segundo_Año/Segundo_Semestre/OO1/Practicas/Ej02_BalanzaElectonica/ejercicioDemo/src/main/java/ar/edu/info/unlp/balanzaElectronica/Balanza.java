package ar.edu.info.unlp.balanzaElectronica;

import java.time.LocalDate;

public class Balanza {

	private int cantidadDeProductos;
	private double precioTotal, pesoTotal;
	
	// Getters y Setters
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	// Metodos
	public void ponerEnCero() {
		this.precioTotal = 0;
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
	}
	public void agregarProducto(Producto producto) {
		producto.setDescripcion(producto.getDescripcion());
		producto.setPeso(producto.getPeso());
		producto.setPrecioPorKilo(producto.getPrecioPorKilo());
	}
	public Ticket emitirTicket() {
		Ticket ticket = new Ticket();
		ticket.setFecha(LocalDate.now());
		ticket.setPesoTotal(this.pesoTotal);
		ticket.setPrecioTotal(this.precioTotal);
		ticket.setCantidadDeProductos(this.cantidadDeProductos);
		ticket.impuesto();
		return ticket;
	}
	
}
