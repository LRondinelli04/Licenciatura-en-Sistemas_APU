package ar.edu.unlp.info.oo1.SegundoParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class FacturaOrdenesTest {
	
	private MyCarBoxes carBoxes;
	private Empleado e1, e2, e3;
	private Repuesto r1, r2, r3;
	private OrdenCompraRepuestos ocr1, ocr2, ocr3;
	private OrdenReparacion ordenReparacion;
	private FacturaOrdenes factura;
	
	private List<OrdenReparacion> ordenDeReparaciones;
	private List<OrdenCompraRepuestos> ordenDeRepuestos;
	
	@BeforeEach
	public void setUp() {
		carBoxes = new MyCarBoxes();
		
		e1 = new Empleado("Lucas", 10);
		e2 = new Empleado("Pedro", 10);
		e3 = new Empleado("Juan", 10);
		
		r1 = new Repuesto("llanta", LocalDate.of(2024, 5, 15), 10);
		r2 = new Repuesto("motor", LocalDate.of(2024, 5, 15), 10);
		r3 = new Repuesto("espejo", LocalDate.of(2024, 5, 15), 10);
		
		ordenDeReparaciones = new ArrayList<OrdenReparacion>();
		ordenDeRepuestos = new ArrayList<OrdenCompraRepuestos>();

		factura = new FacturaOrdenes();
		
	}
	
	@Test
	public void testFactura(){
		
		// agregar los empleados y los repuestos a la lista
		carBoxes.addEmpleado(e1);
		carBoxes.addEmpleado(e2);
		carBoxes.addEmpleado(e3);
		
		carBoxes.addRpuesto(r1);
		carBoxes.addRpuesto(r2);
		carBoxes.addRpuesto(r3);
		
		ocr1 = new OrdenCompraRepuestos("AB209YR", carBoxes.getRepuestos());
		ocr2 = new OrdenCompraRepuestos("AC789FG", carBoxes.getRepuestos());
		ocr3 = new OrdenCompraRepuestos("BV456DF", carBoxes.getRepuestos());
		
		ordenReparacion = new OrdenReparacion("AB209YR", "arreglar el faro de luz", 5, carBoxes.getEmpleados(), carBoxes.getRepuestos());
		
		/*
		carBoxes.getEmpleado();
		carBoxes.getRepuesto();
		*/
		
		assertEquals(34.5, ocr1.costoTotal());
		
		assertEquals(198, ordenReparacion.costoTotal());
		
		this.ordenDeReparaciones.add(ordenReparacion);
		this.ordenDeRepuestos.add(ocr1);
		this.ordenDeRepuestos.add(ocr2);
		this.ordenDeRepuestos.add(ocr3);
		
		factura.facturarOrdenes(ordenDeRepuestos, ordenDeReparaciones);
		
		
		
		// factura.facturarOrdenes(car, null)
		
	}
	
	
	
}
