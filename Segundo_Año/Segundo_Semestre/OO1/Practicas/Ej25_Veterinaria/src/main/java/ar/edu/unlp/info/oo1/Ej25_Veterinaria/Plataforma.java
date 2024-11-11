package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plataforma {

	private List<Medico> medicos;
	private List<Mascota> mascotas;
	
	public Plataforma() {
		this.medicos = new ArrayList<Medico>();
		this.mascotas = new ArrayList<Mascota>();
	}
	
	public List<Medico> getMedicos() {
		return this.medicos;
	}
	
	public List<Mascota> getMascotas() {
		return this.mascotas;
	}
	
	public void addMedico(Medico medico) {
		this.medicos.add(medico);
	}
	public void addMascota(Mascota mascota) {
		this.mascotas.add(mascota);
	}
	
	public ConsultaMedica darAltaConsutlaMedica(Medico medico, Mascota mascota) {
		ConsultaMedica s = new ConsultaMedica(mascota, medico, LocalDate.now());
		mascota.darAltaServicio(s);
		return s;
	}
	
	public Vacunacion darAltaVacunacion(Medico medico, Mascota mascota, String nombreV, double costo, LocalDate fecha) {
		Vacunacion s = new Vacunacion(mascota, medico, fecha, nombreV, costo);
		mascota.darAltaServicio(s);
		return s;
	}
	
	public Guarderia darAltaGuarderia(Mascota mascota, int cantDias) {
		Guarderia s = new Guarderia(mascota, cantDias);
		mascota.darAltaServicio(s);
		return s;
	}
}
