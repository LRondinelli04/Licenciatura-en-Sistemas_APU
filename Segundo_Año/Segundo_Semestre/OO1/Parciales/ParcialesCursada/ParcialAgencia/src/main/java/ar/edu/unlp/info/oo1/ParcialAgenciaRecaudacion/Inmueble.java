package ar.edu.unlp.info.oo1.ParcialAgenciaRecaudacion;

public class Inmueble extends Bien {

	private int numero;
	private double valorLote, valorEdificacion;
	
	public Inmueble(Contribuyente c, int n, double vl, double ve) {
		super(c);
		this.numero = n;
		this.valorLote = vl;
		this.valorEdificacion = ve;
	}

	@Override
	public double calcularImpuesto() {
		return (this.valorEdificacion + this.valorLote) * 0.01;
	}

}
