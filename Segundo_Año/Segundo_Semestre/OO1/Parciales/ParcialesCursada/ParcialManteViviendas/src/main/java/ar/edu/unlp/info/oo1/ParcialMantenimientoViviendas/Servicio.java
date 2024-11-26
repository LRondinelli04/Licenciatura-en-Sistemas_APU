package ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

public abstract class Servicio {

	protected double precioHora;
	protected int cantHoras;
	
	public Servicio(double ph, int ch) {
		this.cantHoras = ch;
		this.precioHora = ph;
	}

	public abstract double montoServicio();
	
}
