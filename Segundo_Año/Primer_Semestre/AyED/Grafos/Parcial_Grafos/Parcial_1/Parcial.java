package Grafos.Parcial_Grafos.Parcial_1;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.List;

public class Parcial {
    public int resolver(Graph<Recinto> sitios, int tiempo) {

        // Comprobar casos bases
        if (sitios == null || sitios.getSize() == 0 || tiempo <= 0) {
            return 0; // No hay sitios o el tiempo es inválido
        }

        // Buscar la entrada
        int entradaIndex = -1;
        for (int i = 0; i < sitios.getSize(); i++) {
            if (sitios.getVertex(i).getData().getNombre().equals("Entrada")) {
                entradaIndex = i;
                break;
            }
        }

        // Si no se encuentra la entrada, retornar 0
        if (entradaIndex == -1) {
            return 0;
        }
        // Si el tiempo que tenemos es menor al tiempo de la entrada, retornar 0
        if (tiempo < sitios.getVertex(entradaIndex).getData().getTiempo()) {
            return 0;
        }

        boolean[] visitados = new boolean[sitios.getSize()];
        return dfs(sitios, entradaIndex, tiempo, visitados);
    }

    public int dfs(Graph<Recinto> sitios, int actual, int tiempoRestante, boolean[] visitados) {
        Recinto recintoActual = sitios.getVertex(actual).getData();
        int tiempoRecinto = recintoActual.getTiempo();
        if (tiempoRestante < tiempoRecinto) {
            return 0; // No hay tiempo suficiente para visitar este recinto
        }

        visitados[actual] = true; // Marcamos el recinto actual como visitado
        int maxRecintos = 1;

        Vertex<Recinto> verticeActual = sitios.getVertex(actual);
        List<Edge<Recinto>> adyacentes = sitios.getEdges(verticeActual);
        for (Edge<Recinto> adyacente : adyacentes) {
            int proximo = adyacente.getTarget().getPosition();
            if (!visitados[proximo]) {
                int tiempoTraslado = adyacente.getWeight();
                int recintosVisitados = 1
                        + dfs(sitios, proximo, tiempoRestante - tiempoRecinto - tiempoTraslado, visitados);

                if (recintosVisitados > maxRecintos) {
                    maxRecintos = recintosVisitados; // Actualizamos el máximo de recintos visitados si es mayor
                }
            }
        }

        // backtracking
        visitados[actual] = false; 
        return maxRecintos; // Retornamos el máximo de recintos visitados

    }

}
