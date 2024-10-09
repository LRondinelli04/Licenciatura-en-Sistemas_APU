package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Empresa {

	/*
	 * registrar un cliente (al sistema)
	 * 
	 * registrar servicio de limpieza (al sistema)
	 * 
	 * registrar servicio de parquizacion (al sistema)
	 * 
	 * contratar por unica vez (que se encuentre en el sistema)
	 * 
	 * contratar de forma prolongada (que se encuentre en el sistema)
	 * 
	 * obtener el monto a pagar por un cliente (que se encuentre en el sistema)
	 * 
	 * obtener la cantidad de servicios con monto mayor a un valor ingresado por teclado
	 * 
	 * */
	
	private List<Cliente> clientes;
	private List<Servicio> servicios;
	
	public Empresa() {
		this.clientes = new ArrayList<Cliente>();
		this.servicios = new ArrayList<Servicio>();
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
	
	// Registrar un cliente al sistema y retornarlo
	public Cliente registrarCliente(Cliente cliente) {
		this.clientes.add(cliente);
		return cliente;
	}
	
	// Registrar un servicio de limpieza al sistema y retornarlo
	public Limpieza registrarServicioLimpieza(Limpieza servicio) {
		this.servicios.add(servicio);
		return servicio;
	}
	
	// Registrar un servicio de Parquizacion al sistema y retornarlo
	public Parquizacion registrarServicioParquizacion(Parquizacion servicio) {
		this.servicios.add(servicio);
		return servicio;
	}
	
	// contratar por unica vez (que se encuentre en el sistema)
	public void contratarUnicaVez(Cliente cliente, Servicio servicio, LocalDate fecha) {
		ContratoUnico contrato = new ContratoUnico(cliente, servicio, fecha);
		cliente.registrarContrato(contrato);
	}
	
	// contratar de forma prolongada (que se encuentre en el sistema)
	public void contratarProlongada(Cliente cliente, Servicio servicio, LocalDate fechaInicial, int cantDias) {
		ContratoProlongado contrato = new ContratoProlongado(cliente, servicio, fechaInicial, cantDias);
		cliente.registrarContrato(contrato);
	}
	
	// obtener el monto a pagar por un cliente (que se encuentre en el sistema)
	public double montoAPagar(Cliente cliente) {
		double montoTotal = 0.0;
		for (Cliente c : this.clientes) {
			if (c.equals(cliente)) {
				montoTotal = c.calcularMontoCliente();
			}
		}
		return montoTotal;
	}
	
	// obtener la cantidad de servicios con monto mayor a un valor ingresado por teclado
	public int cantServiciosMayor(double valor) {
		int cant = 0;
		double costoServicio = 0.0;
		for (Servicio servicio : this.servicios) {
			costoServicio = servicio.montoAbonar();
			if (valor > costoServicio) {
				cant++;
			}
			costoServicio = 0.0;
		}
		return cant;
	}
	
}
