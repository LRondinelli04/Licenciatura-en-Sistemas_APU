package Grafos.Parcial_Grafos.Parcial_9;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;
import Grafos.Parcial_Grafos.Parcial_1.Recinto;

public class Parcial {

    public List<String> caminoPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo) {
        List<String> camino = new ArrayList<>();
        if (ciudades == null || ciudades.getSize() == 0 || origen == null || destino == null || montoMaximo <= 0) {
            return camino;
        }

        Vertex<String> vOrigen = ciudades.search(origen);
        Vertex<String> vDestino = ciudades.search(destino);
        if (vOrigen == null || vDestino == null) {
            return camino;
        }

        boolean[] visitados = new boolean[ciudades.getSize()];
        dfs(ciudades, vOrigen, destino, montoMaximo, visitados, camino);
        return camino;
    }

    public boolean dfs(Graph<String> ciudades, Vertex<String> actual, String destino, int monto, boolean[] visitados,
            List<String> camino) {

        camino.add(actual.getData());
        visitados[actual.getPosition()] = true;

        if (actual.getData().equals(destino)) {
            return true;
        }

        List<Edge<String>> adyacentes = ciudades.getEdges(actual);
        for (Edge<String> a : adyacentes) {
            int peso = a.getWeight();
            if (peso <= monto) {
                Vertex<String> prox = a.getTarget();
                if (!visitados[prox.getPosition()]) {
                    if (dfs(ciudades, prox, destino, monto - peso, visitados, camino)) {
                        return true;
                    }
                }
            }

        }

        visitados[actual.getPosition()] = false;
        camino.remove(camino.size() - 1);

        return false;
    }
}
