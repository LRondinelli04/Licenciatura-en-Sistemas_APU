package ar.edu.unlp.info.oo1._Parcial;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

	protected String nombre, domicilio;
	protected List<Medicion> consumo;
	
	public Cliente(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumo = new ArrayList<Medicion>();
	}
	
	public List<Medicion> getConsumo() {
		return this.consumo;
	}
	
	public void registrarConsumoCliente(int consumo, int mes, int anio) {
		Medicion m = new Medicion(consumo, mes, anio);
		this.consumo.add(m);
	}
	
	public Medicion obtenerConsumo(int mes, int anio) {
		Medicion consumo = null;
		for (Medicion m : this.consumo) {
			if (m.getAnio() == anio && m.getMes() == mes) {
				consumo = m;;
			}
		}
		return consumo;
	}
	
	public abstract double calcularMontoAFacturar(int mes, int anio, Tarifa tarifa);
	
}
