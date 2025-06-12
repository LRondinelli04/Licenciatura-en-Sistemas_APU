package Grafos.Parcial_Grafos.ParcialesRepetidos;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import Grafos.Parcial_Grafos.Parcial_1.Recinto;

import java.util.List;
import java.util.ArrayList;

public class ParcialTemaiken {

    public int resolver(Graph<Recinto> sitios, int tiempo) {
        // casos bases
        if (sitios == null || sitios.getSize() == 0 || tiempo <= 0) {
            return 0;
        }

        int indiceEntrada = -1;
        for (int i = 0; i < sitios.getSize(); i++) {
            if (sitios.getVertex(i).getData().getNombre().equals("Entrada")) {
                indiceEntrada = i;
                break;
            }
        }
        if (indiceEntrada == -1) {
            return 0; // No hay entrada en el grafo
        }

        boolean[] visitados = new boolean[sitios.getSize()];
        return dfs(sitios, indiceEntrada, tiempo, visitados);
    }

    public int dfs(Graph<Recinto> sitios, int indiceActual, int tiempoRestante, boolean[] visitados) {
        Recinto recintoActual = sitios.getVertex(indiceActual).getData();
        if (tiempoRestante < recintoActual.getTiempo()) {
            return 0;
        }
        visitados[indiceActual] = true;
        tiempoRestante -= recintoActual.getTiempo();

        int maxRecintos = 1; // Contamos el recinto actual

        // recorrer adyacentes
        Vertex<Recinto> verticeActual = sitios.getVertex(indiceActual);
        List<Edge<Recinto>> adyacentes = sitios.getEdges(verticeActual);
        for (Edge<Recinto> adyacente : adyacentes) {
            int pesoArista = adyacente.getWeight();
            if (pesoArista <= tiempoRestante) {
                int proxIndice = adyacente.getTarget().getPosition();
                tiempoRestante -= pesoArista;
                if (!visitados[proxIndice]) {
                    int recintosVisitados = 1 + dfs(sitios, proxIndice, tiempoRestante, visitados);
                    if (recintosVisitados > maxRecintos) {
                        maxRecintos = recintosVisitados;
                    }
                }
            }
        }

        visitados[indiceActual] = false; // Desmarcar el recinto actual
        return maxRecintos; // Retornar 0 porque no se cuenta el recinto actual

    }
}
