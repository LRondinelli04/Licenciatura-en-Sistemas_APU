package ar.edu.unlp.info.oo1.CuartoParcial;

public class ProductoNacional extends Producto{

	public ProductoNacional(String nombre, String descripcion, double costo) {
		super(nombre, descripcion, costo);
	}

	@Override
	public double calcularImpuesto(int cant) {
		if (cant <= 10) {
			return (super.costo * 0.05);
		}
		return 0;
	}

	
	

}
