package ar.edu.unlp.info.oo1.PrimerParcialCursada;

public class Sede {

	private String nombre;
	private double precio;
	private int cantDias;
	
	public Sede(String n, double p, int cd) {
		this.nombre = n;
		this.precio = p;
		this.cantDias = cd;
	}
	
	public double precioSede() {
		return this.precio * this.cantDias;
	}
	
}
