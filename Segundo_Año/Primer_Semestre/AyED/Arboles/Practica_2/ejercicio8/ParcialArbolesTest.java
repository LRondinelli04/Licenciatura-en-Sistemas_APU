import Practica_2.BinaryTree;
// import Practica_2.ejercicio8.ParcialArboles; // Removed or correct this import if needed

public class ParcialArbolesTest {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol1 = new BinaryTree<>(65);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(37);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(81);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(47);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(93);

        arbol1.addLeftChild(nodo1);
        arbol1.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);

        BinaryTree<Integer> arbol2 = new BinaryTree<>(65);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(37);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(81);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(47);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(93);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(76);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(94);

        arbol2.addLeftChild(nodo5);
        arbol2.addRightChild(nodo6);
        nodo5.addLeftChild(nodo7);
        nodo5.addRightChild(nodo8);
        nodo6.addLeftChild(nodo9);
        nodo6.addRightChild(nodo10);

        ParcialArboles parcial = new ParcialArboles();
        System.out.println(parcial.esPrefijo(arbol1, arbol2)); // true
        System.out.println(parcial.esPrefijo(arbol2, arbol1)); // false

    }
}
