package ar.edu.unlp.info.oo1.TercerParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class ViviendasTest {
	
	MantenimientoViviendas empresa;
	Cliente c1, c2, c3;
	Limpieza l1, l2;
	Parquizacion p1, p2;
	List<Contratacion> contrataciones;
	Maquina m1, m2, m3;
	
	
	public void initialize() {
		// Creo el objeto de la empresa
		empresa = new MantenimientoViviendas();
		
		// Creo los clientes
		c1 = new Cliente("Lucas", "461c");
		c2 = new Cliente("Juan", "quimilar");
		c3 = new Cliente("Pedro", "495 gonnet");
		
		// Creo los servicios que van a contratar los clientes
		l1 = new Limpieza(10.0, 5, 100.0);
		l2 = new Limpieza(5.0, 5, 20);
		
		p1 = new Parquizacion(2.0, 3);
		p2 = new Parquizacion(5.0, 5);
		
		// Creo las maquinas para la parquizacion
		m1 = new Maquina(10.0);
		m2 = new Maquina(12.0);
		m3 = new Maquina(5.0);
		
		// Creo las contrataciones
		contrataciones = new ArrayList<>();	
	}
	
	@BeforeEach
	public void setUp() {
		this.initialize();
	}
	
	@Test
	public void testMaquina() {
		p1.addMaquina(m1);
		p1.addMaquina(m2);
		
		p2.addMaquina(m1);
		p2.addMaquina(m2);
		p2.addMaquina(m3);
	}
	
	
	@Test
	public void testCliente() {
		// Agrego las maquinas a los servicios de parquizacion
		this.testMaquina();
		
		// Agrego los servicios a los clientes
		c1.addServicio(l1);
		c1.addServicio(p1);
		
		c2.addServicio(l1);
		
		c3.addServicio(l1);
		c3.addServicio(l2);
		c3.addServicio(p1);
		c3.addServicio(p2);
	}
	
	@Test
	public void testServicios() {
		assertEquals(100, l1.calcularMonto()); // la tarifa min es 100
		assertEquals(25, l2.calcularMonto()); // la tarifa es 25
		
		// Agrego las maquinas al serv de parquizacion
		this.testMaquina();
		
		assertEquals(50, p1.calcularMonto());
		assertEquals(106, p2.calcularMonto());
		
	}
	
	@Test
	public void testContrataciones() {
		contrataciones.add(new Contratacion(c1, l1, LocalDate.now()));
		contrataciones.add(new Prolongada(c2, l1, LocalDate.now(), 10));
		
		// Obtener monto de las contrataciones
		assertEquals(100, contrataciones.get(0).obtenerMonto()); // tiene que dar 100
		assertEquals(900, contrataciones.get(1).obtenerMonto()); // tiene que dar 900
	}
	
	@Test 
	public void testObtenerServicioConMayorMonto() {
		// Agrego los servicios de los clientes
		this.testCliente();
		
		empresa.addCliente(c1);
		empresa.addCliente(c2);
		empresa.addCliente(c3);
		assertEquals(4, empresa.cantServiciosMayor(99));
		// System.out.println("La cant de servicios con valor mayor a 99 son: " + empresa.cantServiciosMayor(99)); // = 4 de 7
	}
	
	
}
