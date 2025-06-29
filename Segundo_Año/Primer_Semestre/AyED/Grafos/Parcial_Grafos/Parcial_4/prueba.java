package Grafos.Parcial_Grafos.Parcial_4;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.ArrayList;
import java.util.List;

/* Una agencia de turismo cuenta con un mapa de ciudades y las distancias entre ellas. Se quiere obtener un camino que comience en una ciudad origen y termine en una ciudad destino y que no pase por las rutas de mas de ciertos kilometros.
Para el grafo de ejemplo, considerando que el origen es Rio Cuarto, el destino Cordoba y la distancia maxima es 80km, los caminos posibles son> (1) Rio Cuarto - Villa Maria - Cruz del eje y Cordoba, (2) Rio Cuarto - Villa Maria - Jesus Maria - Villa Dolores - Tulumba y Cordoba.
Implemente en la clase Parcial_4 el metodo:
ListaGenerica<String> caminoDistanciaMaxima(Grafo ciudades, String origen, String destino, int distanciaMaxima)
*/

/* Codigo que devuelve el primer camino para llegar a un destino desde un origen */

public class prueba {

    public List<String> caminoDistanciaMaxima(Graph<String> ciudades, String origen, String destino,
            int distanciaMaxima) {
        List<String> camino = new ArrayList<>();

        if (ciudades == null || ciudades.getSize() == 0 || origen == null || destino == null || distanciaMaxima < 0) {
            return camino; // retornar una lista vacía si hay algún caso base
        }
        Vertex<String> verticeOrigen = ciudades.search(origen);
        boolean existeDestino = false;
        for (int i = 0; i < ciudades.getSize(); i++) {
            if (ciudades.getVertex(i).getData().equals(destino)) {
                existeDestino = true;
                break;
            }
        }
        if (verticeOrigen == null || existeDestino == false) {
            return camino;
        }
        boolean[] visitados = new boolean[ciudades.getSize()];
        dfs(ciudades, verticeOrigen, destino, distanciaMaxima, visitados, camino);
        return camino;
    }

    public void dfs(Graph<String> ciudades, Vertex<String> vActual, String destino, int distanciaMaxima,
            boolean[] visitados, List<String> camino) {
        visitados[vActual.getPosition()] = true;
        camino.add(vActual.getData());
        if (vActual.getData().equals(destino)) {
            return;
        }

        List<Edge<String>> adyacentes = ciudades.getEdges(vActual);
        for (Edge<String> ad : adyacentes) {
            int pesoArista = ad.getWeight();
            if (pesoArista <= distanciaMaxima) {
                Vertex<String> proxV = ad.getTarget();
                if (!visitados[proxV.getPosition()]) {
                    dfs(ciudades, proxV, destino, distanciaMaxima, visitados, camino);
                }
            }
        }

        visitados[vActual.getPosition()] = false;
        camino.remove(camino.size() - 1);
    }

}
