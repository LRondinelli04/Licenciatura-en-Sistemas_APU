package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Mercado {
	
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	
	public Mercado() {
		this.vendedores = new ArrayList<Vendedor>();
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void addVendedor(Vendedor v) {
		this.vendedores.add(v);
	}
	
	public void addCliente(Cliente c) {
		this.clientes.add(c);
	}
	
	public List<Cliente> getClientes(){
		return this.clientes;
	}
	
	public List<Vendedor> getVendedores(){
		return this.vendedores;
	}
	
	public Pedido crearPedidoCliente(Cliente cliente, FormaPago formaPago, FormaEnvio formaEnvio, Producto producto, int cantSolicitada) {
		Vendedor v = this.buscarProducto(producto);
		
		if (v.equals(null)) {
			System.out.println("No hay vendedores que tengan el producto solicitado"); // si no existe el producto
		} else {
			if (v.getCantProducto(producto) < cantSolicitada) {
				System.out.println("No hay stock suficiente"); // si no hay stock suficiente del producto
			} else {
				Pedido p = new Pedido(producto, formaPago, formaEnvio, cantSolicitada);
				v.restarCantProducto(producto, cantSolicitada); // resto la cant solicitada 
				cliente.crearPedido(p); // cargo el pedido al cliente
				// System.out.println("Se cargo correctamente el pedido del producto solicitado");
				return p;
			}
		}
		return null;
	}
	
	public Vendedor buscarProducto(Producto producto) {
		for (Vendedor v : this.vendedores) {
			if (v.getProducto(producto)) {
				return v;
			}
		}
		return null;
	}
}
