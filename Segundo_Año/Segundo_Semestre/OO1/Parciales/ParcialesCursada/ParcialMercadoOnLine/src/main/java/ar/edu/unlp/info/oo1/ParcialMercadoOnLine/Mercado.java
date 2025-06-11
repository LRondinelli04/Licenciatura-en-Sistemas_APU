package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.main.java.ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mercado {

	private List<Usuario> usuarios;
	private List<Publicacion> publicaciones;
	
	public Mercado() {
		this.usuarios = new ArrayList<Usuario>();
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	public Usuario registrarUsuario(String e, String l) {
		Usuario u = new Usuario(e, l);
		this.usuarios.add(u);
		return u;
	}
	
	public Publicacion registrarProductoNuevo(Usuario u, String n, String d, double pu, int cd, FormaEntrega fe) {
		ProductoNuevo p = new ProductoNuevo(u, n, d, pu, cd, fe);
		this.publicaciones.add(p); // lo cargo en la lista del mercado
		return u.registrarPublicacion(p); // lo cargo en la lista de publicaciones del usuario
		
	}
	
	public Publicacion registrarProductoUsado(Usuario u, String n, String d, double p) {
		ProductoUsado pu = new ProductoUsado(u, n, d, p);
		this.publicaciones.add(pu); // lo cargo en la lista del mercado
		return u.registrarPublicacion(pu); // lo cargo en la lista de publicaciones del usuario
	}
	
	public Publicacion registrarServicio(Usuario u, String n, String d, double p) {
		Servicio s = new Servicio(u, n, d, p);
		this.publicaciones.add(s); // lo cargo en la lista del mercado
		return u.registrarPublicacion(s); // lo cargo en la lista de publicaciones del usuario
	}
	
	public double precioFinalPublicacion(Publicacion publicacion, String localidad) {
		double monto = 0;
		for (Publicacion p : this.publicaciones) {
			if (p.equals(publicacion)) {
				monto = p.precioFinalPublicacion(localidad);
			}
		}
		return monto;
	}
	
	public List<Publicacion> publicacionesMasCaras(String localidad) {
		return this.publicaciones.stream()
				.filter(p -> p.getUsuario().getLocalidad().equals(localidad)) // filtro las publicaciones de la localidad
				.sorted((p1, p2) -> Double.compare(p2.precioFinalPublicacion(localidad), p1.precioFinalPublicacion(localidad))) // las ordeno de mayor a menor (por precio final)
				.limit(10) // limito las primeras 10 publicaciones mas caras
				.collect(Collectors.toList());
	}
	
	public List<Publicacion> publicacionesOrdenadas(String localidad){
		return this.publicaciones.stream()
				.filter(p -> p.getUsuario().getLocalidad().equals(localidad)) // filtro la lista de publicaciones por localidad
				.sorted((p1, p2) -> Double.compare(p1.precioFinalPublicacion(localidad), p2.precioFinalPublicacion(localidad))) // las ordeno de menor a mayor precio
				.collect(Collectors.toList());
	}
	
}
