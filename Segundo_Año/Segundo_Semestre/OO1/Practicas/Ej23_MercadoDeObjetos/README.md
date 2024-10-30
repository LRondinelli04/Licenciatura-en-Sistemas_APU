# Ejercicio 23. Mercado de Objetos

Queremos programar en objetos una versión simplificada de un mercado on-line similar a e-Bay o MercadoLibre. En esta plataforma, los vendedores registrados pueden publicar productos disponibles a la venta, y los clientes pueden realizar pedidos para comprar esos productos.
De los vendedores se conoce su nombre, dirección y los productos que ofrece para la venta, de los cuales se guarda nombre, categoría, precio y cantidad de unidades disponibles.
De los clientes se conoce su nombre, dirección y los pedidos que haya solicitado.

La plataforma ofrece diferentes opciones de pago, actualmente: "al contado" o "6 cuotas". A futuro podrían agregarse otras formas de pago. 
También existen diferentes formas de envío:  "retirar en el comercio", "retirar en sucursal del correo", ó "express a domicilio". A futuro podrían agregarse otras formas de envío.

**Nos piden implementar la siguiente funcionalidad:**

**Crear un pedido para un cliente:** dado un cliente, una forma de pago, una forma de envío, un producto y la cantidad solicitada, se verifica sí hay unidades disponibles del producto: sí es así, se crea el pedido y se descuentan las unidades indicadas del producto. No hace nada si no hay suficientes unidades disponibles. 

**Conocer la cantidad de productos pedidos por categoría:** dado un cliente, se desea conocer cuántos productos por categoría ha pedido en la plataforma. Ejemplos de categorías son: “Electrodomésticos”, “Computadores”, “Hogar”, etc.

**Calcular el costo total de un pedido:** Dado un pedido, se retorna su costo total que se calcula de la siguiente forma: (precio final en base a la forma de pago seleccionada) + (costo de envío en base a la forma de envío seleccionada).
- Si la forma de pago es "al contado", el precio final es el que se indica en el producto
- Si la forma de pago es "6 cuotas", el precio final se incrementa en un 20%
- Si la forma de envío es  "retirar en el comercio" no hay costo adicional de envío.
- Si la forma de envío es "retirar en sucursal del correo" el costo es de $3000.
- Si la forma de envío es "express a domicilio" el costo es $0.5 por Km de distancia entre la dirección del vendedor y del cliente. Asuma que existe una clase CalculadoraDeDistancia, cuyas instancias entienden el mensaje #distanciaEntre que recibe dos direcciones y retorna la distancia en Km entre ellas. Por ahora trabaje con una implementación propia para pruebas que siempre retorna 100 (sin importar las direcciones recibidas). 

**Tareas:**
Modele e implemente
Diagrama de clases UML.
Implemente en Java la funcionalidad requerida.
Pruebas automatizadas
Diseñe los casos de prueba teniendo en cuenta los conceptos de valores de borde y particiones equivalentes vistos en la teoría.
Implemente utilizando JUnit los tests automatizados diseñados en el punto anterior.
