package ar.edu.unlp.info.oo1.PrimerParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class ContribuyenteTest {
	
	AgenciaRecaudacion agencia;
	Contribuyente con1, con2, con3;
	Inmueble inmueble;
	Automotor automotor;
	Embarcacion embarcacion;
	
	public void initialize() {
		this.agencia = new AgenciaRecaudacion();
		this.con1 = new Contribuyente("Lucas", 94118949, "lrondinelli@gmail.com", "City Bell");
		this.con2 = new Contribuyente("juan", 123456789, "lrondinelli04@gmail.com", "City Bell");
		this.con3 = new Contribuyente("pedro", 987654321, "lrondinelli2004@gmail.com", "City Bell");
		this.inmueble = new Inmueble(100, 100, 100);
		this.automotor = new Automotor("ABC123", "peugeot", "208", LocalDate.of(2005, 1, 1), 100);
		this.embarcacion = new Embarcacion("XYZ987", "Lucas", LocalDate.of(2022, 1, 1), 100);
	}
	
	@BeforeEach
	public void setUp() {
		this.initialize();
	}
	
	@Test
	public void testContribuyente() {
		// Impuesto = 2 = (100 + 100) * 0.01
		con1.agregarBien(inmueble);
		// Impuesto = 0 = mas de 10 años de antiguedad
		con1.agregarBien(automotor);
		// Impuesto = 15 = 100 * 0.15
		con1.agregarBien(embarcacion);
		
		con2.agregarBien(embarcacion);
		con2.agregarBien(embarcacion);
		con2.agregarBien(embarcacion);
		
		con3.agregarBien(automotor);
		con3.agregarBien(inmueble);
		
		// 2 + 15 = 17
		assertEquals(17, con1.calcularImpuesto());
		assertEquals(45, con2.calcularImpuesto());
		assertEquals(2, con3.calcularImpuesto());
		
		agencia.agregarContribuyente(con1);
		agencia.agregarContribuyente(con2);
		agencia.agregarContribuyente(con3);
		
		List<Contribuyente> topContribuyentes = agencia.contribuyenteQueMasPagan("City Bell", 10);
		
		assertEquals("juan", topContribuyentes.get(0).getNombre());
		assertEquals("Lucas", topContribuyentes.get(1).getNombre());
		
		for (int i = 0; i < topContribuyentes.size(); i++) {
			if (i == 0) {
				System.out.println("El contribuyente que mas paga dentro de la localidad de " + topContribuyentes.get(i).getLocalidad() + " es: " + topContribuyentes.get(i).getNombre() + " con un total de: " + topContribuyentes.get(i).calcularImpuesto());
				System.out.println("Los contribuyentes que le siguen: ");
			} else {
				System.out.println(" - Contribuyente de la localida de: " + topContribuyentes.get(i).getLocalidad() + " es: " + topContribuyentes.get(i).getNombre() + ", paga un total de: " + topContribuyentes.get(i).calcularImpuesto());
			}
		}
	}
	
	
}
