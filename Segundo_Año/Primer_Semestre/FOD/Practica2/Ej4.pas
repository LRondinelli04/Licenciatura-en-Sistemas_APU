{
   Se cuenta con un archivo de productos de una cadena de venta de alimentos congelados.
De cada producto se almacena: código del producto, nombre, descripción, stock disponible,
stock mínimo y precio del producto.
Se recibe diariamente un archivo detalle de cada una de las 30 sucursales de la cadena. Se
debe realizar el procedimiento que recibe los 30 detalles y actualiza el stock del archivo
maestro. La información que se recibe en los detalles es: código de producto y cantidad
vendida. Además, se deberá informar en un archivo de texto: nombre de producto,
descripción, stock disponible y precio de aquellos productos que tengan stock disponible por
debajo del stock mínimo. Pensar alternativas sobre realizar el informe en el mismo
procedimiento de actualización, o realizarlo en un procedimiento separado (analizar
ventajas/desventajas en cada caso).
Nota: todos los archivos se encuentran ordenados por código de productos. En cada detalle
puede venir 0 o N registros de un determinado producto.
   
   
}

(* MERGE DE UN ARRAY DE ARCHIVOS DETALLES EN UN ARCHIVO DE PRODUCTOS MAESTRO (CON INFORMACION PREVIAMENTE CARGADA) *)

(* 

   Paso a paso:
   1. Abrir todos los archivos
      - Abrir el archivo maestro en modo lectura/escritura.
      - Abrir los 30 archivos detalles en moodo lectura.
   2. Leer el primer registro de cada archivo detalle.
      - Usar el array de registros para almacenar el registro actual de cada archivo detalle.
      - Si un archivo esta vacio, asignar un valor alto al registro correspondiente.
   3. Buscar el menor codigo de producto entre los 30 detalles
      - Comparar los 30 registros actuales y elegir el de menor codigo de producto.
      - Este es el producto que se va a actualizar en el maestro.
   4. Acumular la cantidad vendida de ese producto.
      - Sumar la cantidad vendida de todos los archivos detalles que tengan ese codigo de producto.
      - Cada vez que sumo, leo el siguiente registro de ese archivo detalle, hasta que el archivo detalle esté vacio.
   5. Actualizar el maestro
      - Leer el maestro hasta encontrar el producto con ese codigo.
      - Actualizar la cantidad total vendida al stock disponible.
   6. Repetir
      - Volver al paso 3 hasta que todos los archivos detalle hayan llegado al final.

 *)

program Ej4;
const
   valorAlto = 999999; 
   sucursales = 30; 
type
   producto = record
     codProducto: integer;
     nombre: string;
     descripcion: string;
     stockDisponible: integer;
     stockMinimo: integer;
     precio: real;
   end;
   archivoMaestro = file of producto;

   ventaDiaria = record
     codProducto: integer;
     cantidadVendida: integer;
   end;
   archivoDetalle = file of ventaDiaria;
   registroDetalles = array[1..sucursales] of archivoDetalle; // 30 sucursales
   registrosDetalles = array[1..sucursales] of ventaDiaria; // 30 registros de detalles

procedure leer(var archivo: archivoDetalle; var dato: ventaDiaria);
begin
   if (not eof(archivo)) then
      read(archivo, dato)
   else 
      dato.codProducto := valorAlto; // Asignar un valor alto al registro si el archivo detalle está vacío
end;

procedure minimo(var det: registrosDetalles; var min: ventaDiaria; var totalVendido: integer);
begin 
   min := valorAlto;
   // Buscar el menor codigo de producto entre los detalles
   for i := 1 to sucursales do begin
      if (det[i].codProducto < min.codProdcuto) then begin
         min := det[i];
      end;
   end;

   // Acumular la cantidad vendida de ese producto
   totalVendido := 0;
   // Sumar la cantidad vendida de todos los archivos detalles que tengan ese codigo de producto
   for i := 1 to sucursales do begin
      if (det[i].codProduto = min.codProducto) then begin
         totalVendido := totalVendido + det[i].cantidadVendida;
      end;
   end;
end;


procedure actualizarMaestro(var maestro: archivoMaestro; var detalles: registroDetalles);
var
   regDetalle: registroDetalles;
   totalVendido: integer;
   regMaestro: producto;
begin
   // Abrir todos los archivos detalles y leer el primer registro de cada uno
   for i := 1 to sucursales do begin
      reset(detalles[i]); // abrir el archivo detalle en modo lectura
      leer(detalles[i], regDetalle[i]); // leer el primer registro
   end;
   // Leer el primer registro del maestro
   reset(maestro);

   repeat
      minimo(regDetalle, min, totalVendido);
      if (min <> valorAlto) then begin
         // Buscar el producto en el maestro
         while (not eof(maestro)) do begin
            read(maestro, regMaestro);
            if regMaestro.codProducto = min.codProducto then begin
               // Actualizar el stock disponible
               regMaestro.stockDisponible := regMaestro.stockDisponible - totalVendido;
               seek(maestro, filepos(maestro) - 1); // Volver al registro actual
               write(maestro, regMaestro); // Actualizar el registro en el maestro
               break; // Salir del bucle una vez que se actualiza el registro
            end;
         end;

         // Leer el siguiente registro de cada archivo detalle
         for i := 1 to sucursales do begin
            if (regDetalle[i].codProducto = min.codProdcuto) then begin
               leer(detalles[i], regDetalle[i]); // leer el siguiente registro
            end;
         end;

         reset(maestro); // Volver al inicio del maestro para la siguiente iteracion
      end;
   until min = valorAlto;

   // Cerrar todos los archivos detalles
   for i := 1 to sucursales do begin
      close(detalles[i]);
   end;
   close(maestro); // Cerrar el maestro

end;


BEGIN
	(* ... *)
END.

