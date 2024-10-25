// PROCESOS PARA VECTORES Y LISTAS

// ---PROCESOS PARA VECTORES---
procedure insertarEnVector (var v: vector; var dimL: integer; var ok: boolean; elem: elemento; pos: integer);
var
    i: integer;
begin
    ok:= false;
    if ((dl + 1) <= dimF) and (pos <= dimL) then begin
        for i:= dimL downto pos do // muevo todos los elementos necesarios una posicion a la derecha para que me quede 1 espacio libre de manera ordenada
            v[i+1]:= v[i];
        ok:= true
        v[pos]:= elem;
        dimL:= dimL + 1;    
    end;
end;

procedure eliminarEnVector (var v: vector; var dimL: integer; var ok: boolean; pos: integer);
var
    i: integer;
begin
    ok:= false;
    if ((pos >= 1) and (pos <= dimL)) then begin
        for i:= pos to (dimL-1) do 
            v[i]:= v[i+1]
        ok:= true;
        dimL:= dimL - 1;
    end;
end;

procedure ordenarVector (var v: vector; dimL: integer);
var
    i,j,p, elem: integer;
begin
    for i:= 1 to (dimL-1) do begin
        p:= i;
        for j:= (i+1) to dimL do begin
            if (v[j] < v[p]) then 
                p:= j;
        end;
        elem:= v[p];
        v[p]:= v[i];
        v[i]:= elem;
    end;
end;

function buscarEnVector (v: vector; dimL: integer; elem: elemento): boolean;
var
    pos: integer;
begin
    pos:= 1;
    while ((pos < dimL) and (v[pos].elem <> elem)) do begin
        pos:= pos + 1
    end;
    if ((pos <= dimL) and (v[pos] = elem)) then 
        buscarEnVector:= true;
    else    
        buscarEnVector:= false;
end;


// ---PROCESOS PARA LISTAS---
procedure agregarAdelante (var l: lista; elem: elemento);
var 
    aux: lista;
begin
    new (aux);
    aux^.dato:= elem;
    aux^.sig:= l;
    l:= aux;
end;

procedure agregarAtras (var l, ult: lista; elem: elemento);
var 
    aux: lista;
begin
    new (aux);
    aux^.dato:= elem;
    aux^.sig:= nil;
    if (l = nil) then begin
        l:= aux;
    end
    else begin
        ult^.sig:= aux;
        ult:= aux;
    end;
end;

function buscar (l: lista; elem: elemento): boolean;
var
    encontre: boolean;
    aux: lista;
begin
    encontre:= false;
    aux:= l;
    while ((aux <> nil) and (encontre  = false)) do begin
        if (aux^.dato = elem) then begin
            encontre:= true;
        end
        else begin
            aux:= aux^.sig;
        end;
    end;
    buscar:= encontre;
end;

procedure insertarEnLista (var l: lista; elem: elemento);
var 
    ant, act, aux: lista;
begin
    new (aux);
    aux^.dato:= elem;
    act:= l;
    while ((act <> nil) and (aux^.dato.elem < elem)) do begin
        ant:= act;
        act:= act^.sig;
    end;
    if (act = l) then begin
        l:= aux;
    end
    else begin
        ant^.sig:= aux;
    end;
    aux^.sig:= act;
end;

// borra todos los elementos que coincidan con elem, en caso de querer borrar el primero hay
// que hacer un variable boolean que inicie en falso y que cuando encuentra el elemento se asigne
// verdadero para poder cortar el while 
procedure eleminar (var l: lista; elem: elemento); 
var
    ant, act: lista;
begin
    act:= l;
    while (act <> nil) do begin
        if (act^.dato.elem <> elem) then begin
            ant:= act;
            act:= act^.sig;
        end
        else begin
            if (act <> nil) then begin
                if (actual = l) then 
                    l:= l^.sig;
                else
                    ant^.sig:= act^.sig;
            end;
        end;
        dipose (act);
        act:= ant;
    end;
end;