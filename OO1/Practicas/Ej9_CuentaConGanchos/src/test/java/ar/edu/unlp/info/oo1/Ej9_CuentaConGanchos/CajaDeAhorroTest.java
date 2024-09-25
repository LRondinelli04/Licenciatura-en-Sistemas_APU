package ar.edu.unlp.info.oo1.Ej9_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {

	CajaDeAhorro cAhorro;
	
	@BeforeEach
	void setUp() throws Exception {
		cAhorro = new CajaDeAhorro();
		// deposito 10 a su monto
		cAhorro.depositar(10);
	}
	
	@Test
	public void testDepositar() {
		// Verificar que el saldo es 9.8, ya que te cobran una comision del 2% del monto depositado
		// depositar(10) = monto = 9.8
		assertEquals(9.8, cAhorro.getSaldo());
	}
	
	@Test
	public void testPuedeExtraer() {
		// Evaluar condicion FALSE de poder extraer
		assertFalse(cAhorro.puedeExtraerMonto(15));
		// Evaluar conficion TRUE para poder extraer
		assertTrue(cAhorro.puedeExtraerMonto(2));
	}
	
	@Test
	public void testTransferirACuenta() {
		// MONTO ACTUAL = 9.8
		
		// Creo la cuenta a donde voy a transferir el dinero
		CuentaCorriente ccTransferir = new CuentaCorriente();
		// Evaluar condicion false de transferir (te cobran el 2%)
		assertFalse(cAhorro.trasnferirACuenta(10, ccTransferir));
		// Evaluo condicion FALSE de monto de la cuenta creada
		// No tiene saldo actual
		assertFalse(ccTransferir.puedeExtraerMonto(10));
		// Evaluo condicion true para transferir a cuenta
		assertTrue(cAhorro.trasnferirACuenta(2, ccTransferir));
	}
	
}
