package ar.edu.unlp.info.oo1._Parcial;

public class Nacional extends Producto {

	public Nacional(String nombre, String descripcion, double costoUnitario) {
		super(nombre, descripcion, costoUnitario);
	}

	@Override
	public double calcularImpuesto(int cantSolicitada) {
		if (cantSolicitada <= 10) {
			return this.costoUnitario * 0.05;
		} else {
			return 0;
		}
	}

}
