package ar.edu.unlp.info.oo1.ParcialDistribuidora;

public class Nacional extends Producto {

	public Nacional(String n, double cu, String d) {
		super(n, cu, d);
	}

	@Override
	public double calcImpuesto(int cantSolicitada) {
		if (cantSolicitada <= 10) {
			return this.costoUnitario * 0.05;
		} else {
			return 0;
		}
	}

}
