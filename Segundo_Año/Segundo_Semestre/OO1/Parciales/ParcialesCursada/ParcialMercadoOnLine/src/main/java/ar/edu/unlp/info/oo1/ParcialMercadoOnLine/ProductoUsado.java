package ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

public class ProductoUsado extends Producto {

	public ProductoUsado(Usuario u, String n, String d, double p) {
		super(u, n, d, p, 1, new RetiroDomicilio());
	}

	@Override
	public double precioFinalPublicacion(String localidad) {
		return this.precio + this.formaEntrega.costoEnvio(localidad, this.usuario.getLocalidad(), this.precio);
	}

}
