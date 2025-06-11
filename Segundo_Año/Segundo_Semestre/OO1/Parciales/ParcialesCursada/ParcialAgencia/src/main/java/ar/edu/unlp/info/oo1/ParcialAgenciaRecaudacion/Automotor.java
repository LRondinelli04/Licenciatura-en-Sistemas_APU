package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialAgencia.src.main.java.ar.edu.unlp.info.oo1.ParcialAgenciaRecaudacion;

import java.time.LocalDate;

public class Automotor extends Bien {

	private String patente, marca, modelo;
	private LocalDate fechaFabricacion;
	private double valor;
	
	
	public Automotor(Contribuyente c, String p, String m, String modelo, LocalDate ff, double v) {
		super(c);
		this.patente = p; 
		this.marca = m;
		this.modelo = modelo;
		this.fechaFabricacion = ff;
		this.valor = v;
	}


	@Override
	public double calcularImpuesto() {
		if (this.superaFecha(this.fechaFabricacion)) {
			return 0;
		} else {
			return this.valor * 0.05;
		}
	}

	
	
}
