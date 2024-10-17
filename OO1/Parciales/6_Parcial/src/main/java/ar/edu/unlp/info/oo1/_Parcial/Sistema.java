package ar.edu.unlp.info.oo1._Parcial;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Sistema {
	
	/*
	 * dar de alta una persona como nuevo cliente residencial
	 * 
	 * dar de alta una industria como nuevo cliente 
	 * 
	 * registrar una medicion de cosnumo de un cliente
	 * 
	 * actualizar el tarifario
	 * 
	 * calcular el monto a facturar a un cliente
	 * */
	
	private List<Cliente> clientes;
	private Tarifa tarifa;
	
	public Sistema(double precioUnidadCliente, double precioUnidadIndustria) {
		this.clientes = new ArrayList<Cliente>();
		this.tarifa = new Tarifa(precioUnidadCliente, precioUnidadIndustria);
	}
	
	public Residencial darAltaClienteResidencial(String nombre, String apellido, String domicilio) {
		Residencial cliente = new Residencial(nombre, apellido, domicilio);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Industria darAltaClienteIndustria(String nombre, String domicilio) {
		Industria cliente = new Industria(nombre, domicilio);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public void registrarConsumoCliente(Cliente cliente, int consumo, int mes, int anio) {
		cliente.registrarConsumoCliente(consumo, mes, anio);
	}
	
	public void actualizarTarifario(double precioCliente, double precioIndustria) {
		this.tarifa.actualizarTarifario(precioCliente, precioIndustria);
	}
	
	public double obtenerConsumoPorMesYAnio(Cliente cliente, int mes, int anio) {
		return cliente.obtenerConsumo(mes, anio).getConsumo();
	}
	
	public double calcularMontoCliente(Cliente cliente, int mes, int anio) {
		return cliente.calcularMontoAFacturar(mes, anio, this.tarifa);
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	public Tarifa getTarifa() {
		return this.tarifa;
	}

}
