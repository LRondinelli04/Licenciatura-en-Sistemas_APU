package Grafos.Parcial_Grafos.Parcial_4;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.ArrayList;
import java.util.List;

/*  Una agencia de turismo cuenta con un mapa de ciudades y las distancias entre ellas. Se quiere obtener un camino que comience en una ciudad origen y termine en una ciudad destino y que no pase por las rutas de mas de ciertos kilometros.
    Para el grafo de ejemplo, considerando que el origen es Rio Cuarto, el destino Cordoba y la distancia maxima es 80km, los caminos posibles son> (1) Rio Cuarto - Villa Maria - Cruz del eje y Cordoba, (2) Rio Cuarto - Villa Maria - Jesus Maria - Villa Dolores - Tulumba y Cordoba.
    Implemente en la clase Parcial_4 el metodo:
    ListaGenerica<String> caminoDistanciaMaxima(Grafo ciudades, String origen, String destino, int distanciaMaxima)
*/

/* Codigo que devuelve el primer camino para llegar a un destino desde un origen */

public class Parcial_4 {

    public List<String> caminoDistanciaMaxima(Graph<String> ciudades, String origen, String destino,
            int distanciaMaxima) {
        List<String> camino = new ArrayList<>();

        // analizar los casos base
        if (ciudades == null || ciudades.getSize() == 0 || origen == null || destino == null || distanciaMaxima < 0) {
            return camino; // retornar una lista vacía si hay algún caso base
        }

        // buscar el vertice de origen
        Vertex<String> vOrigen = ciudades.search(origen);
        Vertex<String> vDestino = ciudades.search(destino);
        if (vOrigen == null || vDestino == null) {
            return camino;
        }

        // recorrer el grafo dfs
        boolean[] visitados = new boolean[ciudades.getSize()];
        dfs(camino, ciudades, vOrigen, destino, distanciaMaxima, visitados);
        return camino;
    }

    public boolean dfs(List<String> camino, Graph<String> ciudades, Vertex<String> actual, String destino, int distanciaMaxima,
            boolean[] visitados) {
        String ciudadActual = actual.getData();
        visitados[actual.getPosition()] = true; // marcar la ciudad actual como visitada
        camino.add(ciudadActual); // agregar la ciudad actual al camino

        // si la ciudad actual es el destino, retornar
        if (ciudadActual.equals(destino)) {
            return true;
        }

        // recorrer las ciudades adyacentes que no han sido visitadas y que el peso de
        // la arista no sea mayor que la distancia maxima
        List<Edge<String>> adyacentes = ciudades.getEdges(actual);
        for (Edge<String> adyacente : adyacentes) {
            int peso = adyacente.getWeight();
            if (peso <= distanciaMaxima) {
                Vertex<String> prox = adyacente.getTarget();
                if (!visitados[prox.getPosition()]) {
                    if (dfs(camino, ciudades, prox, destino, distanciaMaxima, visitados)) {
                        return true;
                    }
                }
            }
        }

        // Backtracking
        visitados[actual.getPosition()] = false;
        camino.remove(camino.size() - 1); // o camino.remove(camino.size() - 1);
        return false;
    }

}
