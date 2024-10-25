package ar.edu.unlp.info.oo1._Parcial;

public class ProductoNuevo extends Publicacion {

	private int cantDisponible;
	private FormaEntrega formaEntrega;
	
	public ProductoNuevo(Usuario usuario, String nombre, String descripcion, double precio, int cantDisponible, FormaEntrega formaEntrega) {
		super(usuario, nombre, descripcion, precio);
		this.cantDisponible = cantDisponible;
		this.formaEntrega = formaEntrega;
	}

	@Override
	public double calcularPrecioFinal(String localidad) {
		double total = this.precio;
		total += this.formaEntrega.calcularPrecioEntrega(localidad, this.precio);
		return total;
	}
}
