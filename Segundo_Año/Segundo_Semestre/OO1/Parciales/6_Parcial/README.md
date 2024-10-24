# Facturación de energía

## Descripción del sistema

En una ciudad nos piden desarrollar un sistema de registro de mediciones y facturación de energía. Hay dos tipos de clientes: clientes residenciales e industrias. El sistema debe ofrecer la siguiente funcionalidad:

- **Dar de alta una persona como nuevo cliente residencial:** Se indica el nombre de la persona, su apellido y el domicilio donde se provee la energía. El sistema registra el nuevo cliente y lo retorna.
- **Dar de alta una industria como nuevo cliente:** Se indica el nombre de la empresa y el domicilio donde se provee la energía. El sistema registra el nuevo cliente y lo retorna.
- **Registrar una medición de consumo de un cliente:** Se indica el cliente y el consumo de energía (un número de unidades de energía). Se indica el mes (del 1 al 12) y el año al que corresponde la medición. El sistema registra la medición.
- **Actualizar el tarifario:** Se indica el precio de la unidad de energía para clientes residenciales y el precio de la unidad de energía para industrias. El sistema actualiza los precios en el tarifario de la empresa.
- **Calcular el monto a facturar a un cliente:** Se indica un cliente, un mes y un año. El sistema obtiene el consumo para ese mes y año (asuma que existe), calcula el monto a facturar a ese cliente por ese mes de ese año, y lo devuelve. El cálculo se efectúa de la siguiente manera:
  - Si el cliente es residencial, se multiplica el consumo de ese mes y año, por el precio de la unidad de energía para clientes residenciales. Además, si el consumo de ese mes y año es menor al consumo del mismo mes del año anterior, se hace un descuento del 10%. Si no hay registro para el mismo mes del año anterior, también se hace el descuento del 10%.
  - Si el cliente es una industria, se multiplica el consumo de ese mes y año por el precio de la unidad de energía para industrias. Además, si el consumo fue inferior al del mes inmediatamente anterior, se hace un descuento del 2%. Si el sistema no dispone de medición para el mes inmediato anterior, no hace el descuento del 2%.

## Entregables

Usted debe producir y entregar:

1. **Diagrama de clases UML** en el que quede claro su diseño.
2. **Implementación en Pharo/Smalltalk** de todas las clases de su diseño.
3. **Expresión de Playground** en la que demuestra lo que debe hacerse para reproducir el caso que se detalla a continuación.

### Caso de ejemplo

- Actualizar el tarifario para que indique $2 por unidad de energía para clientes residenciales, y $1.85 por unidad de energía para industrias.
- Dar de alta como cliente residencial a Omar Amor con dirección Diagonal 80, Nro 2456.
- Dar de alta como cliente industrial a La Sermonisima con dirección comercial en Calle Posadas, Nro 2454.
- Registrar un consumo de 12 unidades, para el mes 4 de 2018, para Omar Amor.
- Registrar un consumo de 414 unidades, para el mes 4 de 2018, para La Sermonisima.
- Obtener el monto a facturar a La Sermonisima por el mes 4 de 2018.

**OBSERVACIÓN:** Sugerimos modelar el mes y el año de un consumo como números separados. Entonces, dado un consumo cuyo mes es 1 y año 2018, el consumo del mes anterior corresponde al mes 12 del 2017 y el consumo del año anterior corresponde al mes 1 del 2017.