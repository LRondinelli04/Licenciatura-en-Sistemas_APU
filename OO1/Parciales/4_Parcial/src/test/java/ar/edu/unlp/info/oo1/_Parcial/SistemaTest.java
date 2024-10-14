package ar.edu.unlp.info.oo1._Parcial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SistemaTest {

    private Sistema sistema;
    private Cliente cliente1;
    private Cliente cliente2;
    private Producto productoNacional;
    private Producto productoImportado;
    
    @BeforeEach
    public void setUp() {
        sistema = new Sistema();
        cliente1 = sistema.registrarCliente("Cliente Uno", "cliente1@example.com");
        cliente2 = sistema.registrarCliente("Cliente Dos", "cliente2@example.com");
        productoNacional = sistema.registrarProductoNacional("Producto Nacional", 100.0, "Descripción Nacional");
        productoImportado = sistema.registrarProductoImportado("Producto Importado", 200.0, "Descripción Importada", "EE.UU.");
    }

    @Test
    public void testRegistrarCliente() {
        assertNotNull(cliente1);
        assertEquals("Cliente Uno", cliente1.getNombre());
    }
   
    
    
    @Test
    public void testRegistrarProductoNacional() {
        assertNotNull(productoNacional);
        assertEquals("Producto Nacional", productoNacional.getNombre());
    }
    
   
    @Test
    public void testRegistrarProductoImportado() {
        assertNotNull(productoImportado);
        assertEquals("Producto Importado", productoImportado.getNombre());
    }

    
    @Test
    public void testRegistrarPedidoParaCliente() {
        Pedido pedido = sistema.registrarPedidoParaCliente(cliente1);
        assertNotNull(pedido);
        assertEquals("Cliente Uno", pedido.getCliente().getNombre());
    }

    
    @Test
    public void testAgregarItemAPedido() {
        Pedido pedido = sistema.registrarPedidoParaCliente(cliente1);
        sistema.agregarItemAPedido(pedido, productoNacional, 2);
        
        assertEquals(1, pedido.getItem().size()); // tamaño de la lista del items de ese pedido
        assertEquals(productoNacional, pedido.getItem().get(0).getProducto()); // el tipo de producto del item agregado al pedido
        assertEquals(2, pedido.getItem().get(0).getCant()); // valor de cant en el item agregado al pedido
    }

    
    @Test
    public void testCantTotalProductoSolicitado() {
        Pedido pedido = sistema.registrarPedidoParaCliente(cliente1);
        sistema.agregarItemAPedido(pedido, productoNacional, 2);
        sistema.agregarItemAPedido(pedido, productoNacional, 3); // Solicitar más del mismo producto
        
        int total = sistema.cantTotalProductoSolicitado(productoNacional);
        assertEquals(5, total);
    }

    
    
    @Test
    public void testCostoTotalDePedidos() {
        Pedido pedido = sistema.registrarPedidoParaCliente(cliente1);
       // pedido.setFecha(LocalDate.now().minusDays(10)); // Ajustar la fecha para el test
        sistema.agregarItemAPedido(pedido, productoNacional, 2);
        
        double costo = sistema.costoTotalDePedidos(cliente1, LocalDate.now().minusDays(30), LocalDate.now());
        assertEquals(205, costo); // 2 items a 100 cada uno + impuesto del 0.05 del costo Unitario = 200 + 5
    }

    @Test
    public void testTopClientes() {
        Pedido pedido1 = sistema.registrarPedidoParaCliente(cliente1);
       // pedido1.setFecha(LocalDate.now().minusDays(10));
        sistema.agregarItemAPedido(pedido1, productoNacional, 3); // Costo total: 305.0
        
        Pedido pedido2 = sistema.registrarPedidoParaCliente(cliente2);
       // pedido2.setFecha(LocalDate.now().minusDays(5));
        sistema.agregarItemAPedido(pedido2, productoImportado, 1); // Costo total: 242.0
        
        List<Cliente> topClientes = sistema.topClientes();
        assertEquals(2, topClientes.size());
        assertEquals(cliente1, topClientes.get(0)); // Cliente 1 debería estar primero
    }
}
