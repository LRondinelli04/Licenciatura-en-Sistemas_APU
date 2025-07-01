package Grafos.Parcial_Grafos.ParcialesRepetidos.BFS;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import Grafos.Parcial_Grafos.Parcial_3.Invitado;

public class Parcial2 {
    public Invitado nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {

        // Casos base
        if (red == null || red.getSize() == 0 || usuario == null || distancia <= 0 || umbral <= 0) {
            return new Invitado(0, false);
        }

        Vertex<String> verUsuario = red.search(usuario);
        if (verUsuario == null) {
            return new Invitado(0, false);
        }

        Invitado invitado = bfs(red, verUsuario, distancia, umbral);
        return invitado;
    }

    public Invitado bfs(Graph<String> red, Vertex<String> actual, int distancia, int umbral) {
        boolean[] visitados = new boolean[red.getSize()];
        Queue<Vertex<String>> cola = new LinkedList<>();
        Queue<Integer> nivel = new LinkedList<>();
        int cantUsuarios = 0;

        visitados[actual.getPosition()] = true;
        cola.add(actual);
        nivel.add(0);

        while (!cola.isEmpty()) {
            Vertex<String> verActual = cola.poll();
            int nivelActual = nivel.poll();

            if (nivelActual < distancia) {
                List<Edge<String>> adyacentes = red.getEdges(verActual);
                for (Edge<String> a : adyacentes) {
                    Vertex<String> proxVertice = a.getTarget();
                    if (!visitados[proxVertice.getPosition()]) {
                        visitados[proxVertice.getPosition()] = true;
                        cola.add(proxVertice);
                        nivel.add(nivelActual + 1);
                    }
                }
            } else if (nivelActual == distancia) {
                cantUsuarios++;
            }
        }

        boolean popular = false;
        if (cantUsuarios >= umbral) {
            popular = true;
        }
        return new Invitado(cantUsuarios, popular);
    }
}
