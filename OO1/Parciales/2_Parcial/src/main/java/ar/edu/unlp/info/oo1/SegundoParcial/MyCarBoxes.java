package ar.edu.unlp.info.oo1.SegundoParcial;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class MyCarBoxes {

	private List<Empleado> empleado;
	private List<Repuesto> repuestos;
	
	public MyCarBoxes() {
		this.empleado = new ArrayList<Empleado>();
		this.repuestos = new ArrayList<Repuesto>();
	}
	
	
	public void addEmpleado(Empleado empleado) {
		this.empleado.add(empleado);
	}
	
	public void addRpuesto(Repuesto repuesto) {
		this.repuestos.add(repuesto);
	}
	
	public List<Empleado> getEmpleados(){
		return this.empleado;
	}
	
	public List<Repuesto> getRepuestos(){
		return this.repuestos;
	}
	
	/*
	public void getEmpleado() {
		for(Empleado empleado : this.empleado) {
			System.out.println(empleado);
		}
	}
	
	public void getRepuesto() {
		for (Repuesto repuesto : this.repuestos) {
			System.out.println(repuesto);
		}
	}
	*/

}
