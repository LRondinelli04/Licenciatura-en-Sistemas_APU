import Practica_2.BinaryTree;

public class TransformacionTest {

    public static void main(String[] args) {
        BinaryTree<String> root = new BinaryTree<>("A");
        BinaryTree<String> left = new BinaryTree<>("B");
        BinaryTree<String> right = new BinaryTree<>("C");
        BinaryTree<String> leftLeft = new BinaryTree<>("D");
        BinaryTree<String> leftRight = new BinaryTree<>("E");
        BinaryTree<String> rightLeft = new BinaryTree<>("F");
        BinaryTree<String> rightRight = new BinaryTree<>("G");
        BinaryTree<String> leftLeftLeft = new BinaryTree<>("H");
        BinaryTree<String> leftLeftRight = new BinaryTree<>("I");

        root.addLeftChild(left);
        root.addRightChild(right);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        right.addLeftChild(rightLeft);
        right.addRightChild(rightRight);
        leftLeft.addLeftChild(leftLeftLeft);
        leftLeft.addRightChild(leftLeftRight);

        System.out.println("Cantidad de hojas: " + root.contarHojas());
        System.out.println("ARBOL ORIGINAL:");
        printTree(root, 0);

        /*
         * BinaryTree<String> espejo = root.espejo();
         * 
         * System.out.println("ARBOL ESPEJO:");
         * printTree(espejo, 0);
         */

        root.entreNiveles(0, 3);

    }

    // Método auxiliar para imprimir el árbol en formato jerárquico
    public static void printTree(BinaryTree<?> node, int level) {
        if (node == null || node.isEmpty()) {
            return;
        }
        printTree(node.getRightChild(), level + 1);
        System.out.println("  ".repeat(level) + node.getData());
        printTree(node.getLeftChild(), level + 1);
    }
}
