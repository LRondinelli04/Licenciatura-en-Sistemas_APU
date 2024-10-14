package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre, email;
	private LocalDate fecha;
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.fecha = LocalDate.now();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void registrarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
	
	public double calcularCostoPedido(LocalDate fechaLimite) {
		double costo = 0;
		for (Pedido pedido : this.pedidos) {
			if (pedido.getFecha().isAfter(fechaLimite)) {
				List<Item> items = pedido.getItem();
				for (Item item : items) {
					costo += item.calcularCosto();
				}
			}
		}
		return costo;
	}
	
}
