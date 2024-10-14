package ar.edu.unlp.info.oo1._Parcial;

public abstract class Producto {

	protected String nombre, descripcion;
	protected double costoUnitario;
	
	public Producto(String nombre, String descripcion, double costoUnitario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoUnitario = costoUnitario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract double calcularImpuesto(int cantSolicitada);
	
	
	
}
