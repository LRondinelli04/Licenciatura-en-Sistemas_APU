package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.main.java.ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

public abstract class Producto extends Publicacion {

	protected int cantDisponible;
	protected FormaEntrega formaEntrega;

	public Producto(Usuario u, String n, String d, double p, int cd, FormaEntrega fe) {
		super(u, n, d, p);
		this.cantDisponible = cd;
		this.formaEntrega = fe;
	}
	
}
