package ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

public abstract class Publicacion {

	protected Usuario usuario;
	protected String nombre, descripcion;
	protected double precio;
	
	public Publicacion(Usuario u, String n, String d, double p) {
		this.usuario = u;
		this.nombre = n;
		this.descripcion = d;
		this.precio = p;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public abstract double precioFinalPublicacion(String localidad);


}
