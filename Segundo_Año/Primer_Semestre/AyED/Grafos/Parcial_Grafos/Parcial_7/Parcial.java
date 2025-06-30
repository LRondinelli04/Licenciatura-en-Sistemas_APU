package Grafos.Parcial_Grafos.Parcial_7;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;

public class Parcial {
    public List<String> tactica(Graph<String> jugadores, String arquero, String delantero, double potencia) {
        List<String> resultado = new ArrayList<>();

        // casos base
        if (jugadores == null || jugadores.getSize() == 0 || arquero == null || delantero == null || potencia <= 0) {
            return resultado; // Retornar una lista vacía
        }
        Vertex<String> verArquero = jugadores.search(arquero);
        Vertex<String> verDelantero = jugadores.search(delantero);
        if (verArquero == null || verDelantero == null) {
            return resultado; // Retornar una lista vacía si no se encuentran los jugadores
        }

        boolean[] visitados = new boolean[jugadores.getSize()];
        List<String> caminoActual = new ArrayList<>();
        dfs(jugadores, verArquero, delantero, potencia, visitados, resultado, caminoActual, 0); // cantidad de
                                                                                                // aristas recorridas

        return resultado;
    }

    public void dfs(Graph<String> jugadores, Vertex<String> actual, String delantero, double potencia,
            boolean[] visitados, List<String> resultado, List<String> caminoActual, double potenciaActual) {
        visitados[actual.getPosition()] = true;
        caminoActual.add(actual.getData());

        if (actual.getData().equals(delantero)) {
            if (potenciaActual / caminoActual.size() >= potencia) {
                resultado.clear();
                resultado.addAll(caminoActual);
            }
            return;
        }

        List<Edge<String>> adyacentes = jugadores.getEdges(actual);
        for (Edge<String> a : adyacentes) {
            Vertex<String> prox = a.getTarget();
            if (!visitados[prox.getPosition()]) {
                // Pasar la nueva potencia sin modificar la variable local
                dfs(jugadores, prox, delantero, potencia, visitados, resultado, caminoActual, potenciaActual + a.getWeight());
            }
        }

        visitados[actual.getPosition()] = false; // desmarcar el vértice actual
        caminoActual.remove(caminoActual.size() - 1);
    }
}
