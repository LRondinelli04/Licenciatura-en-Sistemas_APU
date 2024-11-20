package ar.edu.unlp.info.oo1._Parcial;

public class Importado extends Producto {

	private String paisOrigen;
	
	public Importado(String nombre, String descripcion, double costoUnitario, String paisOrigen) {
		super(nombre, descripcion, costoUnitario);
		this.paisOrigen = paisOrigen;
	}

	@Override
	public double calcularImpuesto(int cantSolicitada) {
		if ((this.paisOrigen.equals("Brazil") || this.paisOrigen.equals("Paraguay") || this.paisOrigen.equals("Uruguay")) && (cantSolicitada > 50)) {
			return this.costoUnitario * 0.08;
		} else {
			return this.costoUnitario * 0.21;
		}
	}

}
