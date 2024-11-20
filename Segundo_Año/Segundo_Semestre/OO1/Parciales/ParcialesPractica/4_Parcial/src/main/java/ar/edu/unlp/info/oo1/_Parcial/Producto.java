package ar.edu.unlp.info.oo1._Parcial;

public abstract class Producto {

	protected String nombre, descripcion;
	protected double costoUnitario;
	
	public Producto(String nombre, double costoUnitario, String descripcion) {
		this.nombre = nombre;
		this.costoUnitario = costoUnitario;
		this.descripcion = descripcion;
	}
	
	public abstract double calcularImpuesto(int cantNecesaria, double costoUnitario);
	
}
