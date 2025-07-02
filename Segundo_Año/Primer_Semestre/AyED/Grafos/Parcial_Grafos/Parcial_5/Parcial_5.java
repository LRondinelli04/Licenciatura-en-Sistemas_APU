package Grafos.Parcial_Grafos.Parcial_5;

import Grafos.Clases.Graph;
import Grafos.Clases.Vertex;
import Grafos.Clases.Edge;
import Grafos.Clases.adjList.*;
import Grafos.Clases.adjMatrix.*;
import java.util.List;
import java.util.ArrayList;

/* enunciado que devuelve la mayor cantidad de ciudades a visitar de un grafo*/

public class Parcial_5 {

    public List<String> resolver(Graph<Ciudad> mapa, String ciudad, int cantDiasVacas) {
        List<String> resultado = new ArrayList<>();

        if (mapa == null || mapa.getSize() == 0 || ciudad == null || ciudad.isEmpty() || cantDiasVacas <= 0) {
            return resultado;
        }

        int indiceCiudad = -1;
        for (int i = 0; i < mapa.getSize(); i++) {
            if (mapa.getVertex(i).getData().getNombre().equals(ciudad)) {
                indiceCiudad = i;
                break;
            }
        }
        if (indiceCiudad == -1 || mapa.getVertex(indiceCiudad).getData().getDias() > cantDiasVacas) {
            return resultado;
        }

        boolean[] visitados = new boolean[mapa.getSize()];
        List<String> caminoActual = new ArrayList<>();
        recorrerDfs(resultado, mapa, indiceCiudad, cantDiasVacas, visitados, caminoActual);

        return resultado;
    }

    public void recorrerDfs(List<String> resultado, Graph<Ciudad> mapa, int indiceCiudad, int cantDiasVacas,
            boolean[] visitados, List<String> caminoActual) {

        Ciudad ciudadActual = mapa.getVertex(indiceCiudad).getData();

        visitados[indiceCiudad] = true;
        caminoActual.add(ciudadActual.getNombre());
        cantDiasVacas -= ciudadActual.getDias();

        if (caminoActual.size() > resultado.size()) {
            resultado.clear();
            resultado.addAll(caminoActual);
        }

        Vertex<Ciudad> verticeActual = mapa.getVertex(indiceCiudad);
        List<Edge<Ciudad>> adyacentes = mapa.getEdges(verticeActual);
        for (Edge<Ciudad> adyacente : adyacentes) {
            int proxIndice = adyacente.getTarget().getPosition();
            if (!visitados[proxIndice] && mapa.getVertex(proxIndice).getData().getDias() <= cantDiasVacas) {
                recorrerDfs(resultado, mapa, proxIndice, cantDiasVacas, visitados, caminoActual);
            }
        }

        // Backtracking
        visitados[indiceCiudad] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }

}
