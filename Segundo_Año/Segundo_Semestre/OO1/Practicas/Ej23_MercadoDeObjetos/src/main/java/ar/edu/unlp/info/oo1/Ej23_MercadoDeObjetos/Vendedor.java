package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {

	private String nombre, direccion;
	private List<Producto> productos;
	
	public Vendedor(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}
	
	public void addProducto(Producto p) {
		this.productos.add(p);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCantProducto(Producto producto) {
		int cant = 0;
		for (Producto p : this.productos) {
			if (p.equals(producto)) {
				cant = p.getCantDisponible();
			}
		}
		return cant;
	}
	
	public boolean getProducto(Producto producto) {
		for (Producto p : this.productos) {
			if (p.equals(producto)) {
				return true;
			}
		}
		return false;
	}
	
	public void restarCantProducto(Producto producto, int cantSolicitada) {
		for (Producto p : this.productos) {
			if (p.equals(producto)) {
				p.restarCantSolicitada(cantSolicitada);
			}
		}
	}
	
}
