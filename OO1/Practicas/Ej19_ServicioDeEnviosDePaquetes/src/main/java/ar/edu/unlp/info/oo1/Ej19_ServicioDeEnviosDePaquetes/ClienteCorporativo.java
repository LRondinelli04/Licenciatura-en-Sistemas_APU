package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class ClienteCorporativo extends Cliente {

	private int cuit;
	
	public ClienteCorporativo(String nombre, String direccion, int cuit) {
		super(nombre, direccion);
		this.cuit = cuit;
	}

	@Override
	public double montoAPagar(LocalDate fechaInicio, LocalDate fechaFin) {
		double monto = 0;
		for (Envio envio : this.envios) {
			if (envio.getFechaDespacho().isAfter(fechaInicio) && envio.getFechaDespacho().isBefore(fechaFin)) {				
				monto += envio.calcularEnvio();
			}
		}
		return monto;
	}

}
