package ar.edu.unlp.info.oo1.Ej12_VolumenYSuperficieDeSolidos;

public class PrismaRectangular extends Pieza {


	private int ladoMayor, ladoMenor, altura;

	public PrismaRectangular(int ladoMayor, int ladoMenor, int altura, String material, String color) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}

	@Override
	public double getVolumen() {
		return (int) this.ladoMayor * this.ladoMenor * this.altura;
	}

	@Override
	public double getSuperficie() {
		return (int) (2 * (this.ladoMayor * this.ladoMenor + this.ladoMayor * this.altura + this.ladoMenor * this.altura));
	}
	
}
