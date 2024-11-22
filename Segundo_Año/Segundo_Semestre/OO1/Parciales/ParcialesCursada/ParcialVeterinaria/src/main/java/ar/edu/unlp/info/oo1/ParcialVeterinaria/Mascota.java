package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {

	private String nombre, especie;
	private LocalDate fechaNacimiento;
	private List<Servicio> serviciosContratados;
	
	public Mascota(String n, LocalDate f, String e) {
		this.nombre = n;
		this.fechaNacimiento = f;
		this.especie = e;
		this.serviciosContratados = new ArrayList<Servicio>();
	}
	
	public List<Servicio> getServicios() {
		return this.serviciosContratados;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public Servicio registrarServicio(Servicio s) {
		this.serviciosContratados.add(s);
		return s;
	}
	
	public Servicio registrarConsultaMedica(Medico m, boolean material) {
		return this.registrarServicio(new ConsultaMedica(m, this, material));
	}
	
	public Servicio registrarVacunacion(Medico m, String nv, double c, boolean material) {
		return this.registrarServicio(new Vacunacion(m, this, nv, c, material));
	}
	
	public Servicio registrarGuarderia(int cd) {
		return this.registrarServicio(new Guarderia(cd, this));
	}
	
	public double montoRecaudacion(LocalDate fecha) {
		return this.serviciosContratados.stream()
				.filter(s -> s.getFecha().equals(fecha))
				.mapToDouble(s -> s.montoRecaudacion())
				.sum();
	}
	
	
}
