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

    public List<Invitado> nivelProfundidad(Graph<String> red, String usuario, int distancia, int umbral) {
        List<Invitado> invitados = new ArrayList<>();

        // Analizar casos bases
        if (red == null || red.getSize() == 0 || distancia <= 0) {
            return invitados;
        }

        // buscar usuario
        int indiceUsuario = -1;
        for (int i = 0; i < red.getSize(); i++) {
            if (red.getVertex(i).getData().equals(usuario)) {
                indiceUsuario = i;
                break;
            }
        }
        if (indiceUsuario == -1) {
            return invitados; // Usuario no encontrado, retorno vacio
        }

        // recorrer BFS
        boolean[] visitados = new boolean[red.getSize()];
        bfs(invitados, red, indiceUsuario, distancia, umbral, visitados);

        return invitados;
    }

    public void bfs(List<Invitado> invitados, Graph<String> red, int indiceUsuario, int distanciaMax, int umbral,
            boolean[] visitados) {

        Queue<NodoBFS> cola = new LinkedList<>(); //
        cola.add(new NodoBFS(indiceUsuario, 0)); // el primer nodo (cargo distancia 0) [cola.enqueue(new
                                                 // NodoBFS(indiceUsuario, 0))]
        visitados[indiceUsuario] = true;
        int cantInvitados = 0;
        boolean popular = false; // Variable para determinar si el invitado es popular

        while (!cola.isEmpty()) {
            NodoBFS actual = cola.poll(); // cola.dequeue()
            int indiceActual = actual.getIndice();
            int distanciaActual = actual.getDistancia();

            if (distanciaActual > 0) {
                cantInvitados++;
                if (distanciaActual >= umbral) {
                    popular = true;
                }
                invitados.add(new Invitado(cantInvitados, popular));
                if (distanciaActual >= distanciaMax) {
                    break; // Si la distancia actual supera el máximo, no se procesan más nodos
                }
            }

            if (distanciaActual < distanciaMax) {
                Vertex<String> verticeActual = red.getVertex(indiceActual);
                List<Edge<String>> adyacentes = red.getEdges(verticeActual);
                for (Edge<String> adyacente : adyacentes) {
                    int proxIndice = adyacente.getTarget().getPosition();
                    if (!visitados[proxIndice]) {
                        visitados[proxIndice] = true; // Marcar como visitado
                        cola.add(new NodoBFS(proxIndice, distanciaActual++));// cola.enqueue(new NodoBFS(proxIndice,
                                                                             // distanciaActual + 1));
                    }
                }
            }
        }
    }
}
