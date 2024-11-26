package ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

import java.time.LocalDate;

public abstract class Contrato {

	protected Servicio servicio;
	protected Cliente cliente;
	protected LocalDate fecha;
	
	public Contrato(Servicio s, Cliente c, LocalDate f) {
		this.servicio = s;
		this.cliente = c;
		this.fecha = f;
	}
	
	public abstract double montoAPagar();
	
}
