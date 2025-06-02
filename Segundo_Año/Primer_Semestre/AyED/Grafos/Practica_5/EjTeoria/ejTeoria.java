package Grafos.Practica_5.EjTeoria;

import java.util.LinkedList;
import java.util.List;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

/* Dado un Grafo orientado y valorado positivamente, como por ejemplo el que muestra la figura,
implemente un método que retorne una lista con todos los caminos cuyo costo total sea igual a 10.
Se considera costo total del camino a la suma de los costos de las aristas que forman parte del
camino, desde un vértice origen a un vértice destino.
Se recomienda implementar un método público que invoque a un método recursivo privado. */

public class ejTeoria {

    public LinkedList<LinkedList<String>> dfsConCosto(Graph<String> grafo) {
        boolean[] marca = new boolean[grafo.getSize()]; // Marca para los vértices visitados
        LinkedList<LinkedList<String>> recorridos = new LinkedList<LinkedList<String>>(); // Lista de listas (list de
                                                                                          // recorridos validos)
        LinkedList<String> caminoActual = new LinkedList<>(); // Lista para almacenar el camino actual
        int costoTotal = 0;
        for (int i = 0; i < grafo.getSize(); i++) {
            System.out.println("Recorrido desde el vértice: " + grafo.getVertex(i).getData());
            caminoActual.add(grafo.getVertex(i).getData().toString()); // Agrega el vértice actual al camino
            marca[i] = true; // Marca el vértice como visitado
            dfsConCosto(i, costoTotal, grafo, marca, caminoActual, recorridos);
            marca[i] = false; // Desmarca el vértice para otros recorridos
        }
        return recorridos;
    }

    public void dfsConCosto(int i, int costoTotal, Graph<String> grafo, boolean[] marca, LinkedList<String> caminoActual, LinkedList<LinkedList<String>> recorridos) {
        Vertex<String> vertice = grafo.getVertex(i);        
        List<Edge<String>> adyacentes = grafo.getEdges(vertice);
        for(Edge<String> ad : adyacentes) {
            int j = ad.getTarget().getPosition(); // Obtiene la posición del vértice adyacente
            if (!marca[j]) {
                // si el vertice adyacente no esta visitado, tomar el costo de la arista en una variable peso, sumarla a costoTotal, ir cargando el camino actual y marcar el vertice adyacente como visitado, y llamar a la funsion recursiva, si el costoTotal es igual a 10, agregar el camino actual a la lista de recorridos validos, sino, limpiar el caminoActual y desmarcar el vertice adyacente como visitado
                int peso = ad.getWeight(); // tomo el peso de la arista
                costoTotal += peso; // sumo el peso al costo total 
                caminoActual.add(ad.getTarget().getData().toString()); // Agrego el vértice adyacente al camino actual
                marca[j] = true; // Marca el vértice adyacente como visitado

                if (costoTotal == 10) {
                    recorridos.add(caminoActual);
                } else {
                    dfsConCosto(j, costoTotal, grafo, marca, caminoActual, recorridos); // Llamada recursiva
                }

                // Limpiar el camino actual y desmarcar el vértice adyacente
                caminoActual.remove();
                marca[j] = false; // Desmarca el vértice adyacente
            }
        }
    }

}
