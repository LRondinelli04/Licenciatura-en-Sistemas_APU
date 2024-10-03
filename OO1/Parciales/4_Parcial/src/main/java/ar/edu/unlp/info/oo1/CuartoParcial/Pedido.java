package ar.edu.unlp.info.oo1.CuartoParcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private LocalDate fechaActual;
	private List<Item> items;
	
	public Pedido() {
		this.fechaActual = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public List<Item> getItems(){
		return this.items;
	}
	
	public double costoTotal() {
		double total = 0.0;
		for (Item item : this.items) {
			total += item.getCosto();
		}
		
		return total;
	}
	
	public LocalDate getFechaActual() {
		return this.fechaActual;
	}
	
	
}
