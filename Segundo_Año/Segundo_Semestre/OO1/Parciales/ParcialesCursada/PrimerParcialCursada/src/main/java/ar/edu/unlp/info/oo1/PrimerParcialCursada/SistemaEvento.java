package ar.edu.unlp.info.oo1.PrimerParcialCursada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaEvento {

	private List<Usuario> usuarios;
	private List<Evento> eventos;
	
	public SistemaEvento() {
		this.usuarios = new ArrayList<Usuario>();
		this.eventos = new ArrayList<Evento>();
	}
	
	public double precioAsistenciaEvento(Evento evento, LocalDate fecha) {
		double monto = 0;
		for (Evento e : this.eventos) {
			if (e.equals(evento) && e.fecha.equals(fecha)) {
				monto = e.precioAsistencia();
			}
		}
		return monto;
	}

	
}
