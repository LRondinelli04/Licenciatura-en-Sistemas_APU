package Grafos.Parcial_Grafos.Parcial_3;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Parcial_3 {

    public Invitado nivelProfundidad(Graph<String> red, String usuario, int distancia, int umbral) {
        Invitado invitado = new Invitado(0, false);
        // Analizar casos bases
        if (red == null || red.getSize() == 0 || distancia <= 0) {
            return invitado;
        }

        Vertex<String> verticeUsuario = red.search(usuario);
        if (verticeUsuario == null) {
            return invitado; // Usuario no encontrado en la red
        }

        // recorrer BFS
        bfs(invitado, red, verticeUsuario, distancia, umbral);

        return invitado;
    }

    public void bfs(Invitado invitado, Graph<String> red, Vertex<String> verticeUsuario, int distancia, int umbral) {
        boolean[] visitados = new boolean[red.getSize()];
        Queue<Vertex<String>> cola = new LinkedList<>();
        Queue<Integer> niveles = new LinkedList<>();

        visitados[verticeUsuario.getPosition()] = true;
        cola.add(verticeUsuario);
        niveles.add(0);
        int cantUsuarios = 0;

        while (!cola.isEmpty()) {
            Vertex<String> verticeActual = cola.poll();
            int distanciaActual = niveles.poll();

            if (distanciaActual > distancia) {
                continue;
            }
            if (distanciaActual == distancia) {
                cantUsuarios++;
            }
            if (distanciaActual < distancia) {
                List<Edge<String>> adyacentes = red.getEdges(verticeActual);
                for (Edge<String> adyacente : adyacentes) {
                    int proxIndice = adyacente.getTarget().getPosition();
                    if (!visitados[proxIndice]) {
                        visitados[proxIndice] = true;
                        cola.add(adyacente.getTarget());
                        niveles.add(distanciaActual + 1);
                    }
                }
            }
        }

        invitado.setNumInvitados(cantUsuarios);
        invitado.setPopular(cantUsuarios >= umbral);

    }

}
