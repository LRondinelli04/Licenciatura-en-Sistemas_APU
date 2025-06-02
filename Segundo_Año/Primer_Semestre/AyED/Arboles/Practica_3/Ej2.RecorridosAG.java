
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import GeneralTree;

public class RecorridosAG {

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido en preorden.
     */
    /*
     * public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,
     * Integer n) {
     * if (a.isEmpty()) {
     * return new LinkedList<>();
     * }
     * List<Integer> listaMayores = new LinkedList<>();
     * 
     * if (a.getData() % 2 != 0 && a.getData() > n) {
     * listaMayores.add(a.getData());
     * }
     * 
     * if (a.hasChildren()) {
     * for (GeneralTree<Integer> hijo : a.getChildren()) {
     * listaMayores.addAll(numerosImparesMayoresQuePreOrden(hijo, n));
     * }
     * 
     * }
     * 
     * return listaMayores;
     * }
     */

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        /*
         * Metodo que retorna una lista con los elementos impares de a que sean mayores
         * a n, recorrido preorder
         */
        if (a.isEmpty()) {
            return null;
        }
        List<Integer> lista = new LinkedList<Integer>();
        if (a.getData() % 2 != 0 && a.getData() > n) {
            lista.add(a.getData());
        }
        List<GeneralTree<Integer>> hijos = a.getChildren();
        for (GeneralTree<Integer> hijo : hijos) {
            lista.addAll(numerosImparesMayoresQuePreOrden(hijo, n));
        }

        return lista;
    }

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido en inorden.
     */
    /*
     * public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a,
     * Integer n) {
     * 
     * if (a.isEmpty()) {
     * return new LinkedList<>();
     * }
     * 
     * List<Integer> listaMayores = new LinkedList<>();
     * List<GeneralTree<Integer>> hijos = a.getChildren();
     * 
     * if (!hijos.isEmpty()) {
     * listaMayores.addAll(numerosImparesMayoresQueInOrden(hijos.get(0), n));
     * }
     * 
     * if (a.getData() % 2 != 0 && a.getData() > n) {
     * listaMayores.add(a.getData());
     * }
     * 
     * for (int i = 1; i < a.getChildren().size(); i++) {
     * listaMayores.addAll(numerosImparesMayoresQueInOrden(hijos.get(i), n));
     * }
     * 
     * return listaMayores;
     * }
     */
    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        /*
         * Metodo que retorna una lista de elementos impares de a con los valores
         * mayores a n, en inorden
         */
        if (a.isEmpty()) {
            return null;
        }
        List<Integer> lista = new LinkedList<Integer>();

        /* proceso el primer hijo */
        List<GeneralTree<Integer>> hijos = a.getChildren(); // obtengo todos los hijos
        if (!hijos.isEmpty()) {
            lista.addAll(numerosImparesMayoresQueInOrden(hijos.get(0), n));
        }

        /* proceso el nodo */
        if (a.getData() % 2 != 0 && a.getData() > n) {
            lista.add(a.getData());
        }
        /* proceso el resto de los hijos */
        for (int i = 1; i < a.getChildren().size(); i++) {
            lista.addAll(numerosImparesMayoresQueInOrden(hijos.get(i), n));
        }

        return lista;
    }

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido en postorden.
     */
    /*
     * public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer>
     * a, Integer n) {
     * if (a.isEmpty()) {
     * return new LinkedList<>();
     * }
     * 
     * List<Integer> listaMayores = new LinkedList<>();
     * List<GeneralTree<Integer>> hijos = a.getChildren();
     * 
     * for (GeneralTree<Integer> hijo : hijos) {
     * listaMayores.addAll(numerosImparesMayoresQuePostOrden(hijo, n));
     * }
     * 
     * if (a.getData() % 2 != 0 && a.getData() > n) {
     * listaMayores.add(a.getData());
     * }
     * 
     * return listaMayores;
     * }
     */

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        if (a.isEmpty()) {
            return null;
        }
        List<Integer> lista = new LinkedList<Integer>();
        List<GeneralTree<Integer>> hijos = a.getChildren(); // obtengo todos los hijos
        for (GeneralTree<Integer> hijo : hijos) {
            lista.addAll(numerosImparesMayoresQuePostOrden(hijo, n));
        }
        if (a.getData() % 2 != 0 && a.getData() > n) {
            lista.add(a.getData());
        }

        return lista;
    }

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido por niveles.
     */
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        if (a.isEmpty()) {
            return null;
        }
        List<Integer> lista = new LinkedList<Integer>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new LinkedList<GeneralTree<Integer>>();
        cola.add(a);
        cola.add(null);
        int nivel = 0;
        while (!cola.isEmpty()) {
            aux = cola.poll();
            if (aux != null) {
                if (aux.getData() % 2 != 0 && aux.getData() > n) {
                    lista.add(aux.getData());
                }
                List<GeneralTree<Integer>> hijos = aux.getChildren(); // obtengo todos los hijos
                for (GeneralTree<Integer> hijo : hijos) {
                    cola.add(hijo);
                }
            } else {
                if (!cola.isEmpty()) {
                    System.out.println("Nivel: " + nivel);
                    nivel++;
                    cola.add(null);
                }
            }
        }
        return lista;
    }

}
