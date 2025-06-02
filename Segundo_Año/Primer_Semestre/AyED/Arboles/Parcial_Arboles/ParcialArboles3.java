package Arboles.Parcial_Arboles;

/* 
 * Defina una clase ParcialArboles con una unica variable de instancia de tipo ArbolGeneral de enteros y un metodo publico con la siguiente firma: public ListaGenerica<Integer> nivel(int num).
 * El metodo debe devolver los nodos del nivel en donde cada nodo tenga al menos la cantidad num de hijos. Debe retornar el primer nivel que encuentre que cumple la condicion. En caso de no encontrar ningun retornar la lista vacia.
 * 
 * 
 */
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import Arboles.Clases.GeneralTree;

public class ParcialArboles3 {

    private GeneralTree<Integer> arbol;

    public ParcialArboles3(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> nivel(int num) {
        LinkedList<Integer> lista = new LinkedList<>();
        if (arbol.isEmpty() || arbol == null) {
            return lista;
        }

        if (arbol.isLeaf()) {
            if (num == 1) {
                lista.add(arbol.getData());
            }
            return lista;
        }

        buscarPorNivel(arbol, num, lista);

        return lista;
    }

    public void buscarPorNivel(GeneralTree<Integer> arbol, int num, LinkedList<Integer> lista) {
        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(arbol); // Encolar el nodo raíz

        while (!cola.isEmpty()) {
            int nivelSize = cola.size(); // Número de nodos en el nivel actual
            LinkedList<Integer> nivelActual = new LinkedList<>();

            // Procesar todos los nodos del nivel actual
            for (int i = 0; i < nivelSize; i++) {
                GeneralTree<Integer> nodoActual = cola.poll(); // Desencolar el nodo
                nivelActual.add(nodoActual.getData()); // Agregar el dato del nodo al nivel actual

                // Encolar los hijos del nodo actual
                for (GeneralTree<Integer> hijo : nodoActual.getChildren()) {
                    cola.add(hijo);
                }
            }

            // Verificar si el nivel actual tiene al menos `num` nodos
            if (nivelActual.size() >= num) {
                lista.addAll(nivelActual); // Agregar todos los nodos del nivel a la lista
                return;
            }
        }

        // Si no se encontró un nivel con al menos `num` nodos, devolver lista vacía
        lista.clear();
    }

    public static void main(String[] args) {
        // Crear los nodos del árbol
        GeneralTree<Integer> root = new GeneralTree<Integer>(10);

        GeneralTree<Integer> node8 = new GeneralTree<Integer>(8);
        GeneralTree<Integer> nodeMinus5 = new GeneralTree<Integer>(-5);

        GeneralTree<Integer> node5 = new GeneralTree<Integer>(5);
        GeneralTree<Integer> node22 = new GeneralTree<Integer>(22);
        GeneralTree<Integer> node19 = new GeneralTree<Integer>(19);

        GeneralTree<Integer> nodeMinus6 = new GeneralTree<Integer>(-6);
        GeneralTree<Integer> node2 = new GeneralTree<Integer>(2);
        GeneralTree<Integer> node28 = new GeneralTree<Integer>(28);
        GeneralTree<Integer> node55 = new GeneralTree<Integer>(55);
        GeneralTree<Integer> node18 = new GeneralTree<Integer>(18);
        GeneralTree<Integer> node4 = new GeneralTree<Integer>(4);
        GeneralTree<Integer> node2_2 = new GeneralTree<Integer>(2);
        GeneralTree<Integer> node8_2 = new GeneralTree<Integer>(8);

        // Construir el árbol
        root.addChild(node8);
        root.addChild(nodeMinus5);

        node8.addChild(node5);
        node8.addChild(node22);
        nodeMinus5.addChild(node19);

        node5.addChild(nodeMinus6);
        node5.addChild(node2);
        node5.addChild(node8);
        node22.addChild(node28);
        node22.addChild(node55);
        node22.addChild(node18);
        node19.addChild(node4);
        node19.addChild(node2_2);
        node19.addChild(node8_2);

        /*
         * imprimirArbol(root);
         */
        ParcialArboles3 arbol = new ParcialArboles3(root);

        List<Integer> lista = arbol.nivel(4);
        System.out.println("Lista de nodos con al menos 3 hijos: " + lista);

    }

    /*
     * public static void imprimirArbol(GeneralTree<Integer> a) {
     * imprimirArbol(a, 0); // Llama al método auxiliar con nivel inicial 0
     * }
     * 
     * private static void imprimirArbol(GeneralTree<Integer> a, int nivel) {
     * // Imprime el nodo con sangría según el nivel
     * if (a.hasChildren()) {
     * for (GeneralTree<Integer> hijo : a.getChildren()) {
     * imprimirArbol(hijo, nivel + 1); // Llama recursivamente con nivel
     * incrementado
     * }
     * }
     * }
     */
}
