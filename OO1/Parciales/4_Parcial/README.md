# Cuarto Parcial

Una distribuidora brinda la posibilidad de registrar los pedidos de compra de sus clientes. Cada cliente puede realizar pedidos en los cuales se especifican los productos deseados, incluyendo las cantidades necesarias.

El sistema debe permitir

- **Registrar Cliente:** Dado el nombre y e-mail, se crea y retorna el cliente con la fecha actual, como fecha de alta.
- **Registrar producto:** nacional Dado el nombre, el costo unitario y descripción, se registra y retorna el producto.
- **Registrar producto importado:** Dado el nombre, el costo unitario, descripción y el país de origen, se registra el producto y se retorna.
- **Registrar un pedido para un cliente:** Dado un cliente se registra un pedido nuevo con la fecha actual como fecha de pedido y se lo retorna.
- **Agregar un item para un pedido:** Dado un pedido y un producto junto con la cantidad necesaria del mismo, se registra el ítem en el pedido.
- **Calcular la cantidad total solicitada de un producto:** Dado un producto, determinar la cantidad todal de unidades solicitadas de ese producto, calculada como la suma de las cantidades pedidas de dicho producto en todos los pedidos registrados para todos los clientes.
- **Calcular el costo total de los pedidos de un cliente en un período:** Dado un cliente, una fecha de inicio y una fecha de fin, se debe calcular el costo que tiene por sus pedidos realizados en dicho período, según la siguiente especificación:
    - Cada pedido tiene como costo, la suma de los costos totales de sus items.
    - El costo total de cada item se calcula multiplicando el costo unitario del producto por la cantidad y sumando el impuesto.
    - El impuesto se calcula a partir de las siguientes reglas:
        - Si el producto es nacional el impuesto depende de la cantidad pedida. Hasta 10 unidades, se debe pagar el 5% del costo unitario. En caso contrario se exceptúa del pago de impuesto.
        - Si el producto es importado, el impuesto varía de acuerdo al país de origen y la cantidad de unidades. Si el pais pertenece al Mercosur (Brazil, Paraguay o Uruguay) y son más de 50 unidades, corresponde pagar 8%. De lo contrario, el impuesto es 21%.
- **Retornar los clientes del "top 5" de los últimos 30 dias:** se deben retornar los 5 clientes con mayor costo total en pedidos realizados en los últimos 30 dias.
Su tarea es diseñar y programar en Java lo que sea necesario para ofreceer la funcionalidad antes descrita. Se espera que entregue lo siguiente:

1) Diseño de su solución en un diagrama de clases UML.
2) Implementación en Java de la funcionalidad requerida
3) Diseño de los casos de Prueba: Enfocándose en la funcionalidad que permite "calcular el costo total de los pedidos de un cliente en un periodo" (es decir, todos los métodos de todas las clases involucradas en conseguir esa funcionalidad), determine y enumero qué métodos, de qué clases, testear y con qué casos de prueba para cada método (teniendo en cuenta los conceptos de valores borded y particiones equivalentes)
Ejemplo: Clase CajaAhorro - Metodo Extraer(monto:double)
Casos de prueba identificados: saldo igual al monto, saldo menor al monto y saldo mayor al monto.
4) Un ejemplo de código Java necesario para realizar el sistema, registrar un producto nacional, registrar un cliente, agregarle un pedido al cliente con un item para ese producto.