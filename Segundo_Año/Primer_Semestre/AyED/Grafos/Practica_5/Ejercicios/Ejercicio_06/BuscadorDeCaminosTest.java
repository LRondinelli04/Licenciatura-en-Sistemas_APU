package Grafos.Practica_5.Ejercicios.Ejercicio_06;

import Grafos.Clases.Edge;
import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;

import java.util.List;
import java.util.ArrayList;

public class BuscadorDeCaminosTest {
    public static void main(String[] args) {

        Graph<String> grafo = new AdjListGraph<String>();

        Vertex<String> abuelita = grafo.createVertex("Casa Abuelita");
        Vertex<String> caperucita = grafo.createVertex("Casa Caperucita");
        Vertex<String> claro1 = grafo.createVertex("Claro 1");
        Vertex<String> claro2 = grafo.createVertex("Claro 2");
        Vertex<String> claro3 = grafo.createVertex("Claro 3");
        Vertex<String> claro4 = grafo.createVertex("Claro 4");
        Vertex<String> claro5 = grafo.createVertex("Claro 5");

        grafo.connect(caperucita, claro3, 4);
        grafo.connect(caperucita, claro1, 3);
        grafo.connect(caperucita, claro2, 4);

        grafo.connect(claro3, claro5, 15);
        grafo.connect(claro1, claro5, 3);
        grafo.connect(claro1, claro2, 4);
        grafo.connect(claro2, claro1, 4);
        grafo.connect(claro2, claro5, 11);
        grafo.connect(claro2, claro4, 10);

        grafo.connect(claro5, abuelita, 4);
        grafo.connect(claro4, abuelita, 9);

        BuscadorDeCaminos buscador = new BuscadorDeCaminos(grafo);
        List<List<String>> caminos = buscador.recorridosMasSeguro();
        System.out.println("Caminos encontrados:");
        for (List<String> camino : caminos) {
            System.out.println();
            System.out.println(camino);
            System.out.println("--------------------");
        }

    }
}
