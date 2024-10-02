package ar.edu.unlp.info.oo1.CuartoParcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre, email;
	private LocalDate fechaAlta;
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.fechaAlta = LocalDate.now();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public void agregarPedido (Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
	
	public double costoTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		double total = 0.0;
		for (Pedido pedido : this.pedidos) {
			if (pedido.getFechaActual().isAfter(fechaInicio) && pedido.getFechaActual().isBefore(fechaFin)) {
				total += pedido.costoTotal();
			}
		}
		return total;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
