package ar.edu.unlp.info.oo1.Ej11_ElInversor;

import java.util.ArrayList;
import java.util.List;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Inversor {

	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList <Inversion>();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	// Conseguir el valor actual de las inversiones (cantidad?)
	public double valorActual() {
		double total = 0.0;
		/*  Por cada inversion dentro de la lista de inversiones
		 *  Tomo su valor actual y los sumo a TOTAL
		 *  retorno el TOTAL
		 */
		for (Inversion inversion : this.inversiones) {
			total += inversion.valorActual();
		}
		return total;
	}
	
	// agregar una inversion
	public void agregarInversion(Inversion inversion) {
		this.inversiones.add(inversion);
	}
}
