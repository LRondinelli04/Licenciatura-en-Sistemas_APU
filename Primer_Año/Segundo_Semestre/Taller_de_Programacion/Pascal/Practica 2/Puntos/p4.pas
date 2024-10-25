{Escribir un programa que:

a. Implemente un módulo recursivo que genere un vector de 20 números enteros “random” mayores a 0 y menores a 100.
b. Implemente un módulo recursivo que devuelva el máximo valor del vector.
c. Implementar un módulo recursivo que devuelva la suma de los valores contenidos en el vector.
}

program p4;

const   
    dimF = 20;

type

    vector = array [1..dimF] of integer;



procedure generarVector (var v: vector ; var dimL: integer);
var
    num: integer;
begin
    if (dimL < dimF) then begin
        num:= Random (100);
        dimL:= dimL + 1;
        v[dimL]:= num;
        generarVector (v, dimL);
    end;
end;

procedure recorrerVector (v: vector ; dimL: integer);
var
    i: integer;
begin
    for i:= 1 to dimL do begin
        writeln (v[i]);
        writeln;
    end;
end;

function calcularMax (v: vector ; dimL: integer): integer;
    function Max (x, y: integer): integer;
    begin
        if (x >= y) then  begin
            Max:= x;
        end
        else
            begin
                Max:= y;
            end
    end;

begin
    if (dimL = 0) then begin
        calcularMax:= 0;
    end
    else
        begin
            calcularMax:= Max (v[dimL], calcularMax (v,dimL - 1));
        end
end;

function calcularSuma (v: vector ; dimL: integer): integer;
begin
    if (dimL = 0) then begin
        calcularSuma:= 0;
    end
    else
        begin
            calcularSuma:= v[dimL] + calcularSuma(v, dimL - 1);
        end
end;

var
    v: vector;
    dimL, maximo, suma: integer;
begin
    Randomize;
    dimL:= 0;
    generarVector (v, dimL); // (A)
    recorrerVector (v, dimL); // COMPROBACION
    maximo:= calcularMax (v, dimL); // (B)
    writeln (' EL VALOR MAXIMO ES: ', maximo);
    writeln;
    suma:= calcularSuma (v, dimL); // (C)
    writeln (' LA SUMA DE TODOS LOS VALORES ES: ', suma);

end.