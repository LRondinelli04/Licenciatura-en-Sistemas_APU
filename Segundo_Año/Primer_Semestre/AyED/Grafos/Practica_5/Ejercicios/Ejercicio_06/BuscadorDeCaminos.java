package Grafos.Practica_5.Ejercicios.Ejercicio_06;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;

/* Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, recolectando frutos del bosque del
camino y tratando de hacer el paseo de la manera más segura posible. La casa de Caperucita está en un claro
del extremo oeste del bosque, la casa de su abuelita en un claro del extremo este, y dentro del bosque entre
ambas hay algunos otros claros.
El bosque está representado por un grafo, donde los vértices representan los claros (identificados por un
String) y las aristas los senderos que los unen. Cada arista informa la cantidad de árboles frutales que hay en el
sendero. Caperucita sabe que el lobo es muy goloso y le gustan mucho las frutas, entonces para no ser
capturada por el lobo, desea encontrar todos los caminos que no pasen por los senderos con cantidad de
frutales >= 5 y lleguen a la casa de la abuelita.
Su tarea es definir una clase llamada BuscadorDeCaminos, con una variable de instancia llamada "bosque" de
tipo Graph, que representa el bosque descrito e implementar un método de instancia con la siguiente firma:
public List < List <String>> recorridosMasSeguro()
que devuelva un listado con TODOS los caminos que cumplen con las condiciones mencionadas anteriormente.
Nota: La casa de Caperucita debe ser buscada antes de comenzar a buscar el recorrido.
Para el siguiente ejemplo: */

/* 
 * Debe retornar una lista con caminos:
1) Casa Caperucita- Claro 1 - Claro 5 - Casa Abuelita.
2) Casa Caperucita- Claro 2 - Claro 1 - Claro 5 - Casa Abuelita.
 */

public class BuscadorDeCaminos {

    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguro() {
        List<List<String>> caminosValidos = new ArrayList<List<String>>();
        List<String> caminoActual = new ArrayList<String>();
        boolean[] visitados = new boolean[bosque.getSize()];
        int actual = -1;
        for (int i = 0; i < bosque.getSize(); i++) {
            if (bosque.getVertex(i).getData().equals("Casa Caperucita")) {
                actual = i;
                break; // Solo necesitamos comenzar desde la casa de Caperucita
            }
        }

        if (actual == -1) {
            return caminosValidos; // No se encontró la casa de Caperucita
        }

        buscarCaminoDfs(actual, bosque, visitados, caminoActual, caminosValidos);

        return caminosValidos;
    }

    private void buscarCaminoDfs(int actual, Graph<String> bosque, boolean[] visitados, List<String> caminoActual,
            List<List<String>> caminosValidos) {
        String infoVerticeActual = bosque.getVertex(actual).getData();

        caminoActual.add(infoVerticeActual); // Agregamos el vértice actual al camino
        visitados[actual] = true; // Marcamos el vértice actual como visitado

        if (infoVerticeActual.equals("Casa Abuelita")) {
            caminosValidos.add(new ArrayList<>(caminoActual));
        }

        // Buscamos todos los vértices adyacentes al actual
        Vertex<String> verticeActual = bosque.getVertex(actual);
        List<Edge<String>> adyacentes = bosque.getEdges(verticeActual);
        for (Edge<String> adyacente : adyacentes) {
            int peso = adyacente.getWeight();
            if (peso < 5) {
                int proximo = adyacente.getTarget().getPosition();
                if (!visitados[proximo]) {
                    buscarCaminoDfs(proximo, bosque, visitados, caminoActual, caminosValidos);
                }
            }
        }

        // Desmarcamos el vértice actual como visitado y lo removemos del camino
        visitados[actual] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }

}
