package ar.edu.unlp.info.oo1._Parcial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SistemaTest {

    Sistema sistema;
    Cliente cliente1;
    Cliente cliente2;
    Producto productoNacional;
    Producto productoImportado;
    
    @BeforeEach
    public void setUp() {
        sistema = new Sistema();
        
        cliente1 = sistema.registrarCliente("Cliente Uno", "cliente1@example.com");
        cliente2 = sistema.registrarCliente("Cliente Dos", "cliente2@example.com");
        
        productoNacional = sistema.registrarProducto(new ProductoNacional("Producto Nacional", 100.0, "Descripción Nacional"));
        productoImportado = sistema.registrarProducto(new ProductoImportado("Producto Importado", 200.0, "Descripción Importada", "EE.UU."));
    
        
    }

    @Test
    public void testRegistrarCliente() {
        assertEquals(cliente1, sistema.getClientes().get(0));
        assertEquals(cliente2, sistema.getClientes().get(1));
    }
   
    @Test
    public void testRegistrarProductos() {
    	assertEquals(productoNacional, sistema.getProductos().get(0));
    	assertEquals(productoImportado, sistema.getProductos().get(1));
    }
    
    @Test
    public void testRegistrarPedidoParaCliente() {
        Pedido pedido = new Pedido();
        cliente1.registrarPedido(pedido);
        assertEquals(pedido, cliente1.getPedidos().get(0));
    }

    
    @Test
    public void testAgregarItemAPedido() {
    	Pedido pedido = new Pedido();
        cliente1.registrarPedido(pedido);
        
        Item item = new Item(productoNacional, 10);
        
        pedido.agregarItem(item);
        
        assertEquals(1, pedido.getItems().size()); // tamaño de la lista del items de ese pedido
        assertEquals(productoNacional, pedido.getItems().get(0).getProducto()); // el tipo de producto del item agregado al pedido
    }

    
    @Test
    public void testCantTotalProductoSolicitado() {
    	Pedido pedido = new Pedido();
        cliente1.registrarPedido(pedido);
        
        Item item = new Item(productoNacional, 12);
        Item item2 = new Item(productoImportado, 10);
        
        pedido.agregarItem(item);
        pedido.agregarItem(item2);
        
        assertEquals(12, sistema.cantTotalSolicitadaProducto(productoNacional));
        assertEquals(10, sistema.cantTotalSolicitadaProducto(productoImportado));
    }

    
    
    @Test
    public void testCostoTotalPedidosEnPeriodo() {
    	Pedido pedido = new Pedido();
        cliente1.registrarPedido(pedido);
        
        Item item = new Item(productoNacional, 12);
        Item item2 = new Item(productoImportado, 10);
        
        pedido.agregarItem(item);
        pedido.agregarItem(item2);
        
        double costo = cliente1.costoTotalPedidosEnPeriodo(LocalDate.now().minusDays(30), LocalDate.now());
        assertEquals(3242, costo);
    }

    
    @Test
    public void testTopClientes() {
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
       // pedido1.setFecha(LocalDate.now().minusDays(10));
        Item item = new Item(productoNacional, 12);
        Item item2 = new Item(productoImportado, 10);
        
        pedido1.agregarItem(item);
        pedido1.agregarItem(item2);
        pedido2.agregarItem(item2);
        
        cliente1.registrarPedido(pedido2);
        cliente2.registrarPedido(pedido1); // cliente 2 tiene mas costo en su pedido
        
        List<Cliente> topClientes = sistema.topClientes();
        assertEquals(2, topClientes.size());
        for (int i = 0; i < sistema.getClientes().size(); i++) {
        	System.out.println(sistema.topClientes().get(i).getNombre());
        }
        assertEquals(cliente2, topClientes.get(0)); // Cliente 1 debería estar primero
    }
    
}
