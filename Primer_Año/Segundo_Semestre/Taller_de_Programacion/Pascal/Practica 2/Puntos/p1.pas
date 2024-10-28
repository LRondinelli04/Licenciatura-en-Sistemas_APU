{
Implementar un programa que invoque a los siguientes módulos.

a. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y los almacene en un vector con dimensión física igual a 10.

b. Implementar un módulo que imprima el contenido del vector.

c. Implementar un módulo recursivo que imprima el contenido del vector.

d. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y retorne la cantidad de caracteres leídos.

El programa debe informar el valor retornado.

e. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y retorne una lista con los caracteres leídos.

f. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los valores de la lista en el mismo orden que están almacenados.

g. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los valores de la lista en orden inverso al que están almacenados.


}

program p1;

const   
    dimF = 10;
type


    vector = array [1..dimF] of string;

    lista = ^nodo;
    nodo = record   
        dato: char;
        sig: lista;
    end;


procedure iniciarVector (var v: vector);
var 
    i: integer;
begin
    for i:= 1 to dimF do begin
      v[i]:= '.';
    end;
end;

procedure leerCaracteres (var v: vector ; var dimL: integer);
var 
    c: string;
begin
    if (dimL <  dimF) then begin
    write (' INGRESE UN CARACTER QUE TERMINE EN . : ');
    readln (c);
    dimL:= dimL + 1;
    v[dimL]:= c;
    leerCaracteres (v, dimL);
  end;
end;

procedure imprimirVector (v: vector ; dimL: integer);
var
    i: integer;
begin
  for i:= 1 to dimL do begin
    write ('--- CARACTER DE LA POSICION ', i, ': ', v[i]);
    writeln ('---');
  end;
end;

procedure imprimirVectorRecursivo (v: vector ; dimL: integer ; var dimL2: integer);
var
    car: integer;
begin
    if (dimL2 < dimL) then begin
        dimL2:= dimL2 + 1;
        car:= Length(v[dimL2]);
        writeln ('-------------------------------------');
        writeln (' CARACTER DE LA POSICION ', dimL2, ': ', v[dimL2]);
        writeln (' ');
        writeln (' CANTIDAD DE CARACTERES: ', car);        
        writeln ('-------------------------------------');
        imprimirVectorRecursivo (v, dimL, dimL2);
  end;
end;



procedure cargarListaRecursivo (var l: lista; var dimL2: integer);
    
    procedure agregarEnLista (caracter: char ; var l: lista);
    var 
        aux: lista;
    begin
        new (aux);
        aux^.dato:= caracter;
        aux^.sig:= l;
        l:= aux;
    end;


var 
    caracter: char;
begin
    write (' INGRESE UN CARACTER: ');
    readln (caracter);
    if (caracter <> '.') then begin
        agregarEnLista (caracter, l);
        dimL2:= dimL2 + 1;
        cargarListaRecursivo (l, dimL2);
    end;
end;

procedure imprimirLista (l: lista);
begin
  if (l <> nil) then begin
        imprimirLista (l^.sig);
        write (l^.dato, ' | ');
  end;
end;

{
function contarCaracteres (): integer;
var
    caracter: char;
begin
    write (' INGRESE UN CARACTER: ');
    readln (caracter);
    if (caracter <> '.') then begin
        contarCaracteres:= contarCaracteres() + 1;
    end
    else
    begin
        contarCaracter:= 0;
    end;
end;

}


{procedure ImprimirListaOrdenInverso (l: lista);
begin
  if (l<> nil) then begin
        write (l^.dato, ' | ');
        ImprimirListaOrdenInverso (l^.sig);
  end;
end;}

var
    v: vector;
    dimL, dimL2: integer;
    l: lista;
begin
    dimL:= 0;
    iniciarVector (v);
    leerCaracteres (v, dimL); // (A)
    {imprimirVector (v, dimL); // (B)}
    dimL2:= 0;
    imprimirVectorRecursivo (v, dimL, dimL2); // (C) y (D) // imprimo de manera recursiva y a su vez cuento la cantidad de caracteres que hay en cada POS del vector
    dimL2:= 0;
    l:= nil;
    cargarListaRecursivo (l, dimL2);
    writeln ('--- LISTA ---');
    imprimirLista (l); // corregir //



end.