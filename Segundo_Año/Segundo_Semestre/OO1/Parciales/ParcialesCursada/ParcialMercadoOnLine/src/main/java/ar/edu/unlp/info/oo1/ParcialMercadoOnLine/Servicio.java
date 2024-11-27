package ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

import java.time.LocalDate;
import java.time.Period;

public class Servicio extends Publicacion {

	public Servicio(Usuario u, String n, String d, double p) {
		super(u, n, d, p);
	}

	@Override
	public double precioFinalPublicacion(String localidad) {
		double monto = this.precio;
		if (localidad.equals("AMBA")) {
			monto += 500;
		} else {
			monto += 800;
		}
		if (this.antiguedadUsuario()) {
			monto -= monto * 0.08;
		}
		return monto;
	}
	
	public boolean antiguedadUsuario() {
		int anios = Period.between(this.usuario.getFecha(), LocalDate.now()).getYears();
		if (anios > 10) {
			return true;
		} else {
			return false;
		}
	}

}
