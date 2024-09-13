package ar.edu.unlp.info.oo1.Ejercicio_Presupuesto;

import java.sql.Date;
import java.util.List;

public class Presupuesto {

	private Date fecha;
	private String cliente;
	private List<Item> items;
	private int indice;
	
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	

	public Presupuesto(String detalle, int cantidad, double costoUnitario, String cliente) {
		super();
		this.cliente = cliente;
	}

	public Presupuesto(String detalle) {
		// TODO Auto-generated constructor stub
		this.cliente = detalle;
	}

	public void agregarItem(Item item) {
		this.items.add(item);
		this.indice++;
	}
	
	public double calcularTotal() {
		double total = 0.0;
		// recorrer la lista
		for (int i = 0; i < indice; i++) {
			//total = 
		}
		// calcular costo unitario * cantidad (ITEMS)
		
		return total;
	}
	
	
}
