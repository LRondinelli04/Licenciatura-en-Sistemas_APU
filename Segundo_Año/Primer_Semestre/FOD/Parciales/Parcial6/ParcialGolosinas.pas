program ParcialGolosinas;
const
   cantSucursales = 20;
   valorAlto = 999999;
type
   producto = record
      codigo: integer;
      nombreComercial: string;
      precio: real;
      stockActual: integer;
      stockMinimo: integer;
   end;
   archivoProducto = file of producto;

   ventaDiaria = record
      codigo: integer;
      cantVendida: integer;
   end;
   archivoProductoDetalle = file of ventaDiaria;
   arraySucursal = array[1..cantSucursales] of archivoProductoDetalle;
   arraySucursalReg = array[1..cantSucursales] of ventaDiaria;

procedure leerVenta(var archivo: archivoProductoDetalle; var reg: ventaDiaria);
begin
   if (not eof(archivo)) then begin
      read(archivo, reg);
   end else begin
      reg.codigo := valorAlto; // asigno un valor alto para indicar el final del archivo
   end;
end;

procedure minimo(var vDiaria: arraySucursalReg, var minVenta: ventaDiaria; var indiceMinimo: integer);
var
   i: integer;
begin
   minVenta.codigo := valorAlto;
   for i := 1 to cantSucursales do begin
      if (vDiaria[i].codigo < minVenta.codigo) then begin
         minVenta := vDiaria[i];
         indiceMinimo := i;
   end;
end;

procedure procesarArchivos(var archivoProductos: archivoProducto; var arrayVentas: arraySucursal, var vDiaria: arraySucursalReg);
var
   regProducuto: producto;
   texto: TEXT;
   minVenta: ventaDiaria;
   totalVendido, indiceMinimo: integer;
begin
   assign(texto, 'productosVendidos.txt');
   rewrite(texto); 

   // calculo el minimo de cada archivo de ventas
   minimo(vDiaria, minVenta, indiceMinimo); // paso el array, devuelvo la venta minima y el indice del archivo en el que me quede
   while (minVenta.codigo <> valorAlto) do begin
      // leo del maestro hasta encontrar el producto
      read(archivoProductos, regProducto);
      while (archivoProductos.codigo < minVenta.codigo) do begin
         read(archivoProductos, regProducto);
      end;
      totalVendido := 0;
      while (regProducto.codigo = minVenta.codigo) do begin
         regProducto.stockActual := regProducto.stockActual - minVenta.cantVendida;
         totalVendido := totalVendido + minVenta.cantVendida;

         leerVenta(arrayVentas[indiceMinimo], vDiaria[indiceMinimo]);
         minimo(vDiaria, minVenta, indiceMinimo); // vuelvo a calcular el minimo

         if (regProducto.codigo <> minVenta.codigo ) do
            break;
      end;
      if (regProducto.precio * totalVendido > 10000) then begin
         writeln(texto, 'Producto: ', regProducto.nombreComercial, 
                  ' - Codigo: ', regProducto.codigo, 
                  ' - Cantidad Vendida: ', totalVendido, 
                  ' - Stock Actual: ', regProducto.stockActual,
                  ' - Stock Minimo: ', regProducto.stockMinimo
                );
      end;

      seek(archivoProductos, filepos(archivoProductos) -1);
      write(archivoProductos, regProducto);
   end;
   close(texto); 
end;
var
   archivoProductos: archivoProducto; arrayVentas: arraySucursal;
   vDiaria: arraySucursalReg;
   i: integer;
BEGIN
	// actualizar el maestro con el stock correspondiente
   // informar en un archivo de texto los productos que el monto total vendido en el dia supero los 10.000 (informar toda la info)
	assign(archivoProductos, 'productos');
   reset(archivoProductos);
   for i:= 1 to cantSucursales do begin
      assign(arrayVentas[i], 'ventasSucursal' + IntToStr(i)); // asigno cada archivo
      reset(arrayVentas[i]); // los abro para leer
      leerVenta(arrayVentas[i], vDiaria[i]); // leo los registros de ventas en vDiaria
   end;

   procesarArchivos(archivoProductos, arrayVentas, vDiaria);
   close(archivoProductos);
   for i := 1 to cantSucursales do begin
      close(arrayVentas[i]); // cierro cada archivo de ventas
   end;
END.

