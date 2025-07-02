package Grafos.Parcial_Grafos.Parcial_8;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;

public class Parcial {

    public List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta,
            List<String> localidadesExceptuadas) {
        List<String> camino = new ArrayList<>();

        // Casos base
        if (grafo == null || grafo.getSize() == 0 || cantLocalidades <= 0 || cantNafta <= 0
                || localidadesExceptuadas.isEmpty()) {
            return camino;
        }

        Vertex<String> mendoza = grafo.search("Mendoza");
        if (mendoza == null) {
            return camino;
        }

        boolean[] visitados = new boolean[grafo.getSize()];
        List<String> caminoActual = new ArrayList<>();
        dfs(grafo, mendoza, cantLocalidades, cantNafta, localidadesExceptuadas, visitados, caminoActual, camino);
        return camino;
    }

    // Devuelve el primer camino valido
    public void dfs(Graph<String> grafo, Vertex<String> actual, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas, boolean[] visitados, List<String> caminoActual, List<String> camino) {

        caminoActual.add(actual.getData());
        visitados[actual.getPosition()] = true;

        if (caminoActual.size() >= cantLocalidades) {
            if (!camino.isEmpty()) {
                camino.addAll(caminoActual);
            }
            return;
        }

        List<Edge<String>> adyacentes = grafo.getEdges(actual);
        for (Edge<String> adyacente : adyacentes) {
            int peso = adyacente.getWeight();
            if (cantNafta >= peso) {
                Vertex<String> prox = adyacente.getTarget();
                if (!visitados[prox.getPosition()] && !localidadesExceptuadas.contains(prox.getData())) {
                    dfs(grafo, prox, cantLocalidades, cantNafta - peso, localidadesExceptuadas, visitados, caminoActual, camino);
                }
            }
        }

        if (!camino.isEmpty()) {
            return;
        }

        visitados[actual.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);

    }

}
