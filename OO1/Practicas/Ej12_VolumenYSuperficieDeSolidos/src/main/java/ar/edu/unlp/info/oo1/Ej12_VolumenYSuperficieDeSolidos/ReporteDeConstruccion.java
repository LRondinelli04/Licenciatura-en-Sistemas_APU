package ar.edu.unlp.info.oo1.Ej12_VolumenYSuperficieDeSolidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}
	
	
	// Crear un metodo para agregar un pieza a la lista
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	
	public double volumenDeMaterial(String material) {
		// retornar el volumen de todas las piezas que coincidan con el material
		double total = 0.0;
		for (Pieza pieza : this.piezas) {
			if (pieza.getMaterial().equals(material)) {
				total += pieza.getVolumen();
			}
		}
		return total;
	}
	
	public double superficieDeColor(String color) {
		// retornar la suma de volumenes de las piezas que coincidan con el material
		double total = 0.0;
		for (Pieza pieza : this.piezas) {
			if (pieza.getColor().equals(color)) {
				total += pieza.getSuperficie();
			}
		}
		return total;
	}
	
	
}
