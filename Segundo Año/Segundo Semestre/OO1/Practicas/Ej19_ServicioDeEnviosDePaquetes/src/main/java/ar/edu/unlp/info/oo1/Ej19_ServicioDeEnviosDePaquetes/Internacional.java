package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class Internacional extends Envio {

	public Internacional(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso) {
		super(fechaDespacho, direccionOrigen, direccionDestino, peso);
	}

	@Override
	public double calcularEnvio() {
		double envio = 5000;
		if (this.peso <= 1000) {
			return envio + (10 * this.peso);
		} else {
			return envio + (12 * this.peso);
		}
	}

}
