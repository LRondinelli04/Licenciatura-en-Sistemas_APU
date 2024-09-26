package ar.edu.unlp.info.oo1.Ej12_VolumenYSuperficieDeSolidos;

public class Esfera extends Pieza{

	private int radio;
	
	public Esfera(int radio, String material, String color) {
		super(material, color);
		this.radio = radio;
	}
	
	public int getRadio() {
		return radio;
	}

	@Override
	public double getVolumen() {
		return 1.33333333333 * Math.PI * Math.pow(this.getRadio(), 3);
	}

	@Override
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(this.getRadio(), 2);
	}
	
}
