/*
 * 3)
 * FUNCIONALIDAD -> CALCULAR EL COSTO TOTAL DE LOS PEDIDOS DE UN CLIENTE EN UN PERIODO
 * TENER EN CUENTA:
 *  - Valores de borde
 *  - Particiones equivalentes
 * 
 * ESPECIFICAR LAS CALSES A TESTEAR CON LOS METODOS QUE INVOLUCRAN LA EJECUCION DEL "Calcular Costo total de pedidos de un cliente en un periodo"
 * 
 * Cliente::costoTotalPedidos()
 * 	- No hay pedidos en la lista
 * 	- No hay pedidos dentro del periodo ingresado
 * 	- Se encuentra al menos 1 pedido dentro del periodo
 * 
 * Pedido::pedidoEnFecha()
 * 	- Este metodo lo que realiza el la verificacion de pedidos dentro de las fechas ingresadas
 * 
 * Pedido::costoTotalPedidos()
 * 	- No hay items en la lista
 * 	- Se encuentra al menos 1 Item 
 * 
 * Item::costoTotalItem()
 * 	- un PRODUCTO NACIONAL con 10 unidades
 *  - un PRODUCTO NACIONAL con 11 unidades
 *  - un PRODUCTO IMPORTADO con pais de origen del Mercosur y 51 unidades
 *  - un PRODUCTO IMPORTADO con pais de origen del Mercosur y 50 unidades
 *  - un PRODUCTO IMPORTADO que no es del Mercosur
 */

// 4)

// Codigo JAVA para:

// Inicializar el sistema
Distribuidora d = new Distribuidora();
// registrar un producto nacional
Producto pn = d.registrarProdNacional("producto nacional", 100, "descripcion");
// registrar un cliente
Cliente c = d.registrarCliente("Lucas", "lucas@gmail.com");
// agregar un pedido al cliente con un item para ese producto
Pedido p = c.registrarPedido();
p.agregarItem(pn, 5);