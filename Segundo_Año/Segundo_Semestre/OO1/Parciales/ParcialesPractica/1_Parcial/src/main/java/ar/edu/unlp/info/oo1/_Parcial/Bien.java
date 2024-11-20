package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface Bien {

	public double calcularImpuesto();
	
	static boolean superaLosDiezAnios(LocalDate fechaFabricacion) {
		return ChronoUnit.YEARS.between(fechaFabricacion, LocalDate.now()) > 10;
	}
}
