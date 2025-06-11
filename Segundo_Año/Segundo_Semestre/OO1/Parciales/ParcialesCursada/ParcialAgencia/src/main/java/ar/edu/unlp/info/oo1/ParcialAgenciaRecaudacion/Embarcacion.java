package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialAgencia.src.main.java.ar.edu.unlp.info.oo1.ParcialAgenciaRecaudacion;

import java.time.LocalDate;

public class Embarcacion extends Bien {

	private String patente, nombre;
	private LocalDate fechaFabricacion;
	private double valor;
	
	public Embarcacion(Contribuyente c, String p, String n, LocalDate ff, double v) {
		super(c);
		this.patente = p;
		this.nombre = n;
		this.fechaFabricacion = ff;
		this.valor = v;
	}

	@Override
	public double calcularImpuesto() {
		double monto = 0;
		if (this.superaFecha(this.fechaFabricacion)) {
			return 0;			
		} else {
			if (this.valor < 1000000) {
				monto = this.valor * 0.1;
			} else {
				monto = this.valor = 0.15;
			}
		}
		return monto;
	}

}
