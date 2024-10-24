package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class PersonaTest {
	
	Empresa empresa;
	PersonaFisica c1;
	ClienteCorporativo c2;
	Local e1;
	Internacional e2;
	Interurbano e3;
	
	
	@BeforeEach
	void setUp() {
		empresa = new Empresa();
		
		c1 = new PersonaFisica("lucas", "citybell", 94118949);
		c2 = new ClienteCorporativo("adidas", "laplata", 209418941);
		
		e1 = new Local(LocalDate.now(), "citybell", "villaelisa", 2500, true);
		e2 = new Internacional(LocalDate.now(), "citybell", "Brasil", 10000);
		e3 = new Interurbano(LocalDate.now(), "citybell", "Mendoza", 2500, 50);
		
		empresa.addCliente(c1);
		empresa.addCliente(c2);
	
		empresa.agregarEnvioACliente(c1, e1);
		empresa.agregarEnvioACliente(c1, e3);
		empresa.agregarEnvioACliente(c2, e2);
	}
	
	@Test
	public void testAddCliente() {
		assertEquals(c1, empresa.getClientes().get(0));
		assertEquals(c2, empresa.getClientes().get(1));
	}
	
	@Test
	public void testAgregarEnvioCliente() {
		assertEquals(e1, c1.getEnvios().get(0));
		assertEquals(e3, c1.getEnvios().get(1));
		assertEquals(e2, c2.getEnvios().get(0));
	}
	
	@Test
	public void testMontoAPagar() {
		assertEquals(46350, empresa.montoAPagar(c1, LocalDate.of(2023, 1, 1), LocalDate.of(2025, 1, 1)));
		assertEquals(125000, empresa.montoAPagar(c2, LocalDate.of(2023, 1, 1), LocalDate.of(2025, 1, 1)));
	}
}
