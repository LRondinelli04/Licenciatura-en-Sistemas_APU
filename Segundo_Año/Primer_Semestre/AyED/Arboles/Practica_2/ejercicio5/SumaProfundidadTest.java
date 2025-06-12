import java.util.LinkedList;
import java.util.Queue;
// import ejercicio5.ProfundidadDeArbolBinario; // Removed because class is in the same directory or package

public class SumaProfundidadTest {
    public static void main(String[] args) {
        // Creo el árbol de integer
        ProfundidadDeArbolBinario<Integer> raiz = new ProfundidadDeArbolBinario<>(1);
        ProfundidadDeArbolBinario<Integer> hijoIzq = new ProfundidadDeArbolBinario<>(2);
        ProfundidadDeArbolBinario<Integer> hijoDer = new ProfundidadDeArbolBinario<>(3);
        ProfundidadDeArbolBinario<Integer> hijoIzqIzq = new ProfundidadDeArbolBinario<>(4);
        ProfundidadDeArbolBinario<Integer> hijoIzqDer = new ProfundidadDeArbolBinario<>(5);
        ProfundidadDeArbolBinario<Integer> hijoDerIzq = new ProfundidadDeArbolBinario<>(6);
        ProfundidadDeArbolBinario<Integer> hijoDerDer = new ProfundidadDeArbolBinario<>(7);
        ProfundidadDeArbolBinario<Integer> hijoIzqIzqIzq = new ProfundidadDeArbolBinario<>(8);
        ProfundidadDeArbolBinario<Integer> hijoIzqIzqDer = new ProfundidadDeArbolBinario<>(9);
        ProfundidadDeArbolBinario<Integer> hijoIzqDerIzq = new ProfundidadDeArbolBinario<>(10);

        raiz.addLeftChild(hijoIzq);
        raiz.addRightChild(hijoDer);
        hijoIzq.addLeftChild(hijoIzqIzq);
        hijoIzq.addRightChild(hijoIzqDer);
        hijoDer.addLeftChild(hijoDerIzq);
        hijoDer.addRightChild(hijoDerDer);
        hijoIzqIzq.addLeftChild(hijoIzqIzqIzq);
        hijoIzqIzq.addRightChild(hijoIzqIzqDer);
        hijoIzqDer.addLeftChild(hijoIzqDerIzq);

        // Calcular la suma de los elementos en la profundidad 2
        System.out.println("------------------------------------");
        System.out.println("Suma de elementos en profundidad 2: " + raiz.sumaElementosProfundidad(2));
        System.out.println("------------------------------------");
    }
}