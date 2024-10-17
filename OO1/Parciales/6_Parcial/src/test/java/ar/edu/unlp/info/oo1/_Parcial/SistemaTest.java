package ar.edu.unlp.info.oo1._Parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class SistemaTest {
	
	Sistema sistema;
	Residencial c1;
	Industria c2;
	
	@BeforeEach
	public void setUp() {
		sistema = new Sistema(100, 100);
		
		c1 = sistema.darAltaClienteResidencial("Lucas", "Rondinelli", "citybell");
		c2 = sistema.darAltaClienteIndustria("adidas", "gonnet");
		
	}
	
	@Test
	public void testDarAltaClienteResidencial() {
		assertEquals(c1, sistema.getClientes().get(0));
		
	}
	
	@Test
	public void testDarAltaClienteIndustria() {
		assertEquals(c2, sistema.getClientes().get(1));
	}
	
	@Test
	public void testRegistrarConsumoCliente() {
		sistema.registrarConsumoCliente(c1, 10, 1, 2024);
		assertEquals(1, c1.getConsumo().size()); // se registro correctamente el consumo
	}
	
	@Test
	public void testActualizarTarifario() {
		sistema.actualizarTarifario(10, 15);
		assertEquals(10, sistema.getTarifa().getPrecioUnidadCliente());
		assertEquals(15, sistema.getTarifa().getPrecioUnidadIndustria());
	}
	
	@Test
	public void testObtenerConsumoPorMesYAnio() {
		sistema.registrarConsumoCliente(c1, 10, 1, 2024); // registro un consumo
		assertEquals(10, sistema.obtenerConsumoPorMesYAnio(c1, 1, 2024));
	}
	
	@Test
	public void testCalcularMontoCliente() {
		sistema.registrarConsumoCliente(c1, 10, 1, 2024);
		// sistema.registrarConsumoCliente(c1, 9, 1, 2023); // Con este registro no me da descuento = monto total = 1000
		// Tarifa de cliente residencial = 100
		// No hay registros de un consumo en el año anterior = descuento del 10%
		// 10 * 100 = 1000 - 100 = 900
		assertEquals(900, sistema.calcularMontoCliente(c1, 1, 2024));
		
		sistema.registrarConsumoCliente(c2, 10, 3, 2024);
		sistema.registrarConsumoCliente(c2, 11, 2, 2024);
	
		// Tarifa de industria = 100
		// Hay registros de consumos del mes anterior, por lo que se realiza un descuento del 2%
		// 10 * 100 = 1000 - 20 = 980
		assertEquals(980, sistema.calcularMontoCliente(c2, 3, 2024));
	}
}
