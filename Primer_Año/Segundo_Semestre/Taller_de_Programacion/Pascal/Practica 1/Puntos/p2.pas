{El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de las expensas de dichas oficinas. 
Implementar un programa modularizado que:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.}

program p2;
type
    ofi = 1..300;

    oficina = record
        codigo: integer;
        dni: integer;
        valor: real;
    end;

    vector = array [ofi] of oficina;

procedure leerOficina (var o: oficina);
begin
    writeln ('INGRESE EL CODIGO DE OFICINA: ');
    readln (o.codigo);
    if (o.codigo <> -1) then begin
        writeln ('INGRESE EL DNI DEL PROPIETARIO: ');
        readln (o.dni);
        writeln ('INGRESE EL VALOR DE LA EXPENSA: ');
        readln (o.valor);
    end;
end;

procedure generarVector (var v: vector ; var dimL: integer);
var
    dimF: integer;
    o: oficina;
begin
    dimF:= 300;
    leerOficina (o);
    while (o.codigo <> -1) and (dimL <= dimF) do begin
        v[dimL]:= o;
        leerOficina (o);
        dimL:= dimL + 1;
    end;
end;

procedure ordenarVectorSeleccion (var v: vector; dimL: integer);
var 
    i,j,p: integer;
    o: oficina;
begin
    for i:= 1 to dimL - 1 do begin
        p:= i;
        for j:= i + 1 to dimL do begin
          if (v[j].codigo < v[p].codigo) then begin
            p:= j;
          end;
        end;
        o:= v[p];
        v[p]:= v[i];
        v[i]:= o;
    end;
end;

procedure ordenarVectorInsercion (var v: vector; dimL: integer);
var 
    i,j: integer;
    actual: oficina;
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

procedure recorrerVector (v: vector; dimL: integer);
var 
    i: integer;
begin
    for i:= 1 to dimL do begin
        writeln ('-----------');
        writeln (v[i].codigo);
        writeln ('-----------');
        writeln (v[i].dni);
        writeln ('-----------');
        writeln (v[i].valor);
        writeln ('-----------');
    end;
end;


var 
    v: vector;
    dimL: integer;
begin
    dimL:= 1;
    generarVector (v, dimL); // (A)
    ordenarVectorSeleccion (v, dimL); //(B)
    writeln (' LA DIMENSION LOGICA ES: ', dimL-1);
    recorrerVector (v, dimL);
    {ordenarVectorInsercion (v, dimL); // (C)
    recorrerVector (v, dimL);}
end.