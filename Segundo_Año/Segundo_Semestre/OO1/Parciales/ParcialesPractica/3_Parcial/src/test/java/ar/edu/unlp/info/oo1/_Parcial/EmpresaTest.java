package ar.edu.unlp.info.oo1._Parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class EmpresaTest {
	
	Empresa empresa;
	Cliente c1, c2;
	ContratoUnico contratoUnico;
	ContratoProlongado contratoProlongado;
	Limpieza limpieza;
	Parquizacion parquizacion;
	
	@BeforeEach
	void setUp() throws Exception {
		empresa = new Empresa();
		
		c1 = new Cliente("Lucas", "citybell");
		c2 = new Cliente("Juan", "quimilar");
		
		limpieza = new Limpieza(10.0, 10, 200.0);
		parquizacion = new Parquizacion(15.0, 5, 10, 20.0);
		
		empresa.registrarCliente(c1);
		empresa.registrarCliente(c2);
		
		empresa.registrarServicioLimpieza(limpieza);
		empresa.registrarServicioParquizacion(parquizacion);
		
		empresa.contratarUnicaVez(c1, limpieza, LocalDate.now());
		empresa.contratarProlongada(c2, parquizacion, LocalDate.now(), 10);
	}
	
	@Test
	public void testRegistrarCliente() {
		assertEquals(c1, empresa.getClientes().get(0));
		assertNotEquals(c1, empresa.getClientes().get(1));
	}
	
	@Test
	public void testRegistrarServicios() {
		assertEquals(limpieza, empresa.getServicios().get(0));
		assertEquals(parquizacion, empresa.getServicios().get(1));
	}
	
	@Test
	public void testMontoAPagar() {
		assertNotEquals(100, empresa.montoAPagar(c1)); // tiene que dar 200 (tarifaMin)
		assertEquals(200, empresa.montoAPagar(c1));
		assertEquals(2475, empresa.montoAPagar(c2));
	}
	
	@Test
	public void testCantServiciosMayor() {
		assertEquals(2, empresa.cantServiciosMayor(10000)); // devuelve 2
	}
	
	

}
