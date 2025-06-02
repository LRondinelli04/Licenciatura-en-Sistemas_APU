import Practica_2.BinaryTree;

public class ParcialArboles {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {

        /*
         * Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2,
         * cuando arbol1 coincide con la parte inicial del árbol arbol2 tanto en el
         * contenido de los elementos como en su estructura.
         */

        // si arbol1 es vacio es prefijo de arbol2
        if (arbol1 == null || arbol1.isEmpty()) {
            return true;
        }
        // si arbol2 es vacio no puede ser prefijo de arbol1
        if (arbol2 == null || arbol2.isEmpty()) {
            return false;
        }
        // si las raices son diferentes no puede ser prefijo
        if (!arbol1.getData().equals(arbol2.getData())) {
            return false;
        }

        // si las raices son iguales, se llama recursivamente a los hijos izquierdos y
        // derechos de ambos arboles
        return esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild())
                && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());

    }

}
