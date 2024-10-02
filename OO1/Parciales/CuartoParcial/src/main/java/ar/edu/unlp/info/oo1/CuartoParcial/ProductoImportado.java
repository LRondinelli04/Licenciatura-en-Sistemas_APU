package ar.edu.unlp.info.oo1.CuartoParcial;

public class ProductoImportado extends Producto{

	private String paisOrigen;
	
	public ProductoImportado(String nombre, String descripcion, double costo, String paisOrigen) {
		super(nombre, descripcion, costo);
		this.paisOrigen = paisOrigen;
	}

	@Override
	public double calcularImpuesto(int cant) {
		if (this.paisOrigen.equals("Brazil") || this.paisOrigen.equals("Paraguay") || this.paisOrigen.equals("Uruguay")) {
			if (cant > 50) {
				return (super.costo * cant * 0.08);
			}
		}
		return (super.costo * cant * 0.21);
	}

}
