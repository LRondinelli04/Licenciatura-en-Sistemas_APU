package ar.edu.unlp.info.oo1.Ej11_ElInversor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class InversorTest {
	
	Inversor inversor;
	InversionEnAcciones invAcciones;
	PlazoFijo fijo;
	
	@BeforeEach
	void setUp() throws Exception{
		inversor = new Inversor("Juan");
		invAcciones = new InversionEnAcciones("accion1", 2, 5.5);
		fijo = new PlazoFijo(LocalDate.of(2024, 9, 25), 10.0, 20.0);			
	}
	
	@Test
	public void testAcciones() {
		assertEquals(11, invAcciones.valorActual());
	}
	
	@Test
	public void testPlazoFijo() {
		// El cualculo actual es el siguiente
		// la cant de dias de diferencia hasta hoy = 1
		// porcentaje de interes diario = 20
		// monto depositado = 10
		// 1 * 20 = 20 + 10 = 30
		assertEquals(30, fijo.valorActual());
	}
	
	@Test
	public void testInversor() {
		// No hay inversiones agregadas
		assertEquals(0,inversor.valorActual());
		inversor.agregarInversion(invAcciones);
		// Al agregarle la inverios invAcciones, ya calcule que su valor es 11
		assertEquals(11,inversor.valorActual());
		inversor.agregarInversion(fijo);
		// Le agrego el valor de la inversion fijo que es 30
		// 11 + 30 = 41
		assertEquals(41,inversor.valorActual());
	}
}
