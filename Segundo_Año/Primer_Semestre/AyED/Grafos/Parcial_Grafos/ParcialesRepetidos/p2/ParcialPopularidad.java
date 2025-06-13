package Grafos.Parcial_Grafos.ParcialesRepetidos.p2;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ParcialPopularidad {

    public Tupla nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {
        Tupla resultado = new Tupla(0, false);

        // Casos bases
        if (red == null || red.getSize() == 0 || distancia <= 0) {
            return resultado; // Retornar una tupla con cantidad 0 y popular false
        }

        Vertex<String> verticeUsuario = red.search(usuario);
        if (verticeUsuario == null) {
            return null; // Usuario no encontrado en la red
        }

        recorrerBFS(red, verticeUsuario, distancia, umbral, resultado);
        return resultado;
    }

    public void recorrerBFS(Graph<String> red, Vertex<String> verticeUsuario, int distancia, int umbral,
            Tupla resultado) {
        boolean[] visitados = new boolean[red.getSize()];
        Queue<Vertex<String>> cola = new LinkedList<>();
        Queue<Integer> niveles = new LinkedList<>();

        visitados[verticeUsuario.getPosition()] = true;
        cola.add(verticeUsuario);
        niveles.add(0);
        int cantUsuarios = 0;

        while (!cola.isEmpty()) {
            Vertex<String> verticeActual = cola.poll();
            int nivelActual = niveles.poll();

            // si me pase de la distancia no sigo recorriendo
            if (nivelActual > distancia) {
                continue;
            }

            // si el nivel es igual a la distancia, sumo en el contador
            if (nivelActual == distancia) {
                cantUsuarios++;
            }

            // si el nivel es menor a la distancia, sigo recorriendo
            if (nivelActual < distancia) {
                List<Edge<String>> adyacentes = red.getEdges(verticeActual);
                for (Edge<String> adyacente : adyacentes) {
                    Vertex<String> proxVertice = adyacente.getTarget();
                    int proxIndice = proxVertice.getPosition();
                    if (!visitados[proxIndice]) {
                        visitados[proxIndice] = true;
                        cola.add(proxVertice);
                        niveles.add(nivelActual + 1);
                    }
                }
            }
        }

        resultado.setCantidad(cantUsuarios);
        if (cantUsuarios >= umbral) {
            resultado.setPopular(true);
            ;
        } else {
            resultado.setPopular(false);
        }
    }

}
