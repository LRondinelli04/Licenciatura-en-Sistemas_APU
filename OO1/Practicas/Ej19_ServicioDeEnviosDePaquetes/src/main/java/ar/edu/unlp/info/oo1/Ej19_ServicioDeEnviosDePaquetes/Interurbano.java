package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class Interurbano extends Envio {

	private double distancia;
	
	public Interurbano(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso, double distancia) {
		super(fechaDespacho, direccionOrigen, direccionDestino, peso);
		this.distancia = distancia;
	}

	@Override
	public double calcularEnvio() {
		if (this.distancia < 100) {
			return 20 * this.peso;
		} else if (this.distancia >= 100 && this.distancia < 500) {
			return 25 * this.peso;
		} else {
			return 30 * this.peso;
		}
	}

}
