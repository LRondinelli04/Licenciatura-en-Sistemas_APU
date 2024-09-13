package ar.edu.unlp.info.oo1.Ejercicio_FigurasYCuerpos;

public class Circulo {

	//private double diametro;
	private double radio;
	
	public Circulo() {	
	}
	
	public double getDiametro() {
		double diametro = this.radio * 2;
		return diametro;
	}
	/*public void setDiametro(double diametro) {
		this.diametro = diametro;
	}*/
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double getPerimetro() {
		return (Math.PI * this.getDiametro());
	}
	public double getArea() {
		return (Math.PI * Math.pow(this.radio, 2));
	}
	
	
	
}
