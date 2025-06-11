package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.test.java.ar.edu.unlp.info.oo1.ParcialMercadoOnLine;

import Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialMercadoOnLine.src.main.java.ar.edu.unlp.info.oo1.ParcialMercadoOnline.Mercado
/*
 * Mercado::precioFinalPublicacion()
 * 	- No hay publicaciones registradas en el mercado
 * 	- Hay al menos una publicación registrada
 * 
 * ProductoNuevo::precioFinalPublicacion() y ProductoUsado::precioFinalPublicacion()
 * 	* EntregaExpress::costoEnvio()
 * 		- La distancia entre el comprador y el vendedor es corta (5 km)
 * 		- La distancia entre el comprador y el vendedor es larga (1000 km)
 * 
 * Servicio::precioFinalPublicacion()
 * 	- La localidad ingresada es AMBA (costo adicional)
 * 	- La localidad ingresada no es AMBA (sin costo adicional)
 * 	- La antigüedad del usuario es mayor a 10 años (descuento aplicado)
 * 	- La antigüedad del usuario es menor o igual a 10 años (sin descuento)
 */

import java.util.List;
import org.junit.jupiter.api.Test;

public class ParcialMercadoOnLineTest {

	@Test
	public void testPublicacionesMasCaras() {
		// Inicializar el sistema
		Mercado m = new Mercado();
		// registrar un usuario
		Usuario u = m.registrarUsuario("email", "La Plata");
		// registrar publicaciones al usuario (y al sistema)
		Publicacion pn = m.registrarProductoNuevo(u, "prodNuevo", "des", 100, 10, new EntregaExpress());
		Publicacion pu = m.registrarProductoUsado(u, "prodUsado", "des", 10);
		Publicacion se = m.registrarServicio(u, "servicio", "des", 1000);
		// retornar las 10 publicaciones mas caras para una localidad
		List<Publicacion> publicaciones = m.publicacionesMasCaras("La Plata");
		// Aquí puedes agregar asserts para verificar el resultado
	}
}
