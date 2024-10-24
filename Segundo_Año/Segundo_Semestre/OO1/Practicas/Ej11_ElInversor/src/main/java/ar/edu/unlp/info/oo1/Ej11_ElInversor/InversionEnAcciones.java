package ar.edu.unlp.info.oo1.Ej11_ElInversor;

public class InversionEnAcciones implements Inversion {

	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}
	
	public double valorActual() {
		// tomo la cantidad que tiene x el valor unitario de cada uno
		return (this.cantidad * this.valorUnitario);
	}
}
