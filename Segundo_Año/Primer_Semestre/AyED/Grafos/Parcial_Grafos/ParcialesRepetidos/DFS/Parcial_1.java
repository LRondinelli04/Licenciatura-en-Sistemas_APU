package Grafos.Parcial_Grafos.ParcialesRepetidos.DFS;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;
import Grafos.Parcial_Grafos.Parcial_1.Recinto;

public class Parcial_1 {
    public int resolver(Graph<Recinto> sitios, int tiempo) {
        // casos base
        if (sitios == null || sitios.getSize() == 0 || tiempo <= 0) {
            return 0;
        }

        Vertex<Recinto> verEntrada = null;
        for (int i = 0; i < sitios.getSize(); i++) {
            if (sitios.getVertex(i).getData().getNombre().equals("Entrada")) {
                verEntrada = sitios.getVertex(i);
                break;
            }
        }

        if (verEntrada == null || verEntrada.getData().getTiempo() > tiempo) {
            return 0;
        }

        boolean[] visitados = new boolean[sitios.getSize()];
        return dfs(sitios, tiempo, verEntrada, visitados);
    }

    public int dfs(Graph<Recinto> sitios, int tiempo, Vertex<Recinto> verActual, boolean[] visitados) {
        if (verActual.getData().getTiempo() > tiempo) {
            return 0;
        }

        visitados[verActual.getPosition()] = true;
        int tiempoRestante = tiempo - verActual.getData().getTiempo();
        int maxRecintos = 1;

        List<Edge<Recinto>> adyacentes = sitios.getEdges(verActual);
        for (Edge<Recinto> adyacente : adyacentes) {
            tiempoRestante -= adyacente.getWeight();
            if (tiempoRestante > 0) {
                Vertex<Recinto> proxVertice = adyacente.getTarget();
                if (!visitados[proxVertice.getPosition()]) {
                    int recintos = 1 + dfs(sitios, tiempoRestante, proxVertice, visitados);
                    if (recintos > maxRecintos) {
                        maxRecintos = recintos;
                    }
                }
            }
            tiempoRestante += adyacente.getWeight();
        }

        visitados[verActual.getPosition()] = false;
        return maxRecintos;
    }
}
