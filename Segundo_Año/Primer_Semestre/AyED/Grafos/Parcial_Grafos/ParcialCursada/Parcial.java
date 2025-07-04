package Grafos.Parcial_Grafos.ParcialCursada;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;

public class Parcial {
    public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones) {
        List<String> camino = new ArrayList<>();

        if (reino == null || reino.getSize() == 0 || castillo == null || aldea == null || maxPociones <= 0) {
            return camino; // Retornar una lista vacía
        }

        Vertex<String> verCastillo = reino.search(castillo);
        Vertex<String> verAldea = reino.search(aldea);
        if (verCastillo == null || verAldea == null) {
            return camino; // Retornar una lista vacía si no se encuentran los vértices
        }

        boolean[] visitados = new boolean[reino.getSize()];
        List<String> caminoActual = new ArrayList<>();
        dfs(reino, verCastillo, aldea, maxPociones, visitados, caminoActual, camino);

        return camino;
    }

    public void dfs(Graph<String> reino, Vertex<String> actual, String aldea, int maxPociones, boolean[] visitados,
            List<String> caminoActual, List<String> camino) {

        caminoActual.add(actual.getData());
        visitados[actual.getPosition()] = true;

        if (actual.getData().equals(aldea)) {
            if (caminoActual.size() >= camino.size()) {
                camino.clear();
                camino.addAll(caminoActual);
            }
            // backtracking para seguir buscando caminos posibles que lleguen a la aldea
            visitados[actual.getPosition()] = false;
            caminoActual.remove(caminoActual.size() - 1);
            return;
        }

        List<Edge<String>> adyacentes = reino.getEdges(actual);
        for (Edge<String> adyacente : adyacentes) {
            maxPociones -= adyacente.getWeight();
            if (maxPociones >= 0) {
                Vertex<String> prox = adyacente.getTarget();
                if (!visitados[prox.getPosition()]) {
                    dfs(reino, prox, aldea, maxPociones, visitados, caminoActual, camino);
                }
            }
            maxPociones += adyacente.getWeight(); // Backtracking de pociones
        }

        visitados[actual.getPosition()] = false; // Desmarcar el vértice como visitado para otras rutas
        caminoActual.remove(caminoActual.size() - 1); // Eliminar el último vértice del camino actual
    }
}
