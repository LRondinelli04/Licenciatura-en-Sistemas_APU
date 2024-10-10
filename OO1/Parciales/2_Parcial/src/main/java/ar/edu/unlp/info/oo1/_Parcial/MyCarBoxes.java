package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class MyCarBoxes {

	/*
	 * dar de alta un repuesto
	 * 
	 * dar de alta un empleado
	 * 
	 * registrar una orden de compra de repuestos
	 * 
	 * registrar una orden de reaparacion
	 * 
	 * facturar un conjunto de ordenes
	 * 
	 * */
	
	private List<Empleado> empleados;
	private List<Repuesto> repuestos;
	private List<Orden> ordenes;
	
	public MyCarBoxes() {
		this.empleados = new ArrayList<Empleado>();
		this.repuestos = new ArrayList<Repuesto>();
		this.ordenes = new ArrayList<Orden>();
	}
	
	public Empleado darAltaEmpleado(String nombreCompleto, double valorXHora) {
		Empleado empleado = new Empleado(nombreCompleto, valorXHora);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public Repuesto darAltaRepuesto(String nombre, LocalDate fechaFabricacion, double costo) {
		Repuesto repuesto = new Repuesto(nombre, fechaFabricacion, costo);
		this.repuestos.add(repuesto);
		return repuesto;
	}
	
	public CompraRepuesto registrarCompraRepuesto(String patente) {
		CompraRepuesto cr = new CompraRepuesto(patente, this.repuestos);
		this.ordenes.add(cr);
		return cr;
	}
	
	public Reparacion registrarReparacion(String patente, String descripcion, int cantHoras) {
		Reparacion r = new Reparacion(patente, descripcion, this.repuestos, this.empleados, cantHoras);
		this.ordenes.add(r);
		return r;
	}
	
	public double facturarOrdenes(List<Orden> ordenesFacturar) {
		double total = 0;
		for (Orden orden : ordenesFacturar) {
			double monto = orden.costoDeOrden();
			
			if (this.ordenExistente(orden.getPatente())) {
				double descuento = monto * 0.05;
				monto -= descuento;
			}
			
			total += monto;
			
		}
		return total;
	}
	
	public boolean ordenExistente(String patente) {
	    LocalDate unAnoAtras = LocalDate.now().minusYears(1); // Calculamos la fecha de hace un año

	    for (Orden orden : this.ordenes) {
	        // Comprobamos si la patente coincide y si la fecha está dentro del último año
	        if (orden.getPatente().equals(patente) && orden.getFecha().isAfter(unAnoAtras)) {
	            System.out.println("Se encontró una orden existente para la patente: " + patente);
	            return true; // Retornamos true inmediatamente si encontramos una coincidencia
	        }
	    }

	    System.out.println("No se encontró ninguna orden existente para la patente: " + patente);
	    return false; // Retornamos false si no encontramos ninguna coincidencia
	}

	
	public List<Empleado> getEmpleados() {
		return this.empleados;
	}
	
	public List<Repuesto> getRepuestos() { 
		return this.repuestos; 
	}
	
	public List<Orden> getOrden() {
		return this.ordenes;
	}
	

}
