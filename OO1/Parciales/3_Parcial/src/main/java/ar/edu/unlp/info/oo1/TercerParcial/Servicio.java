package ar.edu.unlp.info.oo1.TercerParcial;

public abstract class Servicio {
	
	public double precioPorHora;
	public int horas;
	
	public Servicio(double precioPorHora, int horas) {
		this.precioPorHora = precioPorHora;
		this.horas = horas;
	}
	
	public abstract double calcularMonto();
	
	
	

}
