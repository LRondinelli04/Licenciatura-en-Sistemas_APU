package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

	protected String nombre, direccion;
	protected List<Envio> envios;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new ArrayList<Envio>();
	}
	
	public void agregarEnvio(Envio envio) {
		this.envios.add(envio);
	}
	
	public List<Envio> getEnvios() {
		return this.envios;
	}
	
	public abstract double montoAPagar(LocalDate fechaInicio, LocalDate fechaFin);
	
}
