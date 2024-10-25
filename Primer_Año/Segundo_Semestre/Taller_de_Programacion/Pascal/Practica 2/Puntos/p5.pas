{Implementar un módulo que realice una búsqueda dicotómica en un vector, utilizando el siguiente encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra en el vector.
}

program p5;

const   
    dimF = 20;
type

    vector = array [1..dimF] of integer;


procedure generarVector (var v: vector);
    procedure inicializarVector (var v: vector);
    var
        i: integer;
    begin
        for i:= 1 to dimF do begin
            v[i]:= 0;
        end;
    end;


var
    num, i: integer;
begin
    inicializarVector (v);
    for i:= 1 to dimF do begin
        num:= Random (10);
        v[i]:= num;
    end;
end;

{procedure busquedaDicotomica (v: vector ; ini, fin: integer; dato: integer ; var pos: integer);
var
    medio: integer;
begin
    pos:= 0;
    ini:= 1;
    fin:= dimF;
    medio:= ((ini + fin) DIV 2);
    while (ini <= fin) and (dato <> v[medio]) do begin
        if (dato < v[medio]) then begin
            fin:= medio - 1;
        end
        else
            begin
                medio:= ((ini + fin) DIV 2);
            end
    end;
    if (ini <= fin) then begin
        pos:= medio;
    end;

end;}

function BuscarElementoVO ( v:vector; x:integer ): integer;
    var pos,pri,ult,medio: integer;
begin
    pos:=0;
    pri:= 1;
    ult:= dimF;
    medio := (pri + ult ) div 2;
    while (pri <= ult) and ( x <> v[medio]) do begin
        if (x < v[medio]) then ult:= medio-1

        else pri:= medio+1;
            medio:= (pri + ult) div 2;
    end;
{Si no se cruzaron los indices, lo encontré, de lo contrario retorna 0}
    if (pri <= ult) then begin
        pos:= medio;
    end;
    BuscarElementoVO:= pos;
end;


var
    v: vector;
    ini, fin, pos, num: integer;
begin
    Randomize;
    generarVector (v);
    writeln ( ' ingrese el dato a buscar ');
    readln (num);
    pos:= BuscarElementoVO (v, num);
    writeln (pos);
end.