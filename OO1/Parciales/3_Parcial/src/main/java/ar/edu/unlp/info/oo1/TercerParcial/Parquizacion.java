package ar.edu.unlp.info.oo1.TercerParcial;

import java.util.ArrayList;
import java.util.List;

public class Parquizacion extends Servicio {

	private List<Maquina> maquinas;
	
	public Parquizacion(double precioPorHora, int horas) {
		super(precioPorHora, horas);
		this.maquinas = new ArrayList<Maquina>();
	}



	public void addMaquina(Maquina maquina) {
		this.maquinas.add(maquina);
	}

	@Override
	public double calcularMonto() {
		// Calculo el monto de horas x precioPorHora
		double monto = super.precioPorHora * super.horas;
		double costoMaquina = 0.0;
		// Calculo el costo de cada maquina
		for (Maquina maquina : this.maquinas) {
			costoMaquina += maquina.getCostMantenimiento();
		}
		// Multiplico el costo de todas las maquinas por la cantidad que tengo
		costoMaquina = costoMaquina * this.maquinas.size();
		
		// Lo sumo al monto final
		monto += costoMaquina;
		
		return monto;
		
	}
	
	
	
	
}
