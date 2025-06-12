import Practica_2.BinaryTree;
// import Practica_2.ejercicio6.Transformacion; // Removed or correct this import if needed

public class TransformacionTest {
    public static void main(String[] args) {
        // Construcción del árbol original
        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(8);

        raiz.addLeftChild(nodo1);
        raiz.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);
        nodo2.addLeftChild(nodo5);
        nodo2.addRightChild(nodo6);
        nodo3.addLeftChild(nodo7);

        System.out.println("ÁRBOL ORIGINAL:");
        printArbol(raiz, 0);
        System.out.println("--------------------------------------------------");

        Transformacion transformacion = new Transformacion(raiz);
        BinaryTree<Integer> arbolTransformado = transformacion.suma();

        System.out.println("ÁRBOL TRANSFORMADO:");
        printArbol(arbolTransformado, 0);
        System.out.println("--------------------------------------------------");
    }

    public static void printArbol(BinaryTree<?> node, int level) {
        if (node == null || node.isEmpty()) {
            return;
        }
        printArbol(node.getRightChild(), level + 1);
        System.out.println("  ".repeat(level) + node.getData());
        printArbol(node.getLeftChild(), level + 1);
    }
}
