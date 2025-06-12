package Parcial_Arboles;

import Clases.BinaryTree;

public class ParcialArboles8 {
    private BinaryTree<Integer> arbol;

    public ParcialArboles8(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> nuevoTree() {
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        if (arbol.isEmpty() || arbol == null) {
            return nuevoArbol;
        }

        if (arbol.isLeaf()) {
            nuevoArbol.setData(arbol.getData());
            return nuevoArbol;
        }

        nuevoArbol.setData(arbol.getData());
        armarArbol(arbol, nuevoArbol);
        return nuevoArbol;
    }

    public void armarArbol(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevoArbol) {
        if (arbol.hasLeftChild()) {
            nuevoArbol.addLeftChild(new BinaryTree<>(arbol.getData() + arbol.getLeftChild().getData()));
            armarArbol(arbol.getLeftChild(), nuevoArbol.getLeftChild()); // paso al siguiente hijo izquierdo
        }
        if (arbol.hasRightChild()) {
            nuevoArbol.addRightChild(new BinaryTree<>(arbol.getRightChild().getData()));
            armarArbol(arbol.getRightChild(), nuevoArbol.getRightChild()); // paso al siguiente hijo derecho
        }
    }
}
