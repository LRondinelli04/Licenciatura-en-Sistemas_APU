# Ejercicio 19. Servicio de envíos de paquetes
Una empresa de envíos de paquetes ofrece a sus clientes distintos servicios, como envíos locales, interurbanos e internacionales. Los envíos locales son envíos dentro de la misma ciudad y cuentan con una opción de entrega rápida. Los envíos interurbanos son envíos entre ciudades. Los envíos internacionales son envíos a destinos fuera del país. 

De cada envío se registra la fecha en la cual se realiza el despacho, la dirección de origen, la dirección de destino y el peso expresado en gramos. Para los interurbanos además, la distancia expresada en km.
La empresa trabaja con dos tipos de clientes: personas físicas, que son individuos, y clientes corporativos, empresas que tienen un volumen alto de envíos. De las personas físicas, se conoce el nombre, dirección y DNI. De los clientes corporativos se conoce nombre de la empresa, dirección y CUIT.

**Nos piden implementar la siguiente funcionalidad:**
**Agregar un envío para un cliente:** dado un cliente y un envío, se agrega ese envío al cliente indicado.

**Monto a pagar por los envíos realizados dentro de un período:** Se indica el cliente para el cual se quiere calcular el monto y las fechas de inicio y fin del período a considerar. Para calcular el monto total a pagar, se suma el costo de todos los envíos despachados durante el período especificado.
- Los envíos locales tienen un costo fijo de $1000 para las entregas estándar y $500 adicional por entrega rápida . 
- Los envíos interurbanos tienen un costo que depende de la distancia entre el origen y el destino (utilice $20 para menos de 100 km por cada gramo de peso, $25 para distancias entre 100 km y 500 km por gramo de peso, y $30 para distancias de más de 500 km por gramo de peso). 
- Los envíos internacionales tienen un costo que depende del país destino y del peso del paquete. Por ahora, utilice $5000 para cualquier destino y $10 por gramo de peso para envíos de hasta 1 kg y $12 para envíos de más de 1 kg.
Los envíos efectuados por personas físicas tienen un 10% de descuento.

**Tareas:**
Modele e implemente
Diagrama de clases UML.
Implemente en Java la funcionalidad requerida.
Pruebas automatizadas
Diseñe los casos de prueba teniendo en cuenta los conceptos de valores de borde y particiones equivalentes vistos en la teoría.
Implemente utilizando JUnit los tests automatizados diseñados en el punto anterior.
Es probable que los montos utilizados para los cálculos le hayan quedado fijos dentro del código (hardcoded). Piense qué pasaría si al calcular el monto a pagar se proveyera (como un parámetro más) el "cuadro tarifario". ¿Cómo sería ese objeto? ¿Qué responsabilidad le podría delegar? ¿Cómo haríamos para tener montos diferentes para los distintos países en los envíos internacionales según los pesos de los envíos?
