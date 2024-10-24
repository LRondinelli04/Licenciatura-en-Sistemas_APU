package ar.edu.unlp.info.oo1.Ej12_VolumenYSuperficieDeSolidos;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public abstract class Pieza {

	protected String material;
	private String color;
	
	public Pieza(String material, String color) {
		this.material = material;
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double getVolumen();
	public abstract double getSuperficie();
	
	

}
