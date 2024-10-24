package ar.edu.unlp.info.oo1._Parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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
	
		contribuyente = new Contribuyente("Lucas", "lucas@gmail.com", "citybell");
		c1 = new Contribuyente("pedro", "lucas@gmail.com", "citybell");
		c2 = new Contribuyente("juan", "lucas@gmail.com", "citybell");
		
		// Doy de alta todos los servicios
		sistema.darAltaContribuyente(contribuyente);
		sistema.darAltaContribuyente(c1);
		sistema.darAltaContribuyente(c2);
		
		sistema.darAltaAutomotor("a208r", "peugeot", "208", LocalDate.of(2010, 1, 1), 20000000, contribuyente);
		sistema.darAltaInmbueble(100, 100, 100, contribuyente);
		sistema.darAltaEmbarcacion("a564rr", "nombre", LocalDate.of(2022, 1, 10), 100000, contribuyente);
		
		sistema.darAltaAutomotor("a208r", "peugeot", "208", LocalDate.of(2010, 1, 1), 20000000, c1);
		sistema.darAltaInmbueble(100, 100, 100, c1);
		sistema.darAltaEmbarcacion("a564rr", "nombre", LocalDate.of(2022, 1, 10), 100000, c1);
		
		sistema.darAltaAutomotor("a208r", "peugeot", "208", LocalDate.of(2010, 1, 1), 20000000, c2);
	}
	
    @Test
    public void testPagarContribuyente() {
        assertEquals(10002, sistema.impuestoPagarContribuyente(contribuyente));
    }
    
    @Test
    public void testContribuyenteMasPagan() {
    	sistema.contribuyentesMasPagan("citybell", 2);
    }
}
