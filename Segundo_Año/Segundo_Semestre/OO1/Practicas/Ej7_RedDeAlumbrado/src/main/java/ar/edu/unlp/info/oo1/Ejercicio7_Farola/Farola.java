package ar.edu.unlp.info.oo1.Ejercicio7_Farola;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Farola {

	private boolean prendida;
	private List<Farola> farolasVecinas;
	
	public Farola() {
		this.prendida = false;
		this.farolasVecinas = new ArrayList <Farola>();
	}
	
	public void pairWithNeighbor(Farola otraFarola) {
		// Conectar con las farolas entre si
		this.conectarFarola(otraFarola);
		otraFarola.conectarFarola(this);
	}
	
	public void conectarFarola(Farola otraFarola) {
		this.farolasVecinas.add(otraFarola);
	}
	
	
	public List <Farola> getNeighbors() {
		// obtener vecinos
		return this.farolasVecinas;
	}
	
	public void turnOff() {
		if (this.prendida) {
			this.prendida=false;
			
			// Por cada farola conectada, pasarla a false
			for (Farola farola : farolasVecinas) {
				farola.turnOff();
			}
		}
	}
	
	public void turnOn() {
		if (this.prendida == false) {
			this.prendida = true;
			
			for (Farola farola : farolasVecinas) {
				farola.turnOn();
			}
		}
	}
	
	public boolean isOn() {
		if (this.prendida) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean isOff() {
		if (this.prendida == false) {
			return true;
		} else {
			return false;
		}
	}
}
