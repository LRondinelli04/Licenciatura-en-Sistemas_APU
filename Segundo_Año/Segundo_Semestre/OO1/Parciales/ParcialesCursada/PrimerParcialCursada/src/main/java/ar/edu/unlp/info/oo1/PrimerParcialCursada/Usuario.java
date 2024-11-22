package ar.edu.unlp.info.oo1.PrimerParcialCursada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private String nombre;
	private List<Entrada> entradas;
	
	public Usuario(String n) {
		this.nombre = n;
		this.entradas = new ArrayList<Entrada>();
	}
	
	public Entrada comprarEntrada(Evento e, boolean seguro) {
		Entrada entrada = new Entrada(e, seguro);
		this.entradas.add(entrada);
		return entrada;
	}
	
	public double montoRecuprar(Entrada entrada) {
		double monto = 0;
		for (Entrada e : this.entradas) {
			if (e.equals(entrada)) {
				monto = e.calcularRembolso();
			}
		}
		return monto;
	}
	
	public double montoTotalEntradas(LocalDate fi, LocalDate ff) {
		return this.entradas.stream()
				.filter(entrada -> entrada.entradaEnFecha(fi, ff))
				.mapToDouble(entrada -> entrada.calcularPrecioCompra())
				.sum();
	}
	
	public Entrada siguienteEvento() {
		return this.entradas.stream()
			.filter(e -> e.getFechaEvento().isAfter(LocalDate.now()) // Filtrar solamente eventos futuros
			.sorted((e1, e2) -> e1.getFechaEveneto().compareTo(e2.getFechaEvento()) // Ordenar por fecha
			.findFirst() // Obtener el primer evento 
			.orElse(null); // Retornar null si no hay eventos
	}
}
