package ar.edu.unlp.info.oo1.ParcialDistribuidora;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private LocalDate fechaPedido;
	private List<Item> items;
	
	public Pedido() {
		this.fechaPedido = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	public LocalDate getFechaPedido() {
		return this.fechaPedido;
	}
	
	public void agregarItem(Producto p, int cn) {
		Item i = new Item(p, cn);
		this.items.add(i);
	}
	
	public int cantSolicitadaProducto(Producto p) {
		return this.items.stream()
				.filter(item -> item.getProducto().equals(p))
				.mapToInt(item -> item.getCantidad())
				.sum();
	}
	
	public boolean pedidoEnFecha(LocalDate fi, LocalDate ff) {
		if (!this.fechaPedido.isBefore(fi) && !this.fechaPedido.isAfter(ff)) {
			return true;
		} else {
			return false;
		}
	}
	
	public double costoTotalPedidos() {
		return this.items.stream()
				.mapToDouble(item -> item.costoTotalItem())
				.sum();
	}
}
