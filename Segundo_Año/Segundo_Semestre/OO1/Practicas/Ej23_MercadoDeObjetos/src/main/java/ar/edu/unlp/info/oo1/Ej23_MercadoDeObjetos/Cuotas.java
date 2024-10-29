package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

public class Cuotas implements FormaPago {

	@Override
	public double calcularCosto(double precio) {
		double incremento = precio * 0.2;
		return precio + incremento;
	}

}
