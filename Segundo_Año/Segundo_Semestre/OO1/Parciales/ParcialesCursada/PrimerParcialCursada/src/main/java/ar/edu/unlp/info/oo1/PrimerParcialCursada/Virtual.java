package ar.edu.unlp.info.oo1.PrimerParcialCursada;

import java.time.LocalDate;

public class Virtual extends Evento {

	private double montoFijo;
	
	public Virtual(String n, LocalDate f, String tp, double pi, double pr, double mf) {
		super(n, f, tp, pi, pr);
		this.montoFijo = mf;
	}

	@Override
	public double precioAsistencia() {
		double monto = this.precioI + this.precioR + this.montoFijo;
		monto = this.fechaConsulta(monto);
		return monto;
	}

}
