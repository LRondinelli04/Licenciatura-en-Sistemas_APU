import java.util.LinkedList;
import java.util.List;
import Practica_3.GeneralTree;

public class RecorridosAG {

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido en preorden.
     */
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        if (a.isEmpty()) {
            return new LinkedList<>();
        }
        List<Integer> listaMayores = new LinkedList<>();

        if (a.getData() % 2 != 0 && a.getData() > n) {
            listaMayores.add(a.getData());
        }

        if (a.hasChildren()) {
            for (GeneralTree<Integer> hijo : a.getChildren()) {
                listaMayores.addAll(numerosImparesMayoresQuePreOrden(hijo, n));
            }

        }

        return listaMayores;
    }

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido en inorden.
     */
    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {

        if (a.isEmpty()) {
            return new LinkedList<>();
        }

        List<Integer> listaMayores = new LinkedList<>();
        List<GeneralTree<Integer>> hijos = a.getChildren();

        if (!hijos.isEmpty()) {
            listaMayores.addAll(numerosImparesMayoresQueInOrden(hijos.get(0), n));
        }

        if (a.getData() % 2 != 0 && a.getData() > n) {
            listaMayores.add(a.getData());
        }

        for (int i = 1; i < a.getChildren().size(); i++) {
            listaMayores.addAll(numerosImparesMayoresQueInOrden(hijos.get(i), n));
        }

        return listaMayores;
    }

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido en postorden.
     */
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        if (a.isEmpty()) {
            return new LinkedList<>();
        }

        List<Integer> listaMayores = new LinkedList<>();
        List<GeneralTree<Integer>> hijos = a.getChildren();

        for (GeneralTree<Integer> hijo : hijos) {
            listaMayores.addAll(numerosImparesMayoresQuePostOrden(hijo, n));
        }

        if (a.getData() % 2 != 0 && a.getData() > n) {
            listaMayores.add(a.getData());
        }

        return listaMayores;
    }

    /*
     * Método que retorna una lista con los elementos impares del árbol “a” que sean
     * mayores al valor “n”
     * pasados como parámetros, recorrido por niveles.
     */
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        return null;
    }
}
