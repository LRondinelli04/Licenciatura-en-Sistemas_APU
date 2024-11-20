package ar.edu.unlp.info.oo1._Parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class SistemaTest {
	
	Sistema sistema;
	Usuario u1, u2;
	Express express;
	Correo correo;
	RetiroDomicilio retiro;
	
	Publicacion pn1, pn2, pu1, pu2, s1, s2;
	
	
	@BeforeEach
	public void setUp() {
	   sistema = new Sistema();
	   express = new Express();
	   correo = new Correo();
	   retiro = new RetiroDomicilio();
		
		u1 = sistema.registrarUsuario("lucasrondinelli@gmail.com", "citybell");
		u2 = sistema.registrarUsuario("pedroponce@gmail.com", "citybell");
		
		// registro publicaciones a los usuarios
		
		// productos nuevos
		pn1 = sistema.publicarProductoNuevo(u1, "heladera", "heladera moderna", 10000, 2, express);
    	pn2 = sistema.publicarProductoNuevo(u2, "microondas", "microondas samsung", 1000, 10, correo);
	
    	// productos usados
    	pu1 = sistema.publicarProductoUsado(u1, "heladera2", "heladera moderna gastada", 10000);
    	pu2 = sistema.publicarProductoUsado(u2, "microondas2", "microondas gastado", 1000);
    	
    	// servicio
    	s1 = sistema.publicarServicio(u1, "pintor", "pintor de pileta", 1000);
    	s2 = sistema.publicarServicio(u2, "telefonica", "datos celular", 100);
    	
	}
	
    @Test
    public void testRegistrarUsuario() {
      assertEquals(u1, sistema.getUsuarios().get(0));
      assertNotEquals(u1, sistema.getUsuarios().get(1));
      
      assertEquals(u2, sistema.getUsuarios().get(1));
      assertNotEquals(u2, sistema.getUsuarios().get(0));
    }
    
    @Test
    public void testPublicarProductoNuevo() {
    	assertEquals("heladera", u1.getPublicaciones().get(0).getNombre());
    	assertEquals("heladera moderna", u1.getPublicaciones().get(0).getDescripcion());
    	assertEquals("microondas", u2.getPublicaciones().get(0).getNombre());
    
    }
    
    @Test
    public void testPublicarProductoUsado() {    
    	assertNotEquals("heladera moderna gastada", u1.getPublicaciones().get(0).getDescripcion()); // index 0 esta el producto nuevo
    	assertEquals("heladera moderna gastada", u1.getPublicaciones().get(1).getDescripcion());
    	assertEquals("microondas gastado", u2.getPublicaciones().get(1).getDescripcion());
    }
    
    @Test
    public void testPublicarServicio() {    
    	assertNotEquals("heladera moderna gastada", u1.getPublicaciones().get(2).getDescripcion()); // index 0 esta el producto nuevo
    	assertEquals("pintor de pileta", u1.getPublicaciones().get(2).getDescripcion());
    	assertEquals("telefonica", u2.getPublicaciones().get(2).getNombre());
    }
    
    @Test
    public void testPrecioFinalDePublicacion() {
    	// Servicios
    	assertEquals(1500, sistema.precioFinalDePublicacion(s1, "AMBA")); // precio = 1000 + 500 (AMBA)
    	assertEquals(1800, sistema.precioFinalDePublicacion(s1, "Capital"));
    	assertEquals(600, sistema.precioFinalDePublicacion(s2, "AMBA"));
    	assertEquals(900, sistema.precioFinalDePublicacion(s2, "Capital"));
    	
    	// Productos Nuevos
    	assertEquals(11100, sistema.precioFinalDePublicacion(pn1, "cityBell")); // precio = 10000 + envio express = 1100
    	assertEquals(1550, sistema.precioFinalDePublicacion(pn2, "citybell")); // precio = 1000 + envio correo = 550
    	
    	// Productos Usados
    	assertEquals(10000, sistema.precioFinalDePublicacion(pu1, "cityBell")); // precio final = 10000 + envio = 0 (retiro a domicilio)
    	assertEquals(1000, sistema.precioFinalDePublicacion(pu2, "citybell")); // precio final = 1000 + envio = 0 (retiro a domicilio)
    }
    
    @Test
    public void testRetornarPublicacionesMasCaras() {
    	List<Publicacion> publicaciones = sistema.retornarPublicacionesMasCaras("citybell");
    	for (int i = 0; i < publicaciones.size(); i++) {
    		System.out.println("TEST DE PUBLICACIONES MAS CARAS (10)" + publicaciones.get(i).getNombre());
    	}
    }
    
    @Test
    public void testObtenerPublicacionesOrdenadasPorPrecio() {
    	List<Publicacion> publicaciones = sistema.obtenerPublicacionesOrdenadasPorPrecio("citybell");
    	for (int i = 0; i < publicaciones.size(); i++) {
    		System.out.println("TEST DE PUBLICACIONES ORDENADAS " + publicaciones.get(i).getNombre());
    	}
    }
}
