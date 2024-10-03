package ar.edu.unlp.info.oo1.TercerParcial;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoViviendas {

	private List<Cliente> clientes;
	
	public MantenimientoViviendas() {
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public int cantServiciosMayor(int valor) {
		int cant = 0;
		// Recorro todos los clientes
		for (Cliente cliente : this.clientes) {
			// Recorro todos los servicios de cada cliente
			for (Servicio servicio : cliente.getServicios()) {
				// System.out.println("Servicio: " + servicio.calcularMonto());
				// Pregunto si el valor ingresado es mayor al valor de los servicios de cada cliente
				if (valor < servicio.calcularMonto()) {
					cant++;
				}
			}
		}
		
		return cant;
	}
	
}
