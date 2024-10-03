package ar.edu.unlp.info.oo1.QuintoParcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {

	private String nombre, especie;
	private LocalDate nacimiento;
	private List<Servicio> servicios;
	
	public Mascota(String nombre, String especie, LocalDate nacimiento) {
		this.nombre = nombre;
		this.especie = especie;
		this.nacimiento = nacimiento;
		this.servicios = new ArrayList<Servicio>();
	}
	
	public void registrarServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public int getServicios() {
		return this.servicios.size();
	}
	
	public double montoGeneradoMascota(LocalDate fecha) {
		double total = 0.0;
		for (Servicio servicio : this.servicios) {
			if (servicio.getFecha().equals(fecha)) {
				total += servicio.costoServicio();
			}
		}
		return total;
	}
	
	public LocalDate getNacimiento() {
		return this.nacimiento;
	}
}
