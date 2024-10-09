package ar.edu.unlp.info.oo1._Parcial;

public abstract class Servicio {

	protected double precioXHora;
	protected int cantHoras;
	
	public Servicio(double precioXHora, int cantHoras) {
		this.precioXHora = precioXHora;
		this.cantHoras = cantHoras;
	}
	
	public abstract double montoAbonar();
	
}
