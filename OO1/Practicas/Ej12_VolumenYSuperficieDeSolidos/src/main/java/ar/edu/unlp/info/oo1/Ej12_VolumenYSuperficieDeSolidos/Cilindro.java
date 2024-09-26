package ar.edu.unlp.info.oo1.Ej12_VolumenYSuperficieDeSolidos;

public class Cilindro extends Pieza{

	private int radio, altura;
	
	public Cilindro(int radio, int altura, String material, String color) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	
	public double getVolumen() {
		return (int) Math.PI * this.radio * this.altura;
	}
	
	public double getSuperficie() {
		return (int) ((2 * Math.PI * this.radio * this.altura) + 2* Math.PI * Math.pow(this.radio,2));
	}
	
}
