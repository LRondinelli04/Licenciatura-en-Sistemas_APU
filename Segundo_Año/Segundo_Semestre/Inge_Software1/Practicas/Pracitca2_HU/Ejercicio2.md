---
# 2. CADENA HOTELERA

---

## 📝 Problema

> Problema 2: Cadena hotelera  
> Se desea automatizar parte del trabajo que se realiza en una cadena hotelera. La empresa ya cuenta con un módulo de registro y seguridad que se encarga del registro de usuarios y del inicio de sesiones por lo que no deben modelarse.  
> Para que un usuario pueda reservar un hospedaje debe ingresar la fecha de ingreso, la cual debe estar dentro de los 90 días a partir de la fecha actual y la fecha de egreso. Las estadías no pueden durar más de 15 días. También debe ingresar el hotel elegido y la cantidad de personas que desean hospedarse. Una vez realizada la reserva, el sistema envía un correo electrónico con un código de reserva y un enlace para continuar con el pago.  
> Para realizar el check in, todos los hoteles cuentan con terminales en las cuales el usuario debe ingresar el código de reserva. Si el código ingresado tiene una reserva para la fecha actual el sistema informa la habitación asignada y manda un mensaje a alguno de los conserjes del hotel para que guíen al usuario hasta la habitación asignada y otro mensaje a los botones para que se hagan cargo de las valijas. Si el código ingresado no es válido, se informará dicha situación. Los check in pueden realizarse después de las 10 am y hasta las 23:59 pm; fuera de ese horario, el sistema debe informar que aún no se encuentran habilitados los ingresos al hotel.  
> Por último los conserjes son los que realizan el check out, para lo cual deben ingresar un número de habitación. Solo se puede realizar check out de habitaciones sin gastos, de lo contrario el sistema deberá informar al conserje que no puede hacerse el check out hasta que no se abonen los gastos realizados. El registro de pago de gastos de una habitación no deberá modelarse en esta etapa. Cuando una habitación es liberada el sistema debe enviar un mensaje a las mucamas del hotel avisando que la habitación puede limpiarse.

---

## 🎯 Objetivo

- **Automatizar reservas y gestión de habitaciones**
- **Facilitar check-in y check-out**
- **Notificar a usuarios y personal del hotel**

---

## 👤 Roles de usuario

- **Usuario** (realiza reservas y check-in)
- **Conserje** (realiza check-out)
- **Mucama** (limpieza de habitaciones)

---

## 📚 Historias de Usuario

- Reservar un hospedaje
- Realizar el check-in
- Realizar el check-out

---

## 🏷️ HU: Reservar un hospedaje

**Reglas de negocio:**
- La fecha de ingreso debe estar dentro de los **90 días** a partir de la fecha actual de reserva y la fecha de egreso
- Las estadías no pueden durar más de **15 días**

### Criterios de aceptación

#### Escenario 1: Reserva exitosa
> **Dado** una reserva con fecha de ingreso 04/09/2025 y de egreso para el 10/09/25, informando también el hotel a reservar con la cantidad de personas ingresantes.  
> **Cuando** el usuario presione el botón para reservar el hospedaje con los datos cargados correctamente.  
> **Entonces** el sistema le va a enviar un correo electrónico con el código de reserva y un enlace para continuar con el pago.

#### Escenario 2: Reserva rechazada por reserva en tiempo indebido
> **Dado** una reserva con fecha de ingreso 01/07/26 y de egreso para el 05/07/26, informando también el hotel a reservar con la cantidad de personas ingresantes.  
> **Cuando** el usuario presione el botón para reservar el hospedaje con los datos correspondientes.  
> **Entonces** el sistema le va a informar "Reserva inválida, la fecha de ingreso/egreso supera el límite de 90 días"

#### Escenario 3: Reserva rechazada por reserva mayor a 15 días
> **Dado** una reserva con fecha de ingreso 04/09/25 y de egreso el 30/04/25, informando también el hotel a reservar con la cantidad de personas ingresantes.  
> **Cuando** el usuario presione el botón para reservar el hospedaje con los datos correspondientes.  
> **Entonces** el sistema le va a informar "Reserva inválida, el tiempo de reserva supera el límite de 15 días"

---

## 🏷️ HU: Realizar el check-in

**Reglas de negocio:**
- El código de ingreso tiene que ser **válido para la fecha**
- El check-in se puede realizar **después de las 10am hasta las 23:59pm**

### Criterios de aceptación

#### Escenario 1: Check-in exitoso
> **Dado** un código de ingreso, con reserva para el hotel en donde se encuentra con la fecha actual  
> **Cuando** el usuario ingrese el código de la reserva en la terminal correspondiente en el hotel, dentro del horario permitido (10am - 23:59pm)  
> **Entonces** el sistema le va a informar al usuario la habitación asignada, va a enviar un mensaje a un conserje para que guíen al usuario a la habitación asignada y otro mensaje a los botones para que se hagan cargo de las valijas.

#### Escenario 2: Check-in fallido por código de ingreso inválido para la fecha actual
> **Dado** un código de ingreso, con reserva para el hotel en donde se encuentra con otra fecha que la actual  
> **Cuando** el usuario ingrese el código de la reserva en la terminal del hotel  
> **Entonces** el sistema le va a informar al usuario con un mensaje que su reserva está prevista para la fecha correspondiente al código de reserva

#### Escenario 3: Check-in fallido por código de ingreso inválido para el hotel presente
> **Dado** un código de ingreso, con reserva para otro hotel en el que se encuentra  
> **Cuando** el usuario ingrese el código de la reserva en la terminal del hotel en la que está ubicado  
> **Entonces** el sistema le va a informar al usuario con un mensaje que su reserva está prevista para otro hotel en el que se encuentra

#### Escenario 4: Check-in fallido por intento fuera del tiempo permitido
> **Dado** un código de ingreso, con reserva para el hotel en donde se encuentra con la fecha actual  
> **Cuando** el usuario ingrese el código de la reserva en la terminal del hotel, por fuera del horario permitido.  
> **Entonces** el sistema le va a informar al usuario que todavía no se encuentran habilitados los ingresos al hotel.

---

## 🏷️ HU: Realizar el check-out

**Reglas de negocio:**
- Solo se puede realizar el check-out de **habitaciones sin gastos**

### Criterios de aceptación

#### Escenario 1: Check-out exitoso
> **Dado** un número de habitación válido y sin gastos  
> **Cuando** el conserje ingrese el número de habitación  
> **Entonces** el sistema va a liberar la habitación y luego le avisará a las mucamas del hotel que está habilitada para limpiar

#### Escenario 2: Check-out fallido por habitación con gastos
> **Dado** un número de habitación válido pero con gastos  
> **Cuando** el conserje ingrese el número de habitación  
> **Entonces** el sistema le va a informar al conserje que no se puede realizar el check-out hasta que se abonen los gastos realizados
