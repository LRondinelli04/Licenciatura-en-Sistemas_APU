package ar.edu.unlp.info.oo1._Parcial;

public class Correo implements FormaEntrega {

	@Override
	public double calcularPrecioEntrega(String localidadDestino, double precio) {
		return 500 + (precio * 0.05);
	}

}
