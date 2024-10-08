package ar.edu.info.unlp.balanzaElectronica;

import java.time.LocalDate;

public class Ticket {

	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal, precioTotal;
	
	// Getters y Setters
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate localDate) {
		this.fecha = localDate;
	}
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	// Metodos
	public double impuesto() {
		return this.precioTotal * (21/100);
	}
	
}
