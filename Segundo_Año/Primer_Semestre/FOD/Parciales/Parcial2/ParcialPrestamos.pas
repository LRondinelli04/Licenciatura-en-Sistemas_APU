program ParcialPrestamos;

const
   valorAlto = 9999;
type

   prestamo = record
      numeroSucursal: integer;
      dniEmpleado: integer;
      numeroPrestamo: integer;
      fecha: integer; // año
      monto: real;
   end;
   archivoPrestamos = file of prestamo;


procedure leerPrestamo(var archivo: archivoPrestamos; var p: prestamo);
begin
   if (not eof(archivo)) then
      read(archivo, p);
   else begin
      p.numeroSucursal := valorAlto; // Marca de fin de archivo
   end;
end;

procedure generarInforme(var archivo: archivoPrestamos);
var
   archivoTxt: Text; p: prestamo;
   cantVentasEmpresa, numeroSucursalActual, cantVentasSucursal, dniEmpleadoActual, cantVentasEmpleado, fechaActual, cantVentasFecha: integer;
   totalVentasEmpresa, montoVendidoSucursal, montoVendidoEmpleado, montoVendidoFecha: real;
   
begin
   reset(archivo);
   assign(archivoTxt, 'informe.txt');
   rewrite(archivoTxt);

   totalVentasEmpresa := 0;
   cantVentasEmpresa := 0;

   leerPrestamos(archivo, p);
   writeln(archivoTxt, 'Informe de Ventas de la empresa');
   while (p.numeroSucursal <> valorAlto) do begin
      numeroSucursalActual := p.numeroSucursal;
      cantVentasSucursal := 0;
      montoVendidoSucursal := 0;

      writeln(archivoTxt, 'Sucursal: ', numeroSucursalActual);
      while (p.numeroSucursal = numeroSucursalActual) do begin
         dniEmpleadoActual := p.dniEmpleado;
         cantVentasEmpleado := 0;
         montoVendidoEmpleado := 0;

         writeln(archivoTxt, 'Empleado: DNI ', dniEmpleadoActual);
         while (p.numeroSucursal = numeroSucursalActual) and (p.dniEmpleado = dniEmpleadoActual) do begin
            fechaActual := p.fecha;
            cantVentasFecha := 0;
            montoVendidoFecha := 0;

            while (p.numeroSucursal = numeroSucursalActual) and (p.dniEmpleado = dniEmpleadoActual) and (p.fecha = fechaActual) do begin
               cantVentasFecha := cantVentasFecha + 1;
               montoVendidoFecha := montoVenidodFecha + p.monto;
               leerPrestamo(archivo, p);
            end; // cambio de fecha
            writeln(archivoTxt, 'Año: ', fechaActual, ' Cantidad de ventas: ', cantVentasFecha, ' Monto de ventas: ', montoVendidoFecha);

            cantVentasEmpleado := cantVentasEmpleado + cantVentasFecha;
            montoVendidoEmpleado := montoVendidoEmpleado + montoVendidoFecha;
         end; // cambio de empleado
         writeln(archivoTxt, 'Empleado: DNI ', dniEmpleadoActual, ' Total ventas empleado: ', cantVentasEmpleado, ' Monto total empleado: ', montoVendidoEmpleado);

         cantVentasSucursal := cantVentasSucursal + cantVentasEmpleado;
         montoVendidoSucursal := montoVendidoSucursal + montoVendidoEmpleado;
      end; // cambio de sucursal
      writeln(archivoTxt, 'Cantidad de ventas sucursal: ', cantVentasSucursal, ' Monto total sucursal: ', montoVendidoSucursal);

      totalVentasEmpresa := totalVentasEmpresa + cantVentasSucursal;
      montoVendidoEmpresa := montoVendidoEmpresa + montoVendidoSucursal;
   end; // fin de archivo
   writeln(archivoTxt, 'Cantidad de ventas de la empresa: ', totalVentasEmpresa, ' Monto total vendido por la empresa: ', montoVendidoEmpresa);


   close(archivoTxt);
   close(archivo);
end;

var
   archivoMaestro: archivoPrestamos;
BEGIN
	assign(archivoMaestro, 'prestamos');
   generarInforme(archivoMaestro);
END.

