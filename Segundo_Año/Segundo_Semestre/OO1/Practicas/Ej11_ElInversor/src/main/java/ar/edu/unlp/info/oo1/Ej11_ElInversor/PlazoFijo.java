package ar.edu.unlp.info.oo1.Ej11_ElInversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {

	private LocalDate fechaDeConstitucion;
	private double montoDepositado, porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	
	public double valorActual() {
		// caluclar los dias desde la fecha de constitucion hasta la actual
		double dias = ChronoUnit.DAYS.between(this.fechaDeConstitucion,LocalDate.now());
		double interesPorPorcentaje = dias * this.porcentajeDeInteresDiario;
		return (this.montoDepositado +  interesPorPorcentaje);
	}
	
}
