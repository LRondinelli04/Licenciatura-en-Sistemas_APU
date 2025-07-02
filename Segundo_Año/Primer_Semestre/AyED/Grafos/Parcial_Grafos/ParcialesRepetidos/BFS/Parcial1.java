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
import Grafos.Parcial_Grafos.Parcial_2.Invitado;

public class Parcial1 {

    public List<Invitado> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite) {
        List<Invitado> invitados = new ArrayList<>();

        // Casos base
        if (red == null || red.getSize() == 0 || distancia <= 0 || limite <= 0) {
            return invitados; // vacio
        }

        Vertex<String> verUsuario = red.search(usuario);
        if (verUsuario == null) {
            return invitados; // vacio
        }

        bfs(red, verUsuario, distancia, limite, invitados);
        return invitados;
    }

    public void bfs(Graph<String> red, Vertex<String> verActual, int distancia, int limite, List<Invitado> invitados) {
        boolean[] visitados = new boolean[red.getSize()];
        Queue<Vertex<String>> cola = new LinkedList<Vertex<String>>(); // Queue<Vertex<String>> cola = new
                                                                       // Queue<Vertex<String>>();
        Queue<Integer> nivel = new LinkedList<Integer>(); // Queue<Integer> nivel = new Queue<Integer>();

        cola.add(verActual); // cola.enqueue(verActual);
        nivel.add(0); // nivel.enqueue(0);
        visitados[verActual.getPosition()] = true;

        while (!cola.isEmpty() && invitados.size() < limite) {
            Vertex<String> vertice = cola.poll();
            int nivelActual = nivel.poll();

            if (nivelActual > distancia) {
                continue;
            }
            if (nivelActual <= distancia && nivelActual > 0) {
                invitados.add(new Invitado(vertice.getData(), nivelActual));
            }
            if (nivelActual < distancia) {
                List<Edge<String>> adyacentes = red.getEdges(vertice);
                for (Edge<String> a : adyacentes) {
                    Vertex<String> proxVertice = a.getTarget();
                    if (!visitados[proxVertice.getPosition()]) {
                        visitados[proxVertice.getPosition()] = true;
                        cola.add(proxVertice);
                        nivel.add(nivelActual + 1);
                    }
                }
            }
        }

    }

}
