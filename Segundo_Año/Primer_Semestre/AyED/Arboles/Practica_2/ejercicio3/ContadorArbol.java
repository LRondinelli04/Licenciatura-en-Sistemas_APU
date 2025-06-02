import Practica_2.BinaryTree;
import java.util.List;

public class ContadorArbol {

    public static void main(String[] args) {

        // Creo el arbol de integer
        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> hijoIzq = new BinaryTree<>(2);
        BinaryTree<Integer> hijoDer = new BinaryTree<>(3);
        BinaryTree<Integer> hijoIzqIzq = new BinaryTree<>(4);
        BinaryTree<Integer> hijoIzqDer = new BinaryTree<>(5);
        BinaryTree<Integer> hijoDerIzq = new BinaryTree<>(6);
        BinaryTree<Integer> hijoDerDer = new BinaryTree<>(7);
        BinaryTree<Integer> hijoIzqIzqIzq = new BinaryTree<>(8);
        BinaryTree<Integer> hijoIzqIzqDer = new BinaryTree<>(9);
        BinaryTree<Integer> hijoIzqDerIzq = new BinaryTree<>(10);

        raiz.addLeftChild(hijoIzq);
        raiz.addRightChild(hijoDer);
        hijoIzq.addLeftChild(hijoIzqIzq);
        hijoIzq.addRightChild(hijoIzqDer);
        hijoDer.addLeftChild(hijoDerIzq);
        hijoDer.addRightChild(hijoDerDer);
        hijoIzqIzq.addLeftChild(hijoIzqIzqIzq);
        hijoIzqIzq.addRightChild(hijoIzqIzqDer);
        hijoIzqDer.addLeftChild(hijoIzqDerIzq);

        List<Integer> paresInOrden = raiz.numeroParesInOrden();
        List<Integer> paresPreOrden = raiz.numeroParesPreOrden();

        System.out.println("Numeros pares en in orden: " + paresInOrden);
        System.out.println("Numeros pares en pre orden: " + paresPreOrden);

    }
}
