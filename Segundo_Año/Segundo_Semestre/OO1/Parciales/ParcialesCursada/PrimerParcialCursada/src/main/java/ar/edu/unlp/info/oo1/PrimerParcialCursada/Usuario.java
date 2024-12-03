package ar.edu.unlp.info.oo1.ParcialCursada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private List<Entrada> entradas;
	
	public Usuario(String n) {
		this.nombre = n;
		this.entradas = new ArrayList<Entrada>();
	}
	
	
	public Entrada comprarEntrada(Evento evento, boolean seguro) {
		Entrada e = new Entrada(this, evento, seguro);
		this.entradas.add(e);
		return e;
	}
	
	public double montoTotalEntradas(LocalDate fi, LocalDate ff) {
		return this.entradas.stream()
				.filter(e -> e.getFechaCompra().isAfter(fi) && e.getFechaCompra().isBefore(ff)) // filtro la lista con las entradas entre las fechas
				.mapToDouble(e -> e.getEvento().precioAsistencia(e.getFechaCompra()) + e.getPrecioSeguro()) // sumo el precio de las entradas a los eventos (precio de asistencia + el precio del seguro // puede ser 0 o 500)
				.sum();
	}
	
	public Entrada getProxEvento() {
		return this.entradas.stream()
				.filter(e -> e.getEvento().fechaEvento.isAfter(LocalDate.now())) // filtro las fecha posteriores a la fecha actual
				.sorted((e1, e2) -> e1.getEvento().fechaEvento.compareTo(e2.getEvento().fechaEvento)) // ordeno la lista de menor a mayor (por fecha del evento)
				.findFirst() // retorno el primer evento
				.orElse(null);
	}
}
