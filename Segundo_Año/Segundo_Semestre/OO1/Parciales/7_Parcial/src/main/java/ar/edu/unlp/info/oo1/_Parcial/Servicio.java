package ar.edu.unlp.info.oo1._Parcial;

public class Servicio extends Publicacion {

	public Servicio(Usuario usuario, String nombre, String descripcion, double precio) {
		super(usuario, nombre, descripcion, precio);
	}

	@Override
	public double calcularPrecioFinal(String localidad) {
		double total = this.precio;
		if (localidad == "AMBA") {
			total += 500;
		} else {
			total += 800;
		}
		
		if (usuario.calcularAntiguedad() > 10) {
			total -= total * 0.08;
		}
		
		return total;
	}

}
