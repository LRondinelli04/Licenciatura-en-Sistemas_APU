package ar.edu.unlp.info.oo1.TercerParcial;

public class Limpieza extends Servicio {

	private double tarifaMin;

	public Limpieza(double precioPorHora, int horas, double tarifaMin) {
		super(precioPorHora, horas);
		this.tarifaMin = tarifaMin;
	}

	@Override
	public double calcularMonto() {
		double monto = super.precioPorHora * super.horas;
		
		if (monto < this.tarifaMin) {
			monto = this.tarifaMin;
		}
		
		return monto;
		
	}
	
	
	
	
	
}
