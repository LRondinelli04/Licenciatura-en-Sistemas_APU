import Practica_2.BinaryTree;
import Practica_2.BinaryTree;
/*
	 * -----------------------------------------------------------------------------
	 * ------------------ EJERCICIO 6: TRANSFORMACION ------------------------------
	 * -----------------------------------------------------------------------------
*/

public class Transformacion {

    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma() {
        transformar(arbol);
        return arbol;
    }

    private int transformar(BinaryTree<Integer> nodo) {
        // Caso base: si el nodo está vacío, retorna 0
        if (nodo == null || nodo.isEmpty()) {
            return 0;
        }

        // Caso base: si el nodo es una hoja, su valor se reemplaza por 0
        if (nodo.isLeaf()) {
            int valorOriginal = nodo.getData(); // Guarda el valor original
            nodo.setData(0); // Reemplaza el valor por 0
            return valorOriginal; // Retorna el valor original
        }

        // Llama recursivamente a los subárboles izquierdo y derecho
        int sumaIzquierda = transformar(nodo.getLeftChild());
        int sumaDerecha = transformar(nodo.getRightChild());

        // Reemplaza el valor del nodo actual con la suma de los valores de sus
        // subárboles
        int valorOriginal = nodo.getData(); // Guarda el valor original
        nodo.setData(sumaIzquierda + sumaDerecha); // Asigna la suma al nodo actual

        // Retorna la suma total (incluyendo el valor original del nodo actual)
        return nodo.getData() + valorOriginal;
    }

}
