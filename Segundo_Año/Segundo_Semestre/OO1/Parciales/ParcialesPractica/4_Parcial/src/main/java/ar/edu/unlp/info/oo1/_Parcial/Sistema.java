package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Sistema {
	
	private List<Cliente> clientes;
	private List<Producto> productos;
	
	public Sistema() {
		this.clientes = new ArrayList<Cliente>();
		this.productos = new ArrayList<Producto>();
	}
	
	public Cliente registrarCliente(String nombre, String email) {
		Cliente c = new Cliente(nombre, email);
		this.clientes.add(c);
		return c;
	}
	
	public Producto registrarProducto(Producto producto) {
		this.productos.add(producto);
		return producto;
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	
	
	public int cantTotalSolicitadaProducto(Producto producto) {
		int total = 0;
		for (Cliente cliente : this.clientes) {
			return cliente.cantProductoSolicitado(producto);
		}
		return total;
	}
	
	public List<Cliente> topClientes() {
		LocalDate fechaLimite = LocalDate.now().minusDays(30);
		
		return  this.clientes.stream()
				.sorted((c1, c2) -> Double.compare(c2.costoTotalPedidosEnPeriodo(fechaLimite, LocalDate.now()), c1.costoTotalPedidosEnPeriodo(fechaLimite, LocalDate.now())))
				.limit(5)
				.collect(Collectors.toList());
	}
}
