package ar.edu.unlp.info.oo1._Parcial;

public class ProductoUsado extends Publicacion {

	private int cantDisponible;
	
	public ProductoUsado(Usuario usuario, String nombre, String descripcion, double precio) {
		super(usuario, nombre, descripcion, precio);
		this.cantDisponible = 1;
	}

	@Override
	public double calcularPrecioFinal(String localidad) {
		return this.precio; // no tiene costo de envio porque es a retirar en el domicilio
	}

}
