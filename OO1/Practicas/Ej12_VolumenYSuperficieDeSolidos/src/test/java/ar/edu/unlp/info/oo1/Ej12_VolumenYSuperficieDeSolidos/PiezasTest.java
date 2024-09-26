package ar.edu.unlp.info.oo1.Ej12_VolumenYSuperficieDeSolidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class PiezasTest {
	
	ReporteDeConstruccion reporte;
	Cilindro cilindro;
	Esfera esfera;
	PrismaRectangular prisma;

	
	private void initialize() {
		// seteo todos los objetos
		 reporte = new ReporteDeConstruccion();
	     cilindro = new Cilindro(10,20,"Hierro","Rojo");
	     esfera = new Esfera(8,"Hierro","Azul");
	     prisma = new PrismaRectangular(10,5,30,"Metal","Azul");
	}
	
	@BeforeEach
	public void setUp() {
		// llamo el metodo para settear que genere
		this.initialize();
	}
	
	@Test
    public void testCilindro() {
    	assertEquals(600,cilindro.getVolumen(),1e-3);
    	assertEquals(1884,cilindro.getSuperficie(),1e-3);
    }
	
	@Test
	public void testEsfera() {
		assertEquals(2144.66,esfera.getVolumen(),1e-3);
    	assertEquals(804.247,esfera.getSuperficie(),1e-3);
    	
	}
	
	@Test
	public void testPrisma() {
		assertEquals(1500,prisma.getVolumen());
    	assertEquals(1000,prisma.getSuperficie());
	}
    
    @Test
    void testReportes() {
    	// Agrego las piezas a la lista
    	reporte.agregarPieza(cilindro); 
    	reporte.agregarPieza(esfera);
    	reporte.agregarPieza(prisma);
    	// Sumo los volumenes de las piezas con el material hierro
    	assertEquals(2744.66,reporte.volumenDeMaterial("Hierro"),1e-3);
    	// Sumo las superficies de las piezas con el color rojo
    	assertEquals(1884,reporte.superficieDeColor("Rojo"),1e-3);
    	// Sumo las superficies de las piezas con el color azul
    	assertEquals(1804.247,reporte.superficieDeColor("Azul"),1e-3);
    }
	
}
