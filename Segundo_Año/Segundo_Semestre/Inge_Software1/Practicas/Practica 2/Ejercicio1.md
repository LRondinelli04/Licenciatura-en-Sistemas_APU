---
# 1. ALQUILER DE MOBILIARIO

---

## 📝 Problema

> Problema 1: Alquiler de mobiliario
> Suponga que trabaja en una consultora la cual ha sido recientemente contactada por una empresa de alquiler de mobiliario para eventos para la realización de una app.
> De las diferentes entrevistas se ha obtenido la siguiente información:
> El gerente nos dijo que resulta fundamental tener una aplicación móvil que nos permita manejar la agenda de la empresa, sabiendo qué disponibilidad tenemos y permitiendo que nuestros clientes alquilen a través de la app. Para esta primera versión de la app, el gerente nos pidió que sea posible dar de alta los diferentes mobiliarios, así como la posibilidad de que los usuarios puedan realizar una reserva de alquiler desde sus dispositivos. Para el detalle de cómo se realiza la carga de los muebles, el gerente nos sugirió hablar con el encargado del departamento de mobiliario. El encargado de mobiliario nos comentó que de cada mueble se debe cargar código de inventario, tipo de mueble, fecha de creación, fecha de último mantenimiento, estado (libre, de baja, alquilado) y el precio de alquiler. Además, no pueden existir códigos repetidos. Para que el encargado pueda dar de alta el mobiliario debe autenticarse en el sistema. El registro de los usuarios de carga no debe modelarse.
> El encargado del departamento de alquileres no comentó acerca de las reservas de los alquileres. Por una política comercial de la marca una reserva tiene que incluir como mínimo 3 muebles. La reserva debe tener una fecha, lugar del evento, cantidad de días y mobiliario junto a su cantidad. Para realizar una reserva se debe abonar el 20% del total del alquiler. El pago de la reserva se realiza únicamente con tarjeta de crédito validando número de tarjeta y fondos a través de un servicio del banco. Luego de efectuado el pago, se emite un número de reserva único que será luego utilizado por el cliente para hacer efectivo el alquiler.


---

## 🎯 Objetivo

- **Manejar la agenda de la empresa**
- **Mostrar disponibilidad**
- **Permitir alquileres desde la app**

---

## 👤 Roles de usuario

- **Encargado** (da de alta mobiliarios)
- **Usuario** (realiza reservas)

---

## 📚 Historias de Usuario

- Dar de alta diferentes mobiliarios
- Usuarios puedan reservar alquileres

---

## 🏷️ HU: Alta mobiliario

**Reglas de negocio:**
- No pueden existir **códigos repetidos**
- El encargado debe **autenticarse** en el sistema

### Criterios de aceptación

#### Escenario 1: Alta exitosa
> **Dado** el inmueble con código 1 no registrado, tipo armario, fecha de creación 20/12/12, fecha de último mantenimiento 20/12/21, estado libre y precio 1.000.000  
> **Cuando** el gerente se autentique y luego ingrese los datos y presione "Dar de alta"  
> **Entonces** el sistema mostrará un mensaje de éxito

#### Escenario 2: Alta fallida por código repetido
> **Dado** el inmueble con código 1 ya registrado  
> **Cuando** el gerente se autentique y presione "Dar de alta"  
> **Entonces** el sistema mostrará un mensaje de error por código repetido

#### Escenario 3: Alta fallida por gerente no autenticado
> **Dado** el inmueble con código 1 no registrado  
> **Cuando** el gerente/usuario no autenticado presione "Dar de alta"  
> **Entonces** el sistema mostrará un error de autenticación

---

## 🏷️ HU: Reserva de alquileres

**Reglas de negocio:**
- La reserva debe incluir **mínimo 3 inmuebles**
- Para reservar se debe abonar un **20% del total**
- Se puede abonar únicamente con **tarjeta de crédito** validando fondos y número

### Criterios de aceptación

#### Escenario 1: Reserva exitosa
> **Dado** una reserva con fecha 20/12/21, lugar de evento "La Plata", cantidad de días 10 y una cantidad de mobiliarios de 4  
> **Cuando** el usuario valide el número de su tarjeta de crédito y los fondos a través de un servicio de banco, abone el 20% del total del alquiler  
> **Entonces** el sistema le va a emitir un número de reserva único

#### Escenario 2: Reserva fallida por no incluir mínimo 3 inmuebles
> **Dado** una reserva con solo 2 mobiliarios  
> **Cuando** el usuario intente abonar el 20% del total  
> **Entonces** el sistema le va a mostrar un mensaje de error por falta de mobiliarios mínimos

#### Escenario 3: Reserva fallida por no validación de tarjeta
> **Dado** una reserva válida  
> **Cuando** el usuario quiera abonar el 20% de la reserva sin validar la tarjeta  
> **Entonces** el sistema le va a mostrar un mensaje de pago fallido por falta de validación de tarjeta

    Dado una reserva con fecha 20/12/21, lugar de evento "La Plata", cantidad de días 10 y una cantidad de mobiliarios de 2.
    Cuando el usuario quiera abonar el 20% de la reserva sin validar la tarjeta del alquiler con reserva 20/12/21, lugar de evento "La Plata", cantidad de días 10 y una cantidad de mobiliarios de 2.
    Entonces el sistema le va a mostrar un mensaje de pago fallido por falta de validación de tarjeta
