package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CompraRepuesto implements Orden {

	private String patente;
	private List<Repuesto> repuestos;
	private LocalDate fecha;
	
	public CompraRepuesto(String patente, List<Repuesto> repuestos) {
		this.patente = patente;
		this.repuestos = repuestos;
		this.fecha = LocalDate.now();
	}

	@Override
	public double costoDeOrden() {
	    double costo = 0.0;
	    for (Repuesto repuesto : this.repuestos) {
	        int anios = this.getDiferenciaAnios(repuesto.getFechaFabricacion());
	        if (this.repuestoAnios(anios)) {
	            costo += repuesto.getCosto() + (repuesto.getCosto() * 0.08); // Cambiado a +=
	        } else {
	            costo += repuesto.getCosto() + (repuesto.getCosto() * 0.15); // Cambiado a +=
	        }
	    }
	    
	    return costo;
	}
	
	public int getDiferenciaAnios(LocalDate fechaFabricacion) {
		return (int) ChronoUnit.YEARS.between(fechaFabricacion, LocalDate.now());
	}
	
	public boolean repuestoAnios(int anios) {
		if (anios > 5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getPatente() {
		return this.patente;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
}
