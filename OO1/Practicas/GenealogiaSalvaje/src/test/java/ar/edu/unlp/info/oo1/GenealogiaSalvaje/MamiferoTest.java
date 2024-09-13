package ar.edu.unlp.info.oo1.GenealogiaSalvaje;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MamiferoTest {

    // Declaramos los mamíferos
    Mamifero nala, mufasa, alexa, simba, nalaHijo;

    @BeforeEach
    void setUp() {
        // Inicializamos los mamíferos
        nala = new Mamifero();
        mufasa = new Mamifero();
        alexa = new Mamifero();
        simba = new Mamifero();
        nalaHijo = new Mamifero();
        
        // Configuramos las relaciones de parentesco
        nala.setPadre(mufasa);    // Nala tiene a Mufasa como padre
        nala.setMadre(alexa);     // Nala tiene a Alexa como madre
        
        simba.setPadre(nala);     // Simba tiene a Nala como padre
        simba.setMadre(null);     // Simba no tiene madre definida
        
        nalaHijo.setPadre(null);  // NalaHijo no tiene padre definido
        nalaHijo.setMadre(null);  // NalaHijo no tiene madre definida
    }

    @Test
    public void testTieneComoAncestroAConPadreYMadre() {
        boolean resultado = nala.tieneComoAncestroA(nala);
        System.out.println("Test Tiene Como Ancestro A Con Padre Y Madre:");
        System.out.println("Resultado: " + resultado);
        assertTrue(resultado, "Nala debería tener ancestros.");
    }

    @Test
    public void testTieneComoAncestroAConPadre() {
        boolean resultado = simba.tieneComoAncestroA(simba);
        System.out.println("Test Tiene Como Ancestro A Con Padre:");
        System.out.println("Resultado: " + resultado);
        assertTrue(resultado, "Simba debería tener ancestro por parte de padre.");
    }

    @Test
    public void testNoTieneAncestros() {
        boolean resultado = nalaHijo.tieneComoAncestroA(nalaHijo);
        System.out.println("Test No Tiene Ancestros:");
        System.out.println("Resultado: " + resultado);
        assertFalse(resultado, "NalaHijo no debería tener ancestros.");
    }

    @Test
    public void testTieneAncestroPorMadre() {
        boolean resultado = nalaHijo.tieneComoAncestroA(nala);
        System.out.println("Test Tiene Ancestro Por Madre:");
        System.out.println("Resultado: " + resultado);
        assertTrue(resultado, "NalaHijo debería tener ancestros si se considera a Nala.");
    }

}
