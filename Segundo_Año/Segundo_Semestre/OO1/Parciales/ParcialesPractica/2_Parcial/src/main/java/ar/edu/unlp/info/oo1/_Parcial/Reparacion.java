package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.List;

public class Reparacion implements Orden {

	private String patente, descripcion;
	private List<Repuesto> repuestos;
	private List<Empleado> empleados;
	private int cantHoras;
	private LocalDate fecha;
	
	public Reparacion(String patente, String descripcion, List<Repuesto> repuestos, List<Empleado> empleados, int cantHoras) {
		this.patente = patente;
		this.descripcion = descripcion;
		this.repuestos = repuestos;
		this.empleados = empleados;
		this.cantHoras = cantHoras;
		this.fecha = LocalDate.now();
	}

	@Override
	public double costoDeOrden() {
		double costo = 0.0;
		double precioEmpleados = 0.0;
		double costoRepuesto = 0.0;
		
		for (Empleado empleado : this.empleados) {
			precioEmpleados += empleado.getValorXHora() * this.cantHoras;
		}
		
		for (Repuesto repuesto : this.repuestos) {
			costoRepuesto += repuesto.getCosto();
		}
		
		costo = precioEmpleados + costoRepuesto;
		double incremento = costo * 0.1;
		
		costo += incremento;
		
		return costo;
	}

	@Override
	public String getPatente() {
		return this.patente;
	}

	@Override
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	
}
