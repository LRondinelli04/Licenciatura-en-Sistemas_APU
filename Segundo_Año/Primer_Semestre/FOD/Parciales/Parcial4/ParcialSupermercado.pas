program ParcialSupermercado;
const

type
   producto = record
      codigo: integer;
      nombre: string;
      descripcion: string;
      precioCompra: real;
      precioVenta: real;
      ubicacionDeposito: string;
   end;
   archivoMaestro = file of producto;

procedure ingresarProducto(var maestro: archivoMaestro; var prod: producto);
begin
   writeln('Ingrese los datos del producto: ');
   writeln();
   wirteln('Codigo:');
   readln(prod.codigo);
   if (existeProducto(maestro, prod.codigo) = false) then begin
      writeln('Nombre:');
      readln(prod.nombre);
      writeln('Descripcion:');
      readln(prod.descripcion);
      writeln('Precio de compra:');
      readln(prod.precioCompra);
      writeln('Precio de venta:');
      readln(prod.precioVenta);
      writeln('Ubicacion del deposito:');
      readln(prod.ubicacionDeposito);
   end
   else begin
      writeln('El producto ya existe en el maestro.');
      prod.codigo := -1; // Indicar que no se debe agregar
   end;
end;

procedure agregarProducto(var maestro: archivoMaestro);
var
   prod: producto;
begin
   reset(maestro);
   
   ingresarProducto(maestro, prod);
   if (prod.codigo <> -1) then begin
      seek(maestro, filesize(maestro));
      write(maestro, prod);
      writeln('Producto agregado exitosamente.');
   end;
   close(maestro);
end;

procedure quitarProducto(var maestro: archivoMaestro);
var
   prod: producto;
   codigo: integer;
begin
   reset(maestro);
   writeln('Ingrese el codigo del producto a eliminar:');
   readln(codigo);
   if (existeProducto(maestro, codigo)) then begin
      while (not eof(maestro)) do begin
         read(maestro, prod);
         if (prod.codgio = codigo) then begin // si encuentro el producto lo elimino
            seek(maestro, filepos(maestro) -1);
            prod.codigo := -1;
            write(maestro, prod);
            writeln('Producto eliminado exitosamente.');
            break;
         end;
      end;
   end;

   close(maestro);
end;

var
   maestro: archivoMaestro;
BEGIN
	assign(maestro, 'maestro');
   agregarProducto(maestro);
   quitarProducto(maestro);
END.

