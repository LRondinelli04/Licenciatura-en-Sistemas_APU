package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.main.java.ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

import java.util.Map;

public class EntregaExpress implements FormaEntrega {

	@Override
	public double costoEnvio(String l, String lv, double precio) {
		double distancia = Map.distanceBetween(lv, l);
		double monto = 10 * distancia;
		monto += precio * 0.1;
		return monto;
	}

}
