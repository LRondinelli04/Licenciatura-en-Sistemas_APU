package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.main.java.ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

public class EntregaCorreo implements FormaEntrega {

	@Override
	public double costoEnvio(String l, String lv, double precio) {
		return 500 + (precio * 0.05);
	}

}
