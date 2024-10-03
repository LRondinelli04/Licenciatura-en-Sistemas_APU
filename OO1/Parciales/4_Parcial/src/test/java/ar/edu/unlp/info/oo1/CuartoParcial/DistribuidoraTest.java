package ar.edu.unlp.info.oo1.CuartoParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class DistribuidoraTest {
	
	Distribuidora empresa;
	Cliente c, c1;
	ProductoNacional pNacional;
	ProductoImportado pImportado;
	Pedido pedido;
	Item item;
	
	@BeforeEach
	void setUp() throws Exception {
		// crear empresa
		empresa = new Distribuidora();
		
		// Crear Cliente
		c = new Cliente("Lucas", "lrondinelli2004@gmail.com");
		c1 = new Cliente ("Pedro", "pedro@gmail.com");
	
		pNacional = new ProductoNacional("celular", "electronica", 1000);
		pImportado = new ProductoImportado("cama", "hogar", 1000, "Brazil");
		
		pedido = new Pedido();
		
		item = new Item(pNacional, 2);
	
	}
	
    @Test
    public void testCliente() {
    	
    	// REGISTRO LOS CLIENTES
    	empresa.registrarCliente(c);
        empresa.registrarCliente(c1);
        
       // assertEquals(c, empresa.getClientes().get(0));
       // assertEquals(c1, empresa.getClientes().get(1));
        
        /*
        for (Cliente cliente : empresa.getClientes()) {
        	System.out.println(cliente.getNombre());
        }
        */
    }
    
    @Test
    public void testProducto() {
    	
    	// REGISTRO LOS PRODUCTOS
    	empresa.addProducto(pNacional);
    	empresa.addProducto(pImportado);
    	
    	// assertEquals(pNacional, empresa.getProductos().get(0));
    	// assertEquals(pImportado, empresa.getProductos().get(1));
    	
    	/*
    	for (Producto producto : empresa.getProductos()) {
        	System.out.println(producto.getNombre());
        }
    	*/
    }
    
    @Test
    public void testCostoTotal() {
    	this.testCliente();
    	this.testProducto();
    	
    	// AGREGO EL ITEM AL PEDIDO
    	pedido.addItem(item);
    	// AGREGO EL PEDIDO A UN CLIENTE
    	c.agregarPedido(pedido);
    	
    	// CALCULAR EL COSTO TOTAL
    	// TIENE QUE ESPERAR 2050
    	/*
    	 * 1 PEDIDO, 1 ITEM --> cant 2 / costo --> 1000, 1 PRODUCTONACIONAL --> impuesto = 0.05 del costo
    	 * 1000 * 2 + 50 = 2050
    	 */
    	assertEquals(2050, c.costoTotal(LocalDate.of(2023, 1, 1),LocalDate.of(2025, 1, 1)));
    }
}
