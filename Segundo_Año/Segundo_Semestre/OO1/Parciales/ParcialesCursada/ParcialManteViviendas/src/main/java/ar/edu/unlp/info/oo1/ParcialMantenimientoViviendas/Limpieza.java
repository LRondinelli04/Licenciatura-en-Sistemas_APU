package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

public class Limpieza extends Servicio {

	private double tarifa;
	
	public Limpieza(double ph, int ch, double t) {
		super(ph, ch);
		this.tarifa = t;
	}

	@Override
	public double montoServicio() {
		double monto = this.precioHora * this.cantHoras;
		if (monto < this.tarifa) {
			return this.tarifa;
		} else {			
			return monto;
		}
	}

}
