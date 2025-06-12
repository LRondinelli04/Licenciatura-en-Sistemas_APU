package Parcial_Arboles;

import Clases.BinaryTree;
import java.util.LinkedList;

public class ParcialArboles7 {

    private BinaryTree<String> arbol;

    public ParcialArboles7(BinaryTree<String> arbol) {
        this.arbol = arbol;
    }

    /*
     * Encontrar el camino desde la raíz hasta la princesa, si existe evitando que
     * en el camino se encuentre un nodo de tipo Dragon, si no hay, devuelve la
     * lista vacia.
     * 
     * 
     */

    public LinkedList<String> princesaAccesible() {
        if (this.arbol.isEmpty()) {
            return null;
        }
        LinkedList<String> camino = new LinkedList<>();
        if (this.arbol.isLeaf()) {
            if (this.arbol.getData().equals("princesa")) {
                camino.add(this.arbol.getData());
            }
            return camino;
        }
        recorrer(this.arbol, camino);
        return camino;
    }

    public boolean recorrer(BinaryTree<String> arbol, LinkedList<String> camino) {
        camino.add(arbol.getData());
        if (arbol.getData().equals("princesa")) {
            return true;
        }
        if (arbol.getData().equals("dragón")) {
            camino.removeLast();
            return false;
        }
        if (arbol.hasLeftChild()) {
            if (recorrer(arbol.getLeftChild(), camino)) {
                return true;
            }
        }
        if (arbol.hasRightChild()) {
            if (recorrer(arbol.getRightChild(), camino)) {
                return true;
            }
        }
        camino.removeLast();
        return false;
    }

}
