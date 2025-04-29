import Parciales.GeneralTree;

public class ParcialArboles {

    /* unica variable instancia de tipo ArbolGeneral de enteros */
    private GeneralTree<Integer> arbolGeneral;

    /*
     * metodo publico el cual debe devolver los nodos del nivel en donde cada nodo
     * tenga la menos la cantidad num de hijos
     */
    public ListaGenerica<Integer> nivel(int num) {
        /* crear lista en donde se va a devolver el resultado */
        ListaGenerica<Integer> resultado = new ListaGenerica<>();

        /* si el arbol es nulo o vacio devolvemos la lista vacia */
        if (arbolGeneral == null || arbolGeneral.isEmpty()) {
            return resultado;
        }

        /* Usar recorrido por niveles */
        /* crear la cola y agregar la raiz */
        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(arbolGeneral);

        /* Recorrido por niveles en arboles generales */
        while (!cola.isEmpty()) {
            int size = cola.size(); // Numeros de nodos en el nivel actual
            boolean cumpleCondicion = true;
            ListaGenerica<Integer> nivelActual = new ListaGenerica<>();

            for (int i = 0; i < size; i++) {
                GeneralTree<Integer> nodo = cola.poll();
                nivelActual.add(nodo.getData()); // agregar el nodo a la lista de nivel actual

                if (nodo.getChildren().size() < num) {
                    cumpleCondicion = false; // si el nodo no cumple la condicion
                }

                for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                    cola.add(hijo); // agregar los hijos a la cola
                }

            }
            if (cumpleCondicion) {
                return nivelActual;
            }
        }
        return resultado;
    }

}
