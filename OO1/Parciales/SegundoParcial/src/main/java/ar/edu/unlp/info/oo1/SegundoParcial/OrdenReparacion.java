package ar.edu.unlp.info.oo1.SegundoParcial;

import java.time.LocalDate;
import java.util.List;

public class OrdenReparacion {

	private String patente, descripcionReparacion;
	private List<Repuesto> listaRepuestos;
	private List<Empleado> empleados;
	private int horasNecesarias;
	private LocalDate fechaActual;
	
	public OrdenReparacion(String patente, String descripcionReparacion, int horasNecesarias, List<Empleado> empleados, List<Repuesto> listaRepuestos) {
		
		this.patente = patente;
		this.descripcionReparacion = descripcionReparacion;
		this.horasNecesarias = horasNecesarias;
		this.fechaActual = LocalDate.now();
		this.empleados = empleados;
		this.listaRepuestos = listaRepuestos;
	}
	
	
	public double costoTotal() {
		double total = 0.0;
		
		double totalEmpleados = 0.0;
		// Sumar la cant de emplados * su cant de horas de reparacion
		for (Empleado empleado : this.empleados) {
			totalEmpleados += empleado.getValorHora() * this.horasNecesarias;
		}
		
		double costoRepuestos = 0.0;
		for (Repuesto repuesto : this.listaRepuestos) {
			costoRepuestos += repuesto.getCosto();
		}
		
		double incremento = (totalEmpleados + costoRepuestos) * 0.1;
		
		total = totalEmpleados + costoRepuestos + incremento;
		
		return total;
	}
	
	public double getCostoTotal() {
		return this.costoTotal();
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	public String getDescripcion() {
		return this.descripcionReparacion;
	}
	
}
