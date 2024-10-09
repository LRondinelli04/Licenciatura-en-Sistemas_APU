package ar.edu.unlp.info.oo1._Parcial;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre, direccion;
	private List<Contrato> contratos;

	
	/*
	 * Calcular el monto a pagar por un cliente:
	 * 
	 *		se analizan todos los servicios contratados por este cliente
	 * 
	 * */
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.contratos = new ArrayList<Contrato>();
	}
	
	// Registrar un contrato 
	public void registrarContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}
	
	// Calcular el monto a pagar por un cliente
	public double calcularMontoCliente() {
		double monto = 0.0;
		for (Contrato contrato : this.contratos) {
			monto += contrato.calcularMonto();
		}
		return monto;
	}

	
	
}
