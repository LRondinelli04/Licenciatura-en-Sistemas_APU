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

	/*
	 * 
	 * registrar un cliente (retornar)
	 * 
	 * registrar un producto nacional (retornar)
	 * 
	 * registrar un producto importado (retornar)
	 * 
	 * registrar un pedido para un cliente
	 * 
	 * agregar un itme para un pedido
	 * 
	 * calcular la cantidad total solicitada de un producto
	 * 
	 * calcular el costo total de los pedidos de un cliente en un periodo
	 * 
	 * retornar los clientes del top 5 de los ulitmos 30 dias
	 *
	 * 
	 */
	
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
	
	/*
	public Pedido registrarPedidoParaCliente(Cliente cliente) {
		Pedido pedido = new Pedido(cliente);
		cliente.registrarPedido(pedido);
		return pedido;
	}
	
	public void agregarItemAPedido(Pedido pedido, Producto producto, int cantNecesaria) {
		for (Cliente cliente : this.clientes) {
			List<Pedido> pedidos = cliente.getPedidos();
			for (Pedido p : pedidos) {
				if (pedido.equals(p)) {
					Item item = new Item(producto, cantNecesaria);
					p.registrarItem(item);
				}
			}
		}
	}
	
	public int cantTotalProductoSolicitado(Producto producto) {
		int total = 0;
		for (Cliente cliente : this.clientes) {
			List<Pedido> pedidos = cliente.getPedidos();
			for (Pedido pedido : pedidos) {
				List<Item> items = pedido.getItem();
				for (Item item : items) {
					if (producto.equals(item.getProducto())) {
						total += item.getCant();
					}
				}
			}
		}
		return total;
	}
	
	public double costoTotalDePedidos(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin) {
		double costoTotal = 0.0;
		
		List<Pedido> pedidos = cliente.getPedidos();
		for (Pedido pedido : pedidos) {
			if (pedido.getFecha().isAfter(fechaInicio) && pedido.getFecha().isBefore(fechaFin)) {
				List<Item> items = pedido.getItem();
				for (Item item : items) {
					costoTotal += item.calcularCosto(); // retorno el costo total de cada item solicitado
				}
			}
		}
		return costoTotal;
	}
	
	public List<Cliente> topClientes() {
		List<Cliente> topClientes = this.clientes;
		LocalDate fechaLimite = LocalDate.now().minusDays(30); // limito a 30 dias
		
		return topClientes.stream()
		.sorted((c1, c2) -> Double.compare(c2.calcularCostoPedido(fechaLimite), c1.calcularCostoPedido(fechaLimite))) // Ordena de mayor a menor
		.limit(5) // limito los primeros 5
		.collect(Collectors.toList());
	}
*/
}
