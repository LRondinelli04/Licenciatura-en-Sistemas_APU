package ar.edu.unlp.info.oo1.Ej9_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {

	CuentaCorriente cuentaCorriente;
	
	@BeforeEach
	void setUp() throws Exception {
		cuentaCorriente = new CuentaCorriente();
		// Deposito 10
		cuentaCorriente.depositar(10);
	}
	
	@Test
	public void testDepositar() {
		// Verificar que el saldo es 10
		assertEquals(10, cuentaCorriente.getSaldo());
	}
	
	@Test
	public void testExtraerSinControl() {
		// 10 - 1 = 9
		cuentaCorriente.extraerSinControlar(1);
		// Verificar que el saldo sea 9 = true
		assertEquals(9, cuentaCorriente.getSaldo());
	}
	
	@Test
	public void testPuedeExtraer() {
		// Verificar por TRUE que se puede extraer 9 del monto total
		assertTrue(cuentaCorriente.puedeExtraerMonto(9));
		// Verificar por TRUE que se puede extraer 10 del monto total
		assertTrue(cuentaCorriente.puedeExtraerMonto(10));
	}
	
	
	
}
