package Arboles.Parcial_Arboles;

/* Defina una clase Parcial Arboles con: una unica variable de instancia de tipo BinaryTree<Integer> y un metodo public con la siguiente firma:
 * public BinaryTree<Integer> nuevoTree()
 * El metodo debe devolver un nuevo arbol, construido de la siguiente manera:
 * 1. Si el arbol dado tiene hijo izquierdo, el nuevo arbol tendra hijo izquierdo cuyo valor sera la suma del valor del hijo izquierdo y el valor del padre del arbol dado.
 * 2. Si el arbol dado no tiene hijo izquierdo, tampoco tendra el nuevo.
 * 3. Los hijos derechos del nuevo arbol son iguales que los del arbol dado.
 * 4. Las hojas del arbol seran hojas en el nuevo.
 */
import Arboles.Clases.BinaryTree;

public class ParcialArboles2 {

    private BinaryTree<Integer> arbol;

    public ParcialArboles2(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> nuevoTree() {
        /*
         * Casos a considerar
         * 1. si el arbol es vacio, devolver null
         * 2. si el arbol es hoja, devolver el arbol
         */
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        if (this.arbol.isEmpty()) {
            return null;
        }
        if (this.arbol.isLeaf()) {
            nuevoArbol.setData(this.arbol.getData());
            return nuevoArbol;
        }
        nuevoArbol.setData(this.arbol.getData()); // asigno la raiz al nuevo arbol
        crearArbol(arbol, nuevoArbol);
        return nuevoArbol;
    }

    public void crearArbol(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevoArbol) {
        if (arbol.hasLeftChild()) {
            nuevoArbol.addLeftChild(new BinaryTree<>(arbol.getLeftChild().getData() + arbol.getData()));
            crearArbol(arbol.getLeftChild(), nuevoArbol.getLeftChild());
        }
        if (arbol.hasRightChild()) {
            nuevoArbol.addRightChild(new BinaryTree<>(arbol.getRightChild().getData()));
            crearArbol(arbol.getRightChild(), nuevoArbol.getRightChild());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> hijoIzq = new BinaryTree<>(2);
        BinaryTree<Integer> hijoDer = new BinaryTree<>(3);
        BinaryTree<Integer> hijoIzqIzq = new BinaryTree<>(4);
        BinaryTree<Integer> hijoDerIzq = new BinaryTree<>(5);
        BinaryTree<Integer> hijoDerDer = new BinaryTree<>(6);
        BinaryTree<Integer> hijoDerIzqIzq = new BinaryTree<>(7);

        hijoDerIzq.addLeftChild(hijoDerIzqIzq);
        hijoDer.addRightChild(hijoDerDer);
        hijoDer.addLeftChild(hijoDerIzq);
        hijoIzq.addLeftChild(hijoIzqIzq);
        raiz.addLeftChild(hijoIzq);
        raiz.addRightChild(hijoDer);

        System.out.println("Arbol original: ");
        imprimirInorden(raiz);

        ParcialArboles2 arbol = new ParcialArboles2(raiz);
        BinaryTree<Integer> nuevoArbol = arbol.nuevoTree();
        System.out.println("Nuevo arbol: ");
        imprimirInorden(nuevoArbol);
    }

    public static void imprimirInorden(BinaryTree<Integer> a) {
        System.out.println(a.getData() + " ");
        if (a.hasLeftChild()) {
            imprimirInorden(a.getLeftChild());
        }
        if (a.hasRightChild()) {
            imprimirInorden(a.getRightChild());
        }
    }
}
