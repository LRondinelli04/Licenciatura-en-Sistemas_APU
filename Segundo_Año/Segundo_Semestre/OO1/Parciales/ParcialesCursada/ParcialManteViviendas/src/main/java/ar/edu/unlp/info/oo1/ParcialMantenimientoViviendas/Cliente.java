package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre, direccion;
	private List<Contrato> contratos;
	
	public Cliente(String n, String d) {
		this.nombre = n;
		this.direccion = d;
		this.contratos = new ArrayList<Contrato>();
	}
	
	public void contratarUnica(Servicio s, LocalDate f) {
		this.contratos.add(new ContratoUnico(s, this, f));
	}
	
	public void contratarProlongado(Servicio s, LocalDate f, int cd) {
		this.contratos.add(new ContratoProlongado(s, this, f, cd));
	}
	
	public double montoPagar() {
		return this.contratos.stream()
			   .mapToDouble(c -> c.montoAPagar())
			   .sum();
	}
	
}
