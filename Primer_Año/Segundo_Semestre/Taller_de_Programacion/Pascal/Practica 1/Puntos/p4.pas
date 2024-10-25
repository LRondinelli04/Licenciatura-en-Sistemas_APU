{
Una librería requiere el procesamiento de la información de sus productos. De cada producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa modularizado que:
a. Lea los datos de los productos y los almacene ordenados por código de producto y agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza cuando se lee el precio 0.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.
d. Ordene, por precio, los elementos del vector generado en b) utilizando alguno de los dos métodos vistos en la teoría.
e. Muestre los precios del vector ordenado.
}

program p4;

type
    rango = 1..8;

    producto = record
        codigo: integer;
        rubro: rango;
        precio: real;
    end;

    lista = ^nodo;
    nodo = record
        dato: producto;
        sig: lista;
    end;

    vector = array [rango] of lista;


procedure leerProducto (var p: producto);
begin
    writeln (' INGRESE EL CODIGO DEL PRODUCTO: ');
        readln (p.codigo);
    writeln (' INGRESE EL CODIGO DE RUBRO DEL PRODUCTO: ');
        readln (p.rubro);
    writeln (' INGRESE EL PRECIO DEL PRODUCTO: ');
        readln (p.precio);
end;

procedure iniciarVector (var v: vector);
var 
    i: integer;
begin
    for i:= 1 to 8 do begin
      v[i]:= nil;
    end;
end;

procedure insertarOrdenado (var pri: lista ; p: producto);
var 
    ant, nue, act: lista;
begin
    new (nue);
    nue^.dato:= p;
    act:= pri;
    ant:= pri;
    while (act <> nil) and (act^.dato.codigo < p.codigo) do begin
        ant:= act;
        act:= act^.sig;
    end;
    if (act = pri) then
    begin
        pri:= nue;
    end
    else
    begin
        ant^.sig:= nue;
        nue^.sig:= act;
    end;
end;

procedure agregarProducto (var l: lista; p: producto);
var 
    aux: lista;
begin
    new (aux);
    aux^.dato:= p;
    aux^.sig:= l;
    l:= aux;
end;

procedure generarLista (var l: lista);
var 
    p: producto;
begin
    leerProducto (p);
    if (p.precio <> 0) then begin // agrego un producto en lista para poder insertar ordenado
        agregarProducto (l,p);
        l:= l^.sig;
        leerProducto (p);   
        while (l <> nil) and (p.precio <> 0) do begin // empiezo a insertar ordenado
            insertarOrdenado (l,p); 
            l:= l^.sig; 
            leerProducto (p);  
        end;
    end
    else
        begin
            writeln ('--- LA LISTA SE ENCUENTRA VACIA ---');
        end; 
end;

procedure recorrerLista (l: lista);
begin
    while (l <> nil) do begin
        writeln (l^.dato.codigo);
        writeln ('-------------');
        writeln (l^.dato.rubro);
        writeln ('-------------');
        writeln (l^.dato.precio);
        writeln ('-------------');
        l:= l^.sig;
    end;    
end;

procedure cargarVector (var v: vector);
var 
    p: producto;
begin
  leerProducto (p);
  while (p.precio <> 0) do begin
    insertarOrdenado (v[p.rubro], p);
    leerProducto (p);
  end;
end;

procedure imprimirVector (v: vector);
var 
    i: integer;
begin
  for i:= 1 to 8 do begin
    while (v[i] <> nil) do begin
        writeln ('--- RUBRO NUMERO: ', i, ' ---');
        writeln (v[i]^.dato.codigo);
        writeln ('-------------');
        writeln (v[i]^.dato.rubro);
        writeln ('-------------');
        writeln (v[i]^.dato.precio);
        writeln ('-------------');
        v[i]:= v[i]^.sig;
    end;
  end;
end;

var 
    v: vector;
    dimL: integer;
begin
    iniciarVector (v);
    cargarVector (v);
    imprimirVector (v);

end.