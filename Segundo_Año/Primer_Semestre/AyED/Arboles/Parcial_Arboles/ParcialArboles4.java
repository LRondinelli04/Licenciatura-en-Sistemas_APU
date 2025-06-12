package Parcial_Arboles;

import Clases.BinaryTree;

public class ParcialArboles4 {

    private BinaryTree<Integer> arbol;

    public ParcialArboles4(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> nuevoTree() {
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        if (arbol.isEmpty()) {
            return nuevoArbol;
        }
        if (arbol.isLeaf()) {
            nuevoArbol.setData(arbol.getData());
        }
        cargarArbol(arbol, nuevoArbol);

        return nuevoArbol;
    }

    public void cargarArbol(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevoArbol) {
        if (arbol.hasLeftChild()) {
            nuevoArbol.addLeftChild(new BinaryTree<>(arbol.getData() + arbol.getLeftChild().getData()));
            cargarArbol(arbol.getLeftChild(), nuevoArbol.getLeftChild());
        }
        if (arbol.hasRightChild()) {
            nuevoArbol.addRightChild(new BinaryTree<>(arbol.getRightChild().getData()));
            cargarArbol(arbol.getRightChild(), nuevoArbol.getRightChild());
        }
    }

    public static void main(String[] args) {

    }
}
