package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String email, domicilio;
	private LocalDate fechaIngreso;
	private List<Publicacion> publicaciones;
	
	public Usuario(String email, String domicilio) {
		this.email = email;
		this.domicilio = domicilio;
		this.fechaIngreso = LocalDate.now();
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}
	
	public Publicacion registrarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
		return publicacion;
	}
	
	public int calcularAntiguedad() {
		int anios = Period.between(fechaIngreso, LocalDate.now()).getYears();
		return anios;
	}
	
}
