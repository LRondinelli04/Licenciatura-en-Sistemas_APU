package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Empresa {

	private List<Cliente> clientes;
	
	public Empresa() {
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	// agregar un envio para un cliente
	public void agregarEnvioACliente(Cliente cliente, Envio envio) {
		cliente.agregarEnvio(envio);
	}
	
	// monto a pagar por los envios realizados dentro de un periodo
	public double montoAPagar(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin) {
		double montoTotal = 0;
		for (Cliente c : this.clientes) {
			if (c.equals(cliente)) {
				montoTotal = cliente.montoAPagar(fechaInicio, fechaFin);
			}
		}
		return montoTotal;
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}

}
