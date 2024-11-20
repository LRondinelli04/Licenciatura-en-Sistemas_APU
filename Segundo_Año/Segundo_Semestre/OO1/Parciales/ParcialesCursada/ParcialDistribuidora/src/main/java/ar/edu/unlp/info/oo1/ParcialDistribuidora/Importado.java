package ar.edu.unlp.info.oo1.ParcialDistribuidora;

public class Importado extends Producto {

	private String paisOrigen;
	
	public Importado(String n, double cu, String d, String po) {
		super(n, cu, d);
		this.paisOrigen = po;
	}

	@Override
	public double calcImpuesto(int cantSolicitada) {
		if ((this.paisOrigen.equals("Brasil") || this.paisOrigen.equals("Paraguay") || this.paisOrigen.equals("Uruguay")) && cantSolicitada > 50) {
			return this.costoUnitario * 0.08;
		} else {
			return this.costoUnitario * 0.21;
		}
	}

}
