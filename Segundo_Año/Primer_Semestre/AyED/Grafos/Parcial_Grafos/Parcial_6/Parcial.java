package Grafos.Parcial_Grafos.Parcial_6;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;

public class Parcial {
    public List<List<String>> resolver(Graph<String> sitios, String origen, String destino,
            List<String> evitarPasarPor) {
        List<List<String>> caminos = new ArrayList<>();
        // casos base
        if (sitios == null || sitios.getSize() == 0 || origen == null || destino == null || evitarPasarPor == null) {
            return caminos;
        }
        Vertex<String> vOrigen = sitios.search(origen);
        Vertex<String> vDestino = sitios.search(destino);
        if (vOrigen == null || vDestino == null) {
            return caminos; // origen o destino no existen
        }
        boolean[] visitados = new boolean[sitios.getSize()];
        List<String> caminoActual = new ArrayList<>();
        dfs(sitios, vOrigen, destino, evitarPasarPor, visitados, caminoActual, caminos, 0);
        return caminos;
    }

    public void dfs(Graph<String> sitios, Vertex<String> actual, String destino, List<String> evitarPasarPor,
            boolean[] visitados, List<String> caminoActual, List<List<String>> caminos, int cuadras) {

        if (evitarPasarPor.contains(actual.getData())) {
            return;
        }

        visitados[actual.getPosition()] = true;
        caminoActual.add(actual.getData());

        if (actual.getData().equals(destino)) {
            List<String> resultado = new ArrayList<>(caminoActual);
            resultado.add("Distancia total: " + cuadras + " cuadras");
            caminos.add(resultado);
        }
        List<Edge<String>> adyacentes = sitios.getEdges(actual);
        for (Edge<String> a : adyacentes) {
            int pesoCuadras = a.getWeight();
            Vertex<String> prox = a.getTarget();
            if (!visitados[prox.getPosition()]) {
                dfs(sitios, prox, destino, evitarPasarPor, visitados, caminoActual, caminos, cuadras + pesoCuadras);
            }
        }

        visitados[actual.getPosition()] = false; // desmarcar el nodo actual
        caminoActual.remove(caminoActual.size() - 1); // quitar el nodo actual del

    }
}
