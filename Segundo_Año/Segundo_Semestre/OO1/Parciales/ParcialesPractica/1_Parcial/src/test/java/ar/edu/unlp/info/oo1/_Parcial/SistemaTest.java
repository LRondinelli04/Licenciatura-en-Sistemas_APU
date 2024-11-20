package ar.edu.unlp.info.oo1._Parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class SistemaTest {
	
	Sistema sistema;
	Contribuyente contribuyente, c1, c2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();

		contribuyente = sistema.darAltaContribuyente("Lucas", 94118949, "lucas@gmail.com", "citybell");
		c1 = sistema.darAltaContribuyente("pedro", 24564897, "lucas@gmail.com", "citybell");
		c2 = sistema.darAltaContribuyente("juan", 45654897, "lucas@gmail.com", "asda");
		
		contribuyente.registrarBien(new Automotor("a208r", "peugeot", "208", LocalDate.of(2010, 1, 1), 20000000, contribuyente));
		contribuyente.registrarBien(new Inmueble(100, 100, 100, contribuyente));
		contribuyente.registrarBien(new Embarcacion("a564rr", "nombre", LocalDate.of(2022, 1, 10), 100000, contribuyente));
		
		c1.registrarBien(new Automotor("a208r", "peugeot", "208", LocalDate.of(2010, 1, 1), 20000000, c1));
		c1.registrarBien(new Inmueble(100, 100, 100, c1));
		c1.registrarBien(new Embarcacion("a564rr", "nombre", LocalDate.of(2022, 1, 10), 100000, c1));
		
		c2.registrarBien(new Automotor("a208r", "peugeot", "208", LocalDate.of(2010, 1, 1), 20000000, c2));
	}
	
    @Test
    public void testPagarContribuyente() {
        assertEquals(10002, contribuyente.impuestoPagarContribuyente());
    }
    
    @Test
    public void testContribuyenteMasPagan() {
    	List<Contribuyente> contriMasPagan = sistema.contribuyentesMasPagan("citybell", 3); // solo toma 2 porque solo hay 2 que coinciden con la localidad citybell
    	for (int i = 0; i < contriMasPagan.size(); i++) {    		
    		System.out.println(contriMasPagan.get(i).getNombre());
    	}
    	assertEquals("Lucas", contriMasPagan.get(0).getNombre());
    	assertEquals("pedro", contriMasPagan.get(1).getNombre());
    	assertTrue(contriMasPagan.size() == 2);
    }
}
