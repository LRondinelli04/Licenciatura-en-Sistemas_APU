package Grafos.Parcial_Grafos.Parcial_2;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/* Recorrido BFS
 * - Ya que hay que priorizar los mas cercanos (los de menor nivel)
 */

public class Parcial_2 {

    public List<Invitado> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite) {

        // creo la lista de invitados
        List<Invitado> invitados = new ArrayList<>();

        // Comprobar casos bases
        if (red == null || red.getSize() == 0 || distancia <= 0 || limite <= 0) {
            return invitados;
        }

        // buscar el usuario
        Vertex<String> verticeUsuario = red.search(usuario);
        if (verticeUsuario == null) {
            return invitados;
        }

        bfs(red, verticeUsuario, distancia, limite, invitados);

        return invitados;
    }

    public void bfs(Graph<String> red, Vertex<String> verticeUsuario, int distanciaMax, int limite,
            List<Invitado> invitados) {

        boolean[] visitados = new boolean[red.getSize()];
        Queue<Vertex<String>> cola = new LinkedList<>();
        Queue<Integer> niveles = new LinkedList<>();

        visitados[verticeUsuario.getPosition()] = true;
        cola.add(verticeUsuario);
        niveles.add(0);

        // mientras que la cola no este vacia y no haya alcanzado el limite de invitados
        while (!cola.isEmpty() && invitados.size() < limite) {
            Vertex<String> actual = cola.poll();
            int distanciaActual = niveles.poll();

            if (distanciaActual > distanciaMax) {
                continue;
            }

            // si el nivel actual es menor o igual al limite de distancia, agrego el
            // invitado
            
            // verifico de no cargar el usuario inicial
            if (distanciaActual > 0 && distanciaActual <= distanciaMax) {
                invitados.add(new Invitado(actual.getData(), distanciaActual));
            }

            if (distanciaActual < distanciaMax) {
                List<Edge<String>> adyacentes = red.getEdges(actual);
                for (Edge<String> adyacente : adyacentes) {
                    Vertex<String> proxVertice = adyacente.getTarget();
                    int proxIndice = proxVertice.getPosition();
                    if (!visitados[proxIndice]) {
                        visitados[proxIndice] = true;
                        cola.add(proxVertice);
                        niveles.add(distanciaActual + 1);
                    }
                }
            }

        }

    }

}
