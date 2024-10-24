package ar.edu.unlp.info.oo1._Parcial;

public class Inmueble implements Bien {

	private int numeroPartida;
	private double valorLote, valorEdificacion;
	private Contribuyente contribuyente;
	
	public Inmueble (int numeroPartida, double valorLote, double valorEdificacion, Contribuyente contribuyente) {
		this.numeroPartida = numeroPartida;
		this.valorLote = valorLote;
		this.valorEdificacion = valorEdificacion;
		this.contribuyente = contribuyente;
	}

	@Override
	public double calcularImpuesto() {
		double valorInmueble = this.valorLote + this.valorEdificacion;
		double monto = valorInmueble * 0.01;
		return monto;
	}
	
}
