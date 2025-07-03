package Grafos.Parcial_Grafos.Parcial_10;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;
import Grafos.Parcial_Grafos.Parcial_1.Recinto;

public class Parcial {

    public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm) {
        List<String> camino = new ArrayList();

        if (mapaEstadios == null || mapaEstadios.getSize() == 0 || estadioOrigen == null || cantKm <= 0) {
            return camino;
        }

        Vertex<Estadio> verOrigen = null;
        for (int i = 0; i < mapaEstadios.getSize(); i++) {
            if (mapaEstadios.getVertex(i).getData().getNombreEstadio().equals(estadioOrigen)) {
                verOrigen = mapaEstadios.getVertex(i);
                break;
            }
        }

        if (verOrigen == null) {
            return camino;
        }

        boolean[] visitados = new boolean[mapaEstadios.getSize()];
        List<String> caminoActual = new ArrayList<>();
        dfs(mapaEstadios, verOrigen, cantKm, 0, visitados, caminoActual, camino);

        return camino;
    }

    public void dfs(Graph<Estadio> mapaEstadios, Vertex<Estadio> actual, int cantKm, int kmRecorridos, boolean[] visitados, List<String> caminoActual, List<String> camino) {

        caminoActual.add(actual.getData().getNombreEstadio());
        visitados[actual.getPosition()] = true;

        if (caminoActual.size() >= camino.size()) {
            camino.clear();
            camino.addAll(caminoActual);
        }

        List<Edge<Estadio>> adyacentes = mapaEstadios.getEdges(actual);
        for (Edge<Estadio> a : adyacentes) {
            kmRecorridos += a.getWeight();
            if (kmRecorridos <= cantKm) {
                Vertex<Estadio> prox = a.getTarget();
                if (!visitados[prox.getPosition()]) {
                    dfs(mapaEstadios, prox, cantKm, kmRecorridos, visitados, caminoActual, camino);
                }
            }
            kmRecorridos -= a.getWeight(); // backtracking
        }
        
        // backtracking
        visitados[actual.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);

    }
}
