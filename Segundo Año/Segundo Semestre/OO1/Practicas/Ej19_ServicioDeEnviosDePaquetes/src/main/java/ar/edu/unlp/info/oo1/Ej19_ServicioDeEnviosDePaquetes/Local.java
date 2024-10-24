package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class Local extends Envio{

	private boolean entregaRapida;
	
	public Local(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso, boolean entregaRapida) {
		super(fechaDespacho, direccionOrigen, direccionDestino, peso);
		this.entregaRapida = entregaRapida;
	}

	@Override
	public double calcularEnvio() {
		if (this.entregaRapida == true) {
			return 1500;
		} else {
			return 1000;
		}
	}

}
