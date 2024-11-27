package ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String email, localidad;
	private LocalDate fechaIngreso;
	private List<Publicacion> publicaciones;
	
	public Usuario(String e, String l) {
		this.email = e;
		this.localidad = l;
		this.fechaIngreso = LocalDate.now();
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	public Publicacion registrarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
		return publicacion;
	}
	
	public LocalDate getFecha() {
		return this.fechaIngreso;
	}
	
	public String getLocalidad() {
		return this.localidad;
	}
}
