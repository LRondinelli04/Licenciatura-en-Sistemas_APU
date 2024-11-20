package ar.edu.unlp.info.oo1.ParcialDistribuidora;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente {

	private String nombre, email;
	private LocalDate fechaAlta;
	private List<Pedido> pedidos;
	
	public Cliente (String n, String e) {
		this.nombre = n;
		this.email = e;
		this.fechaAlta = LocalDate.now();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public Pedido registrarPedido() {
		Pedido p = new Pedido();
		this.pedidos.add(p);
		return p;
	}
	
	public int cantSolicitadaProducto(Producto p) {
		return this.pedidos.stream()
				.mapToInt(pedido -> pedido.cantSolicitadaProducto(p))
				.sum();
	}
	
	public double costoTotalPedidos(LocalDate fi, LocalDate ff) {
		return this.pedidos.stream()
				.filter(pedido -> pedido.pedidoEnFecha(fi, ff))
				.mapToDouble(pedido -> pedido.costoTotalPedidos())
				.sum();
	}
}
