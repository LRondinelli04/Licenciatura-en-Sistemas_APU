package ar.edu.unlp.info.oo1._Parcial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class MyCarBoxesTest {
	
	MyCarBoxes empresa;
	Empleado e1, e2, e3;
	Repuesto r1, r2;
	CompraRepuesto cr, cr2;
	Reparacion r, repa;
	
	
	@BeforeEach
	public void setUp(){
		empresa = new MyCarBoxes();
		
		// Dar de alta empleados
		e1 = empresa.darAltaEmpleado("Lucas", 1);
		e2 = empresa.darAltaEmpleado("Pedro", 1);
		e3 = empresa.darAltaEmpleado("Gustavo", 1);
		
		// Dar de alta Repuestos
		r1 = empresa.darAltaRepuesto("Filtro de aceite", LocalDate.of(2024, 6, 15), 1);
        r2 = empresa.darAltaRepuesto("Bujía", LocalDate.of(2024, 4, 20), 1);
        
        // Registrar Orden de COMPRA DE REPUESTOS
        cr = empresa.registrarCompraRepuesto("ab202as");
        cr2 = new CompraRepuesto("123", empresa.getRepuestos());
        
        // Registrar Orden de REPARACION
        r = empresa.registrarReparacion("ABC123", "Cambio de bujías", 5);
        repa = new Reparacion("12312", "nada", empresa.getRepuestos(), empresa.getEmpleados(), 10);
	}
	
	@Test
	public void testDarAltaEmpleado() {
		assertEquals(3, empresa.getEmpleados().size());
		assertNotEquals(2, empresa.getEmpleados().size());
	}
	
	@Test
	public void testDarAltaRepuesto() {
		assertEquals(2, empresa.getRepuestos().size());
	}
	
	@Test
	public void testRegistrarCompraRepuesto() {
		assertEquals(cr, empresa.getOrden().get(0));
		assertNotEquals(cr, empresa.getOrden().get(1));
	}
	
	@Test
	public void testRegistrarReparacion() {
		assertEquals(r, empresa.getOrden().get(1));
	}
	
	@Test
	public void testFacturarOrdenes() {
		List<Orden> ordenesAFacturarSinDescuento = new ArrayList<>();
		ordenesAFacturarSinDescuento.add(cr2);
		ordenesAFacturarSinDescuento.add(repa);
		
		List<Orden> ordenesAFacturarConDescuento = new ArrayList<>();
		ordenesAFacturarConDescuento.add(cr);
		ordenesAFacturarConDescuento.add(r);
		
		assertEquals(19.95, empresa.facturarOrdenes(ordenesAFacturarConDescuento));
		assertNotEquals(12, empresa.facturarOrdenes(ordenesAFacturarSinDescuento));
	}
	
    
}
