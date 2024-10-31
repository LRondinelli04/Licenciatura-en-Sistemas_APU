package ar.edu.unlp.info.oo1._Parcial;

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
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
	
	public Pedido registrarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
		return pedido;
	}
	
	public int cantProductoSolicitado(Producto producto) {
		int total = 0;
		for (Pedido pedido : this.pedidos) {
			return pedido.cantProductoSolicitado(producto);
		}
		return total;
	}
	
	public double costoTotalPedidosEnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		double total = 0;
		for (Pedido pedido : this.pedidos) {
			total = pedido.calcularCostoPedido(fechaInicio, fechaFin);
		}
		return total;
	}

}
