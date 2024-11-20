package ar.edu.unlp.info.oo1.PrimerParcialCursada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presencial extends Evento {

	private List<Sede> sedes;
	
	public Presencial(String n, LocalDate f, String tp, double pi, double pr) {
		super(n, f, tp, pi, pr);
		this.sedes = new ArrayList<Sede>();
	}

	public void addSede(Sede s) {
		this.sedes.add(s);
	}
	
	@Override
	public double precioAsistencia() {
		double monto = this.precioI + this.precioR;
		double precioSede = this.sedes.stream()
							.mapToDouble(sede -> sede.precioSede())
							.sum();
		monto += precioSede;
		monto = this.fechaConsulta(monto);
		return monto;
	}

}
