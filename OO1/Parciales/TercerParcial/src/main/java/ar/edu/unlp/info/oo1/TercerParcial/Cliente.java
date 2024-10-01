package ar.edu.unlp.info.oo1.TercerParcial;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Cliente {

	private String nombre, direccion;
	private List<Servicio> servicios;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.servicios = new ArrayList<Servicio>();
	}
	
	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
}
