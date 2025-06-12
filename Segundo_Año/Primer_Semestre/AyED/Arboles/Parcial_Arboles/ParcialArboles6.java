package Parcial_Arboles;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

import Clases.GeneralTree;

public class ParcialArboles6 {
    private GeneralTree<Integer> arbol;

    public ParcialArboles6(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> nivel(int num) {
        LinkedList<Integer> resultado = new LinkedList<>();
        if (arbol.isEmpty() || arbol.isLeaf()) {
            return resultado; // Si el árbol está vacío o
        }

        if (recorrer(arbol, num, resultado)) {
            return resultado;
        }
        return resultado;
    }

    public boolean recorrer(GeneralTree<Integer> arbol, int num, LinkedList<Integer> resultado) {
        Queue<GeneralTree<Integer>> cola = new LinkedList<GeneralTree<Integer>>();
        cola.add(arbol);
        while (!cola.isEmpty()) {
            int nivelSize = cola.size(); // Tamaño del nivel actual
            LinkedList<GeneralTree<Integer>> nActual = new LinkedList<GeneralTree<Integer>>();
            for (int i = 0; i < nivelSize; i++) { // recorro los valores de la cola para guardarlos en nActual
                GeneralTree<Integer> nodo = cola.poll();
                nActual.add(nodo);
                for (GeneralTree<Integer> hijo : nodo.getChildren()) { // encolo los hijos de los nodos
                    cola.add(hijo);
                }
            }
            boolean cumple = true;
            for (GeneralTree<Integer> nodo : nActual) { // recorro todos los nodos del nivel para verificar que todos
                                                        // cumplen la condicion
                if (nodo.getChildren().size() < num) {
                    cumple = false;
                    break; // si uno no cumple, salgo del bucle y paso al siguiente
                }
            }
            if (cumple) { // si da true es porque todos los nodos del nivel cumplen la condicion
                // agregar los nodos del nivelActual a la lista resultado
                for (GeneralTree<Integer> nodo : nActual) {
                    resultado.add(nodo.getData());
                }
                return true; // salgo del metodo porque ya encontre el primer nivel que cumple la condicion
            }
        }
        return false; // si no encontre ningun nivel que cumpla la condicion, devuelvo false
    }
}
