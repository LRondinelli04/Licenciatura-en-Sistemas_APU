package ar.edu.unlp.info.oo1._Parcial;

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
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public int cantProductoSolicitado(Producto producto) {
		int total = 0;
		for (Item item : this.items) {
			if (item.getProducto().equals(producto)) {
				return item.getCantNecesaria();
			}
		}
		return total;
	}
	
	public double calcularCostoPedido(LocalDate fechaInicio, LocalDate fechaFin) {
		double total = 0;
		double costoItem = 0;
		double impuesto = 0;
		
		for (Item item : this.items) {
			costoItem = item.getProducto().costoUnitario * item.getCantNecesaria();
			impuesto = item.getProducto().calcularImpuesto(item.getCantNecesaria(), item.getProducto().costoUnitario);
			total += costoItem + impuesto;
		}
		
		return total;
	}
	
	
	
	
	
}
