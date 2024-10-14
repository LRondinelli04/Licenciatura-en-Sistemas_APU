package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Cliente cliente;
	private LocalDate fechaPedido;
	private List<Item> items;
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.fechaPedido = LocalDate.of(2024, 9, 20);
		this.items = new ArrayList<Item>();
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void registrarItem(Item item) {
		this.items.add(item);
	}
	
	public List<Item> getItem(){
		return this.items;
	}
	
	public LocalDate getFecha() {
		return this.fechaPedido;
	}
}
