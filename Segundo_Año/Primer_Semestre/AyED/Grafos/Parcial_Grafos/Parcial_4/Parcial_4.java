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

public class Parcial_4 {

    public List<String> caminoDistanciaMaxima(Graph<String> ciudades, String origen, String destino,
            int distanciaMaxima) {
        List<String> camino = new ArrayList<>();

        // analizar los casos base
        if (ciudades == null || ciudades.getSize() == 0 || origen == null || destino == null || distanciaMaxima < 0) {
            return camino; // retornar una lista vacía si hay algún caso base
        }

        // buscar el vertice de origen
        int indiceOrigen = -1;
        for (int i = 0; i < ciudades.getSize(); i++) {
            if (ciudades.getVertex(i).getData().equals(origen)) {
                indiceOrigen = i;
            }
            // verificar que el destino existe
        }
        if (indiceOrigen == -1) {
            return camino;
        }

        // recorrer el grafo dfs
        boolean[] visitados = new boolean[ciudades.getSize()];
        dfs(camino, ciudades, indiceOrigen, destino, distanciaMaxima, visitados);
        return camino;
    }

    public void dfs(List<String> camino, Graph<String> ciudades, int indice, String destino, int distanciaMaxima, boolean[] visitados) {
        String ciudadActual = ciudades.getVertex(indice).getData();
        visitados[indice] = true; // marcar la ciudad actual como visitada
        camino.add(ciudadActual); // agregar la ciudad actual al camino

        // si la ciudad actual es el destino, retornar
        if (ciudadActual.equals(destino)) {
            return;
        }

        // recorrer las ciudades adyacentes que no han sido visitadas y que el peso de la arista no sea mayor que la distancia maxima
        Vertex<String> verticeActual = ciudades.getVertex(indice);
        List<Edge<String>> adyacentes = ciudades.getEdges(verticeActual);
        for(Edge<String> adyacente : adyacentes) {
            int peso = adyacente.getWeight();
            int proxIndice = adyacente.getTarget().getPosition();
            if(!visitados[proxIndice] && peso <= distanciaMaxima) {
                dfs(camino, ciudades, proxIndice, destino, distanciaMaxima, visitados);;
            }
        }

        visitados[indice] = false;
        camino.removeLast(); // o camino.remove(camino.size() - 1);
    }

}
