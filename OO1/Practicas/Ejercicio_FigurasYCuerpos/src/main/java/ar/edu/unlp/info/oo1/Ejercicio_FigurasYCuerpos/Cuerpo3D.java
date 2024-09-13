package ar.edu.unlp.info.oo1.Ejercicio_FigurasYCuerpos;

public class Cuerpo3D {

	private double altura, areaCaraBasal, perimetroCaraBasal;
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(Circulo circulo) {
		this.areaCaraBasal = circulo.getArea();
		this.perimetroCaraBasal = circulo.getPerimetro();
	}
	
	public void setCaraBasal(Cuadrado cuadrado) {
		this.areaCaraBasal = cuadrado.getArea();
		this.perimetroCaraBasal = cuadrado.getPerimetro();
	}
	
	public double getVolumen() {
		return (this.areaCaraBasal * this.altura);
	}
	public double getSuperficieExterior() {
		return (2 * this.areaCaraBasal) + (this.perimetroCaraBasal * this.altura);
	}
	
}
