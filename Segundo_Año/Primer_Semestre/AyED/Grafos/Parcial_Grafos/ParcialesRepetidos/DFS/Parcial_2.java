package Grafos.Parcial_Grafos.ParcialesRepetidos.DFS;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;
import Grafos.Parcial_Grafos.Parcial_1.Recinto;

public class Parcial_2 {

    public String resolver(Graph<Recinto> sitios, int tiempo) {
        // Casos base
        if (sitios == null || sitios.getSize() == 0 || tiempo <= 0) {
            return "No Alcanzable";
        }

        Vertex<Recinto> verEntrada = null;
        for (int i = 0; i < sitios.getSize(); i++) {
            if (sitios.getVertex(i).getData().getNombre().equals("Entrada")) {
                verEntrada = sitios.getVertex(i);
                break;
            }
        }

        if (verEntrada == null || verEntrada.getData().getTiempo() > tiempo) {
            return "No Alcanzable";
        }

        boolean[] visitados = new boolean[sitios.getSize()];
        if (dfs(sitios, verEntrada, tiempo, visitados)) {
            return "Alcanzable";
        } else {
            return "No Alcanzable";
        }
    }

    public boolean dfs(Graph<Recinto> sitios, Vertex<Recinto> actual, int tiempo, boolean[] visitados) {

        if (actual.getData().getTiempo() > tiempo) {
            return false;
        }

        visitados[actual.getPosition()] = true;
        tiempo -= actual.getData().getTiempo();
        if (todosVisitados(sitios, visitados)) { // no es lo mas optimo
            return true;
        }

        List<Edge<Recinto>> adyacentes = sitios.getEdges(actual);
        for (Edge<Recinto> a : adyacentes) {
            int tiempoArista = a.getWeight();
            if (tiempoArista <= tiempo) {
                Vertex<Recinto> proxVertice = a.getTarget();
                if (!visitados[proxVertice.getPosition()]) {
                    if (dfs(sitios, proxVertice, tiempo - tiempoArista, visitados)) {
                        return true;
                    }
                }
            }
        }

        visitados[actual.getPosition()] = false;
        return false;

    }

    public boolean todosVisitados(Graph<Recinto> sitios, boolean[] visitados) {
        for (int i = 0; i < sitios.getSize(); i++) {
            if (!visitados[i]) {
                return false;
            }
        }
        return true;
    }

}
