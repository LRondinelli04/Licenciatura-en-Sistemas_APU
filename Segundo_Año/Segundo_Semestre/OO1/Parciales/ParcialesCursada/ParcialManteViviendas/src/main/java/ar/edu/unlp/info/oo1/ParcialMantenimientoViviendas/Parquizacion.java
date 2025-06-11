package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

public class Parquizacion extends Servicio {

	private int cantMaquinas;
	private double costoMaquina;
	
	public Parquizacion(double ph, int ch, int cm, double c) {
		super(ph, ch);
		this.cantMaquinas = cm;
		this.costoMaquina = c;
	}

	@Override
	public double montoServicio() {
		double monto = (this.precioHora * this.cantHoras) + (this.cantMaquinas * this.costoMaquina);
		return monto;
	}

}
