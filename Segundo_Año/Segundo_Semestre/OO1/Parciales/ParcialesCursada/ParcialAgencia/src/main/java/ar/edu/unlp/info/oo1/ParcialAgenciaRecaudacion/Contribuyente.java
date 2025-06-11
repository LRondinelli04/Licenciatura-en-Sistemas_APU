package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialAgencia.src.main.java.ar.edu.unlp.info.oo1.ParcialAgenciaRecaudacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contribuyente {

	private String nombre, email, localidad;
	private int dni;
	private List<Bien> bienes;
	
	public Contribuyente(String n, int d, String e, String l) {
		this.nombre = n;
		this.dni = d;
		this.email = e;
		this.localidad = l;
		this.bienes = new ArrayList<Bien>();
	}
	
	public String getLocalidad() {
		return this.localidad;
	}
	
	public Bien darAltaBien(Bien b) {
		this.bienes.add(b);
		return b;
	}
	
	public Bien darAltaInmueble(int n, double vl, double ve) {
		return this.darAltaBien(new Inmueble(this, n, vl, ve));
	}
	
	public Bien darAltaAutomotor(String p, String m, String modelo, LocalDate ff, double v) {
		return this.darAltaBien(new Automotor(this, p, m, modelo, ff, v));
	}
	
	public Bien darAltaEmbarcacion(String p, String n, LocalDate ff, double v) {
		return this.darAltaBien(new Embarcacion(this, p, n, ff, v));
	}
	
	public double impuestoAPagar() {
		return this.bienes.stream()
				.mapToDouble(b -> b.calcularImpuesto())
				.sum();
	}
	
}
