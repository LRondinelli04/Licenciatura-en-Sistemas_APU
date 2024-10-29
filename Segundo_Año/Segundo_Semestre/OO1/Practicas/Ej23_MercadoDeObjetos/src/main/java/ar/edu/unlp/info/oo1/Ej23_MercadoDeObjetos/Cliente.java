package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre, direccion;
	private List<Pedido> pedidos; // productos pedidos
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public Pedido crearPedido(Pedido pedido) {
		this.pedidos.add(pedido);
		return pedido;
	}
	
	
	public int cantPedidoCategoria(String categoria) {
		int cant = 0;
		
		for (Pedido p : this.pedidos) {
			if (p.getProducto().getCategoria().equals(categoria)) {
				cant++;
			}
		}
		return cant;
	}
}
