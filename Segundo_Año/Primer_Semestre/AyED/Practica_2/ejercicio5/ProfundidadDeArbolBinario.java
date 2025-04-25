
import java.util.LinkedList;
import java.util.Queue;
import Practica_2.BinaryTree;

public class ProfundidadDeArbolBinario<T> extends BinaryTree<T> {

    public ProfundidadDeArbolBinario(T data) {
        super(data);
    }

    public int sumaElementosProfundidad(int profundidad) {
        if (this.isEmpty()) {
            return 0;
        }
        if (profundidad < 0) {
            System.out.println("La profundidad no puede ser negativa.");
            return 0;
        }

        int suma = 0;

        Queue<BinaryTree<T>> cola = new LinkedList<>();
        Queue<Integer> niveles = new LinkedList<>();
        cola.add(this);
        niveles.add(0);

        while (!cola.isEmpty()) {
            BinaryTree<T> actual = cola.poll();
            int nivel = niveles.poll();

            if (nivel == profundidad) {
                suma += (Integer) actual.getData();
            }

            if (nivel < profundidad) {
                if (actual.hasLeftChild()) {
                    cola.add(actual.getLeftChild());
                    niveles.add(nivel + 1);
                }
                if (actual.hasRightChild()) {
                    cola.add(actual.getRightChild());
                    niveles.add(nivel + 1);
                }
            }
        }

        return suma;
    }
}