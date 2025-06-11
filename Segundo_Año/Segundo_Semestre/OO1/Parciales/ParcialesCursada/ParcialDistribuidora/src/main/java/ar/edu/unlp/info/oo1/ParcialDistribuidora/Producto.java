package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialDistribuidora.src.main.java.ar.edu.unlp.info.oo1.ParcialDistribuidora;

public abstract class Producto {
	
	protected String nombre, descripcion;
	protected double costoUnitario;
	
	public Producto(String n, double cu, String d) {
		this.nombre = n;
		this.costoUnitario = cu;
		this.descripcion = d;
	}
	
	public abstract double calcImpuesto(int cantSolicitada);
	
}
