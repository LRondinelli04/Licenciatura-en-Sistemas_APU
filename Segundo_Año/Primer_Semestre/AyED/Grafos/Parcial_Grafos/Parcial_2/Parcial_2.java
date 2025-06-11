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

        // Buscar el usuario si existe
        int usuarioIndex = -1;
        for (int i = 0; i < red.getSize(); i++) {
            if (red.getVertex(i).getData().equals(usuario)) {
                usuarioIndex = i;
                break;
            }
        }
        if (usuarioIndex == -1) {
            return invitados; // Usuario no encontrado, retorno vacio
        }

        // recorrer BFS
        boolean[] visitados = new boolean[red.getSize()];
        bfs(invitados, red, usuarioIndex, distancia, limite, visitados);

        return invitados;
    }

    public void bfs(List<Invitado> invitados, Graph<String> red, int usuarioIndex, int distanciaMax, int limite,
            boolean[] visitados) {

        Queue<NodoBFS> cola = new LinkedList<>();
        cola.add(new NodoBFS(usuarioIndex, 0));
        visitados[usuarioIndex] = true;

        // mientras que la cola no este vacia y no haya alcanzado el limite de invitados
        while (!cola.isEmpty() && invitados.size() < limite) {
            NodoBFS actual = cola.poll();
            int indiceActual = actual.getIndice();
            int distanciaActual = actual.getDistancia();

            if (distanciaActual > 0) {
                invitados.add(new Invitado(red.getVertex(indiceActual).getData(), distanciaActual));
                if (invitados.size() >= limite) {
                    break; // Limite alcanzado
                }
            }

            if (distanciaActual < distanciaMax) {
                // Obtener el vertice actual
                Vertex<String> verticeActual = red.getVertex(indiceActual);
                List<Edge<String>> adyacentes = red.getEdges(verticeActual);
                for (Edge<String> adyacente : adyacentes) {
                    int proxIndice = adyacente.getTarget().getPosition();
                    if (!visitados[proxIndice]) {
                        visitados[proxIndice] = true; // Marcar como visitado
                        cola.add(new NodoBFS(proxIndice, distanciaActual + 1)); // Agregar a la cola con distancia
                                                                                // incrementada
                    }
                }
            }
        }

    }

}
