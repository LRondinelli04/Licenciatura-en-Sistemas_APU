package Practica_5.Ejercicios.Ejercicio_04;

import Practica_5.Graph;
import Practica_5.Edge;
import Practica_5.Vertex;
import Practica_5.adjList.*;
import Practica_5.adjMatrix.*;

import java.util.ArrayList;
import java.util.List;

/* Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por un
conjunto de lugares que están restringidos.
Escriba una clase llamada VisitaOslo e implemente su método:
paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) :
List<String> 


En este ejemplo, para llegar desde Ayuntamiento a Museo Vikingo, sin pasar por: {“Akker Brigge”, “Palacio
Real”} y en no más de 120 minutos, el camino marcado en negrita cumple las condiciones.
Notas:
● El “Ayuntamiento” debe ser buscado antes de comenzar el recorrido para encontrar un camino.
● De no existir camino posible, se debe retornar una lista vacía.
● Debe retornar el primer camino que encuentre que cumple las restricciones.
● Ejemplos de posibles caminos a retornar, sin pasar por “Akker Brigge” y “Palacio Real” en no más de
120 min (maxTiempo)
● Ayuntamiento, El Tigre, Museo Munch, Parque Botánico, Galería Nacional, Parque Vigeland,
FolkMuseum, Museo Fram, Museo del Barco Polar, Museo Vikingo. El recorrido se hace en 91
minutos.
● Ayuntamiento, Parque Botánico, Galería Nacional, Parque Vigeland, FolkMuseum, Museo
Fram, Museo del Barco Polar, Museo Vikingo. El recorrido se hace en 70 minutos.
*/

/* 
 * - Recorrido DFS
 * - Controlar: visitados, tiempo acumulado, lugares restringidos y cortar al encontrar el primer camino valido
 * 
 */

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
            List<String> lugaresRestringidos) {
        
        List<String> caminoFinal = new ArrayList<String>();
        List<String> caminoActual = new ArrayList<String>();
        boolean[] visitados = new boolean[lugares.getSize()];
        int tiempoAcumulado = 0;

        int inicio = -1; // indice para buscar el Ayuntamiento
        for (int i = 0; i < lugares.getSize(); i++) {
            if (lugares.getVertex(i).equals("Ayuntamiento")) {
                inicio = i;
                break; // ya encontramos el Ayuntamiento
            }
        }
        if (inicio == -1) { // no se encontró el Ayuntamiento
            return caminoFinal; // retorno la lista vacia
        }

        // Llamo al metodo recursivo para buscar el camino
        dfs(inicio, lugares, visitados, caminoFinal, caminoActual, destino, maxTiempo, lugaresRestringidos,
                tiempoAcumulado);
        return caminoFinal;
    }

    public boolean dfs(int actual, Graph<String> lugares, boolean[] visitados, List<String> caminoFinal,
            List<String> caminoActual, String destino, int maxTiempo, List<String> lugaresRestringidos,
            int tiempoAcumulado) {

        String lugar = lugares.getVertex(actual).getData(); // le paso la data del vertice actual

        // Restricciones
        if (lugaresRestringidos.contains(lugar) || visitados[actual] || tiempoAcumulado > maxTiempo) {
            return false; // si el lugar es restringido o ya fue visitado o el tiempo acumulado es mayor
                          // al maxTiempo, retorno false
        }

        // Agrego el lugar al camino
        caminoActual.add(lugar);
        visitados[actual] = true; // marco el lugar como visitado

        if (lugar.equals(destino)) {
            caminoFinal.addAll(caminoActual); // si llegamos al destino, agrego el camino actual al camino final
            return true; // si llegamos al destino, retorno true
        }
        // Sino, recorro sus adyacentes
        Vertex<String> verticeActual = lugares.getVertex(actual);
        List<Edge<String>> adyacentes = lugares.getEdges(verticeActual);
        for (Edge<String> adyacente : adyacentes) {
            
            int peso = adyacente.getWeight(); // guardar el peso del adyacente
            int proximo = adyacente.getTarget().getPosition(); // obtener el indice del proximo vertice
            tiempoAcumulado += peso; // Actualizo el tiempo acumulado

            if (dfs(proximo, lugares, visitados, caminoFinal, caminoActual, destino, maxTiempo, lugaresRestringidos,
                    tiempoAcumulado)) {
                return true; // si el dfs retorna true, significa que encontramos un camino valido
            }
        }

        // Backtracking
        visitados[actual] = false;
        caminoActual.remove(caminoActual.size() - 1); // quito el ultimo lugar del camino actual
        return false;
    }

}
