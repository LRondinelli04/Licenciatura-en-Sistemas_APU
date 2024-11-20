package ar.edu.unlp.info.oo1._Parcial;

public class ProductoNacional extends Producto {

	public ProductoNacional(String nombre, double costoUnitario, String descripcion) {
		super(nombre, costoUnitario, descripcion);
	}

	@Override
	public double calcularImpuesto(int cantNecesaria, double costoUnitario) {
		if (cantNecesaria < 10) {
			return costoUnitario * 0.05;
		} else {
			return 0;
		}
	}

}
