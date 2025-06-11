package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.main.java.ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

public class ProductoNuevo extends Producto {

	public ProductoNuevo(Usuario u, String n, String d, double p, int cd, FormaEntrega fe) {
		super(u, n, d, p, cd, fe);
	}

	@Override
	public double precioFinalPublicacion(String localidad) {
		return this.precio + this.formaEntrega.costoEnvio(localidad, this.usuario.getLocalidad(), this.precio);
	}


}
