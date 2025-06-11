package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialAgencia.src.main.java.ar.edu.unlp.info.oo1.ParcialAgenciaRecaudacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Bien {

	protected Contribuyente contribuyente;
	
	public Bien(Contribuyente c) {
		this.contribuyente = c;
	}
	
	public abstract double calcularImpuesto();
	
	public boolean superaFecha(LocalDate ff) {
		if (ChronoUnit.YEARS.between(ff, LocalDate.now()) > 10) {
			return true;
		} else {
			return false;
		}
	}
	
}
