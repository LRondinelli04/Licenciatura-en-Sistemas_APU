{Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. Cada nodo del árbol debe contener el código de producto y la cantidad total vendida.
               Nota: El módulo debe retornar los dos árboles.
b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.
c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.}

program p2;

type 

    // (i)
    venta = record
        codigo: integer;
        fecha: integer;
        cantVendida: integer;
    end;

    arbol = ^nodoArbol;
    nodoArbol = record
        dato: venta;
        HI: arbol;
        HD: arbol;
    end;


    // (ii)
    venta2 = record
        codigos: integer;
        prodVendido: integer;
    end;

    arbol2 = ^nodoArbol2;
    nodoArbol2 = record
        dato: venta2;
        HI: arbol2;
        HD: arbol2;
    end;


procedure generarArbol (a: arbol);

    procedure leerVenta (var v: venta);
    begin
        writeln (' INGRESE EL CODIGO DEL PRODUCTO ');
        readln (v.codigo);
        if (v.codigo <> 0) then begin
            writeln (' INGRESE LA FECHA DEL PRODUCTO ');
            readln (v.fecha);
            writeln (' INGRESE LA CANTIDAD DE VENTAS DE ESE PRODUCTO ');
            readln (v.cantVendida);
        end;
    end;

    procedure agregarEnArbol (var a: arbol ; v: venta);
    begin
        if (a = nil) then begin
            new (a);
            a^.dato:= v;
            a^.HI:= nil;
            a^.HD:= nil;
        end
        else begin
                if (v.codigo < a^.dato.codigo) then begin
                    agregarEnArbol (a^.HI, v);
                end
                else begin
                    agregarEnArbol (a^.HD, v);
                end
            end
    end;

var
    v: venta;
begin
    a:= nil;
    leerVenta (v);
    while (v.codigo <> 0) do begin
        agregarEnArbol (a, v);
        writeln;
        leerVenta (v);
    end;
end;

procedure generarArbol2 (var a2: arbol2);

    procedure leerVenta2 (var v2: venta2);
    begin
        writeln (' INGRESE EL CODIGO DEL PRODUCTO ');
        readln (v2.codigos);
        if (v2.codigos <> 0) then begin
            writeln (' INGRESE LA CANTIDAD DE VENTAS DE ESE PRODUCTO ');
            readln (v2.prodVendido);       
    end;

    procedure insertarEnArbol (var a: arbol2 ; v: venta2);
    begin
        if (a = nil) then begin
            new (a);
            a^.dato:= v;
            a^.HI:= nil;
            a^.HD:= nil;
        end
        else begin
                if (v.codigo < a^.dato.codigo) then begin
                    agregarEnArbol (a^.HI, v);
                end
                else begin
                    agregarEnArbol (a^.HD, v);
                end
            end
    end;

var 
    v2: venta2;
begin
    a2:= nil;
    leerVenta2 (v2);
    while (v2.codigo <> 0) do begin
        insertarEnArbol (a2, v2);
        writeln;
        leerVenta2 (v2);
    end;
end;

var
    a: arbol;
    a2: arbol2;
begin
    generarArbol (a);
    generarArbol2 (a2);
    
end.

