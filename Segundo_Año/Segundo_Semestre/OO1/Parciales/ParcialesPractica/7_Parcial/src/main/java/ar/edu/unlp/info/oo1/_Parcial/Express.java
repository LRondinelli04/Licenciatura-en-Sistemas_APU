package ar.edu.unlp.info.oo1._Parcial;

public class Express implements FormaEntrega {

	@Override
	public double calcularPrecioEntrega(String localidadDestino, double precio) {
		double distancia = this.calcularDistancia(localidadDestino);
		double total = 10 * distancia;
		total += precio * 0.1;
		return total;
	}
	
	public double calcularDistancia(String localidadDestino) {
		double distancia = 10 ; // Map.distanciaBetween(String desde, String localidadDestino);
		return distancia;
	}

}
