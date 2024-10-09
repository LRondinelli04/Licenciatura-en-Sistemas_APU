package ar.edu.unlp.info.oo1._Parcial;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ContratoUnico extends Contrato {

	private LocalDate fecha;
	
	public ContratoUnico(Cliente cliente, Servicio servicio, LocalDate fecha) {
		super(cliente, servicio);
		this.fecha = fecha;
	}

	@Override
	public double calcularMonto() {
		double monto = this.servicio.montoAbonar();
		if (this.finDeSemana()) {
			double recargo = monto * 0.15;
			monto += recargo;
		}
		return monto;
	}

	public boolean finDeSemana() {
		DayOfWeek dia = DayOfWeek.from(fecha);
		if (dia.equals(DayOfWeek.SATURDAY) || dia.equals(DayOfWeek.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}

	
}
