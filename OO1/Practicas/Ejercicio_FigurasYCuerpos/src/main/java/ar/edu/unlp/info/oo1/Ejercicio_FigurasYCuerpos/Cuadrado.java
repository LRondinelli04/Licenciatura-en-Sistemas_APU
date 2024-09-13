package ar.edu.unlp.info.oo1.Ejercicio_FigurasYCuerpos;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Cuadrado {

	private double lado;
	
	public Cuadrado() {
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {
		return this.getLado() * 4;
	}
	
	public double getArea() {
		return this.getLado() * this.getLado();
	}
	
}
