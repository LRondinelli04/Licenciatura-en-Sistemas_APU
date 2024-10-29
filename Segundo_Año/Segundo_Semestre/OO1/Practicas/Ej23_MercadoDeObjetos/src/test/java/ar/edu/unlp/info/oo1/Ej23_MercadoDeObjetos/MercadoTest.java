package ar.edu.unlp.info.oo1.Ej23_MercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class MercadoTest {
	
	Mercado mercado;
	Vendedor v1, v2;
	Cliente c1, c2;
	Producto p1, p2;
	Pedido pedido;
	Cuotas cuota;
	AlContado alContado;
	RetirarComercio rc;
	ExpressDomicilio ed;
	
	@BeforeEach
	public void setUp() {
		mercado = new Mercado();
		alContado = new AlContado();
		cuota = new Cuotas();
		rc = new RetirarComercio();
		ed = new ExpressDomicilio();
		
		v1 = new Vendedor("Lucas", "citybell");
		v2 = new Vendedor("Pedro", "villaelisa");
		
		c1 = new Cliente("juan", "quimi");
		c2 = new Cliente("joaco", "rigue");
		
		p1 = new Producto("heladera", "electro", 10000, 100);
		p2 = new Producto("horno", "electro", 1000, 100);
		
		mercado.addCliente(c1);
		mercado.addCliente(c2);
		mercado.addVendedor(v1);
		mercado.addVendedor(v2);
		
		v1.addProducto(p1);
		v1.addProducto(p2);
		v2.addProducto(p1);
		
		Producto prodSolicitado = p1;
		pedido = mercado.crearPedidoCliente(c1, alContado, rc, prodSolicitado, 10);
		
	}
	
    @Test
    public void testAddCliente() {
        assertEquals(c1, mercado.getClientes().get(0));
        assertEquals(c2, mercado.getClientes().get(1));
    }
    
    @Test
    public void testAddVendedor() {
    	assertEquals("Lucas", mercado.getVendedores().get(0).getNombre());
    	assertEquals("Pedro", mercado.getVendedores().get(1).getNombre());
    }
    
    @Test
    public void testCrearPedidoCliente() {
    	assertTrue(p1.getCantDisponible() == 90);
    	// System.out.println("cant restante del producto: " + p1.getNombre() + " " + p1.getCantDisponible());
    
    }
    
    @Test
    public void testCantPedidoCategoria() {
    	assertEquals(1, c1.cantPedidoCategoria("electro"));
    }
    
    @Test
    public void testCalcularCostoTotal() {
    	assertEquals(10000, pedido.calcularCostoTotal());
    }
}
