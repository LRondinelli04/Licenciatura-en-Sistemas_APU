package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Plataforma {

	private List<Cliente> clientes;
	private List<Servicio> servicios;
	
	public Plataforma() {
		this.clientes = new ArrayList<Cliente>();
		this.servicios = new ArrayList<Servicio>();
	}
	
	public Cliente registrarCliente(String n, String d) {
		Cliente c = new Cliente(n, d);
		this.clientes.add(c);
		return c;
	}
	
	public Servicio registrarServicio(Servicio s) {
		this.servicios.add(s);
		return s;
	}
	
	public Servicio registrarServLimpieza(double ph, int ch, double t) {
		return this.registrarServicio(new Limpieza(ph, ch, t));
	}
	
	public Servicio registrarServParquizacion(double ph, int ch, int cm, double c) {
		return this.registrarServicio(new Parquizacion(ph, ch, cm, c));
	}
	
	public int serviciosMayorValor(double valor) {
		return (int) this.servicios.stream()
				     .filter(servicio -> servicio.montoServicio() > valor)
				     .count();
	}

}
