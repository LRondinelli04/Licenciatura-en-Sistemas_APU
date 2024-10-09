package ar.edu.unlp.info.oo1._Parcial;

public class Limpieza extends Servicio{

	private double tarifaMin;
	
	public Limpieza(double precioXHora, int cantHoras, double tarifaMin) {
		super(precioXHora, cantHoras);
		this.tarifaMin = tarifaMin;
	}

	@Override
	public double montoAbonar() {
		double monto = this.precioXHora * this.cantHoras;
		if (monto < this.tarifaMin) {
			monto = this.tarifaMin;
		}
		return monto;
	}
	
}
