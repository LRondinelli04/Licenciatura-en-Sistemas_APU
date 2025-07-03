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
        dfs(reino, verCastillo, aldea, maxPociones, visitados, caminoActual, camino, 0);

        return camino;
    }

    public void dfs(Graph<String> reino, Vertex<String> actual, String aldea, int maxPociones, boolean[] visitados,
            List<String> caminoActual, List<String> camino, int cantPociones) {

        caminoActual.add(actual.getData());
        visitados[actual.getPosition()] = true;

        // Actualizar el mejor camino si el actual es más largo (sin importar si llegamos a la aldea)
        if (caminoActual.size() > camino.size()) {
            camino.clear();
            camino.addAll(caminoActual);
        }

        // Si llegamos a la aldea, no seguimos explorando desde aquí
        if (actual.getData().equals(aldea)) {
            visitados[actual.getPosition()] = false;
            caminoActual.remove(caminoActual.size() - 1);
            return;
        }

        List<Edge<String>> adyacentes = reino.getEdges(actual);
        for (Edge<String> adyacente : adyacentes) {
            cantPociones += adyacente.getWeight();
            if (cantPociones <= maxPociones) {
                Vertex<String> prox = adyacente.getTarget();
                if (!visitados[prox.getPosition()]) {
                    dfs(reino, prox, aldea, maxPociones, visitados, caminoActual, camino, cantPociones);
                }
            }
            cantPociones -= adyacente.getWeight(); // Backtracking de pociones
        }

        visitados[actual.getPosition()] = false; // Desmarcar el vértice como visitado para otras rutas
        caminoActual.remove(caminoActual.size() - 1); // Eliminar el último vértice del camino actual
    }
}
