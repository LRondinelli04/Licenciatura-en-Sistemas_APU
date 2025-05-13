{
  El encargado de ventas de un negocio de productos de limpieza desea administrar el stock de los productos que vende. Para ello, genera un archivo maestro donde figuran todos los productos que comercializa. De cada producto se maneja la siguiente información: código de producto, nombre comercial, precio de venta, stock actual y stock mínimo. Diariamente se genera un archivo detalle donde se registran todas las ventas de productos realizadas. De cada venta se registran: código de producto y cantidad de unidades vendidas. Se pide realizar un programa con opciones para:
    a. Actualizar el archivo maestro con el archivo detalle, sabiendo que:
      ● Ambos archivos están ordenados por código de producto.
      ● Cada registro del maestro puede ser actualizado por 0, 1 ó más registros del archivo detalle.
      ● El archivo detalle sólo contiene registros que están en el archivo maestro.
}

(* ACTUALIZACION DE ARCHIVO MAESTRO *)


program Ej2;

type
  producto = record
    codProducto: integer;
    nombre: string;
    precioVenta: real;
    stockActual: integer;
    stockMinimo: integer;
  end;
  archivoMaestro = file of producto;

  ventaDiaria = record
    codProducto: integer;
    cantidadVendida: integer;
  end;
  archivoDetalle = file of ventaDiaria;

var
  regMaestro: producto;
  regDetalle: ventaDiaria;
  archivoMaestro: archivoMaestro;
  archivoDetalle: archivoDetalle;
  totalVendido: integer;

BEGIN
	assign(archivoMaestro, 'maestro'); assign(archivoDetalle, 'detalle');
  reset(archivoMaestro); reset(archivoDetalle);

  while (not eof(archivoDetalle)) do begin
    read(archivoMaestro, regMaestro); read(archivoDetalle, regDetalle);
    
    while (regMaestro.codProducto <> regDetalle.codProducto) do
      read(archivoMaestro, regMaestro);

    
    totalVendido := 0;
    while (not eof(archivoDetalle)) and (regMaestro.codProducto = regDetalle.codProducto) do begin
      totalVendido := totalVendido + regDetalle.cantidadVendida;
      read(archivoDetalle, regDetalle);
    end;
    // Actualizar el stock actual del producto

    regMaestro.stockActual := regMaestro.stockActual - totalVendido;

    seek(archivoMaestro, filepos(archivoMaestro) - 1); // Volver al registro actual
    write(archivoMaestro, regMaestro); // Actualizar el registro en el archivo maestro
  end;
END.

