package Grafos.Parcial_Grafos.ParcialesRepetidos.p1;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.List;
import java.util.ArrayList;

public class ParcialTemaiken {

    public int resolver(Graph<RecintoTemaiken> sitios, int tiempo) {
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

    public int dfs(Graph<RecintoTemaiken> sitios, int indiceActual, int tiempoRestante, boolean[] visitados) {
        RecintoTemaiken RecintoTemaikenActual = sitios.getVertex(indiceActual).getData();
        if (tiempoRestante < RecintoTemaikenActual.getTiempo()) {
            return 0;
        }
        visitados[indiceActual] = true;
        tiempoRestante -= RecintoTemaikenActual.getTiempo();

        int maxRecintoTemaikens = 1; // Contamos el RecintoTemaiken actual

        // recorrer adyacentes
        Vertex<RecintoTemaiken> verticeActual = sitios.getVertex(indiceActual);
        List<Edge<RecintoTemaiken>> adyacentes = sitios.getEdges(verticeActual);
        for (Edge<RecintoTemaiken> adyacente : adyacentes) {
            int pesoArista = adyacente.getWeight();
            if (pesoArista <= tiempoRestante) {
                int proxIndice = adyacente.getTarget().getPosition();
                tiempoRestante -= pesoArista;
                if (!visitados[proxIndice]) {
                    int RecintoTemaikensVisitados = 1 + dfs(sitios, proxIndice, tiempoRestante, visitados);
                    if (RecintoTemaikensVisitados > maxRecintoTemaikens) {
                        maxRecintoTemaikens = RecintoTemaikensVisitados;
                    }
                }
            }
        }

        visitados[indiceActual] = false; // Desmarcar el RecintoTemaiken actual
        return maxRecintoTemaikens; // Retornar 0 porque no se cuenta el RecintoTemaiken actual

    }
}
