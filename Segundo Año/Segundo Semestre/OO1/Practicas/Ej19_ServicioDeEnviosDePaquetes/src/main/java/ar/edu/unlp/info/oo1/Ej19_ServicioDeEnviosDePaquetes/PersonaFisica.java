package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public class PersonaFisica extends Cliente{

	private int dni;
	
	public PersonaFisica(String nombre, String direccion, int dni) {
		super(nombre, direccion);
		this.dni = dni;
	}

	@Override
	public double montoAPagar(LocalDate fechaInicio, LocalDate fechaFin) {
		double montoTotal = 0;
		double monto = 0;
		double descuento;
		for (Envio envio : this.envios) {
			if (envio.getFechaDespacho().isAfter(fechaInicio) && envio.getFechaDespacho().isBefore(fechaFin)) {				
				monto = envio.calcularEnvio();
				descuento = monto * 0.1;
				montoTotal += monto - descuento;
			}
		}
		return montoTotal;
	}

}
