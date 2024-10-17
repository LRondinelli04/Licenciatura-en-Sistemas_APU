package ar.edu.unlp.info.oo1._Parcial;

public class Medicion {

	private int consumo, mes, anio;
	
	public Medicion(int consumo, int mes, int anio) {
		this.consumo = consumo;
		this.mes = mes;
		this.anio = anio;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAnio() {
		return this.anio;
	}
	
	public int getConsumo() {
		return this.consumo;
	}
	
}
