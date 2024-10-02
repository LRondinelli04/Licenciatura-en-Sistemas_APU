package ar.edu.unlp.info.oo1.CuartoParcial;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Distribuidora {

	private List<Cliente> clientes;
	private List<Producto> productos;
	
	public Distribuidora() {
		this.clientes = new ArrayList<Cliente>();
		this.productos = new ArrayList<Producto>();
	}
	
	public Cliente registrarCliente(Cliente cliente) {
		this.clientes.add(cliente);
		return cliente;
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	public Producto addProducto(Producto producto) {
		this.productos.add(producto);
		return producto;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public int cantSolicitadaProducto(Producto producto) {
		int total = 0;
		for (Cliente cliente : this.clientes) {
			for (Pedido pedido : cliente.getPedidos()) {
				for (Item item : pedido.getItems()) {
					if (item.getProducto().equals(producto)) {
						total += item.getCantNecesaria();
					}
				}
			}
		}
		return total;
	}
	
	public List<Cliente> topClientes() {
        LocalDate fechaInicio = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()-30);
        LocalDate fechaFin = LocalDate.now();
        
        // Crear un mapa para almacenar el costo total de cada cliente
        Map<Cliente, Double> clienteCostoMap = new HashMap<>();

        for (Cliente cliente : clientes) {
            double totalCosto = cliente.costoTotal(fechaInicio, fechaFin);
            clienteCostoMap.put(cliente, totalCosto);
        }

        // Ordenar los clientes por costo total, de mayor a menor
        List<Cliente> topClientes = clienteCostoMap.entrySet().stream()
                .sorted(Map.Entry.<Cliente, Double>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topClientes;
    }

}
