package ar.edu.unlp.info.oo1._Parcial;

public abstract class Publicacion {
	
	protected Usuario usuario;
	protected String nombre, descripcion;
	protected double precio;
	
	public Publicacion(Usuario usuario, String nombre, String descripcion, double precio) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public abstract double calcularPrecioFinal(String localidad);

}
