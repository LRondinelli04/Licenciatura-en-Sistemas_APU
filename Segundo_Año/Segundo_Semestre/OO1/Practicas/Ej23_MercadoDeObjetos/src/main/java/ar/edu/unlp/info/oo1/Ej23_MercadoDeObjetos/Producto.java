package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

public class Producto {

	private String nombre, categoria;
	private double precio;
	private int cantDisponible;
	
	public Producto(String nombre, String categoria, double precio, int cantDisponible) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public int getCantDisponible() {
		return this.cantDisponible;
	}
	
	public void restarCantSolicitada(int cantSolicitada) {
		this.cantDisponible -= cantSolicitada;
	}
	
}
