package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mascota {

	private String nombre, especie;
	private LocalDate fechaNacimiento;
	private List<Servicio> servicios;
	
	public Mascota (String nombre, LocalDate fechaNacimiento, String especie) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.especie = especie;
		this.servicios = new ArrayList<Servicio>();
	}
	
	public Servicio darAltaServicio(Servicio s) {
		this.servicios.add(s);
		return s;
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
	public double recaudacionGeneradaPorMascota(LocalDate fecha) {
		List<Servicio> servicios = this.servicios.stream()
								.filter(s -> s.getFechaSolicitada().equals(fecha))
								.collect(Collectors.toList());
		double total = 0;
		for (Servicio s : servicios) {
			total += s.costoServicio();
		}
		return total;
	}
	
}
