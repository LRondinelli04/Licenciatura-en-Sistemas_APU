{1.- Implementar un programa que procese la información de las ventas de productos de un comercio (como máximo 20). 
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 99 unidades).  El ingreso de las ventas finaliza con el código 0 (no se procesa).
a. Almacenar la información de las ventas en un vector. El código debe generarse automáticamente (random) y la cantidad se debe leer. 
b. Mostrar el contenido del vector resultante.
c. Ordenar el vector de ventas por código.
d. Mostrar el contenido del vector resultante.
e. Eliminar del vector ordenado las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Mostrar el contenido del vector resultante.
g. Generar una lista ordenada por código de producto de menor a mayor a partir del vector resultante del inciso e., sólo para los códigos pares.
h. Mostrar la lista resultante.}


program p1;
const   
    dimF = 20;
type
    cod = 1..15;
    vent = 0..99;
    
    venta = record
        codigo: cod;
        cantVendida: vent;
    end;
    
    vector = array [1..dimF] of venta;

    lista = ^nodo;
    nodo = record
        dato: integer;
        sig: lista;
    end;


procedure leerVenta (var ven: venta);
begin
    ven.codigo:= Random(15) + 1;
    ven.cantVendida:= Random (100);
end;


procedure crearVector (var v: vector ; var dimL: integer);
var
    ven: venta;
begin
    leerVenta (ven);
    while (dimL < dimF) and (ven.cantVendida <> 0) do begin
        v[dimL]:= ven;
        dimL:= dimL + 1;
        leerVenta (ven);
    end;
end;


procedure ordenarVector (var v: vector; dimL: integer);
var 
    i,j: integer;
    actual: venta;
begin
    for i:= 2 to dimL do begin
        actual:= v[i];
        j:= i - 1;
        while (j > 0) and (v[j].codigo > actual.codigo) do begin
            v[j + 1]:= v[j];
            j:= j - 1;
        end;
        v[j + 1]:= actual;
    end;
end;

procedure comprobarVector (v: vector; dimL: Integer);
var
    i: integer;
begin
    for i:= 1 to dimL do begin
        writeln ('codigo: ', v[i].codigo);
        writeln ('-------------------');
        writeln ('cantidad vendida: ', v[i].cantVendida);
        writeln ('-------------------');
    end;
end;

procedure cargarRango (var min: integer; var max: integer);
begin
    writeln (' INGRESE UN VALOR MINIMO ENTRE 1 Y 15');
    read (min);
    writeln (' INGRESE UN VALOR MAXIMO ENTRE 1 Y 15 ');
    read (max);  
end;

procedure elimiarDatos (v: vector ; var dimL: integer ; var v2: vector);
var 
    i, j, min, max: integer;
begin
    cargarRango (min, max);
    for i:= min to max do begin
      for j:= i to dimF - 1 do begin
         v2[j]:= v[j + 1];  
      end;
      dimL:= dimL - 1;
    end;
end;

procedure agregarEnLista (var l: lista ; codigo: integer);
var 
    aux: lista;
begin
    new (aux);
    aux^.dato:= codigo;
    aux^.sig:= l;
    l:= aux;
end;
procedure generarLista (var l: lista; v: vector ; dimL: integer);
var
    i: integer;
begin
    i:= 1;
    while (l <> nil) and (i <= dimL)do begin
        if (v[i].codigo MOD 2 = 0) then begin //CALCULO CODIGO PAR 
            agregarEnLista (l, v[i].codigo);
            i:= i + 1
        end;
        l:= l^.sig;
    end;
end;

procedure recorrerLista (l: lista);
begin
    while (l <> nil) do begin
      writeln ('------------');
      writeln ('codigo: ', l^.dato);
      writeln ('------------');
      l:= l^.sig;
    end;
end;

var
    v, v2: vector;
    dimL, dimL2: integer;
    l: lista;
begin
    dimL:= 0;
    crearVector (v, dimL); //lee ventas hasta que la cantidad de estas sea 0// (A)
    comprobarVector (v,dimL); //muestra de codigo// (B)
    ordenarVector (v, dimL); // (C)
    writeln ('--------VECTOR ORDENADO--------');
    comprobarVector (v, dimL); // (D)
    writeln ('DIML: ', dimL);
    dimL2:= dimL;
    elimiarDatos (v, dimL2, v2); // (E) // creo que hay que corregir el eliminar //
    comprobarVector (v2, dimL); // (F)
    writeln ('DIML2 NUEVO: ', dimL2); // compruebo cuantos eliminar hubo //
    l:= nil; // inicializo lista
    generarLista (l, v, dimL); //HACER UNA LISTA CON EL VECTOR ORDENADO Y SOLO CON LOS CODIGOS PARES
    writeln ('---LISTA NUEVA---');
    recorrerLista (l); //NO RECORRE LA LISTA?
end.