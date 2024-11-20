package ar.edu.unlp.info.oo1._Parcial;

public class ProductoImportado extends Producto {

	private String paisOrigen;
	
	public ProductoImportado(String nombre, double costoUnitario, String descripcion, String paisOrigen) {
		super(nombre, costoUnitario, descripcion);
		this.paisOrigen = paisOrigen;
	}

	@Override
	public double calcularImpuesto(int cantNecesaria, double costoUnitario) {
		if ((this.paisOrigen.equals("Brazil") || this.paisOrigen.equals("Uruguay") || this.paisOrigen.equals("Paraguay")) && (cantNecesaria > 50)) {
			return costoUnitario * 0.08;
		} else {
			return costoUnitario * 0.21;
		}
	}

}
