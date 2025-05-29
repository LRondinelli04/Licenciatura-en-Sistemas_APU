import java.util.LinkedList;
import java.util.List;

import Parciales.GeneralTree;

public class ParcialArboles5 {

    private GeneralTree<Integer> arbol;

    public ParcialArboles5(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    /*
     * El metodo debe devolver el camino desde la raiz hasta la hoja en donde cada
     * nodo (No HOJA) tenga al menos la cantidad num de hijos. Debe retornar el
     * primer camino que encuentre que cumple la condicion. En caso de no encontralo
     * retorna la lista vacia.
     * 
     */

    public LinkedList<Integer> camino(int num) {
        LinkedList<Integer> camino = new LinkedList<>();
        if (arbol.isEmpty() || arbol == null) {
            return null;
        }
        if (arbol.isLeaf()) {
            return camino;
        }
        if (recorrerArbol(arbol, num, camino)) {
            return camino;
        }

        return null;

    }

    public boolean recorrerArbol(GeneralTree<Integer> arbol, int num, LinkedList<Integer> camino) {
        camino.add(arbol.getData());
        if (arbol.isLeaf()) {
            return true;
        }
        List<GeneralTree<Integer>> hijos = arbol.getChildren();
        if (hijos.size() < num) {
            camino.removeLast();
            return false;
        }
        for (GeneralTree<Integer> hijo : hijos) {
            if (recorrerArbol(hijo, num, camino)) {
                return true;
            }
        }

        camino.removeLast();
        return false;

    }

    public static void main(String[] args) {
        GeneralTree<Integer> raiz = new GeneralTree(10);
        GeneralTree<Integer> nodo8 = new GeneralTree(8);
        GeneralTree<Integer> nodo42 = new GeneralTree(42);
        GeneralTree<Integer> nodoMinus5 = new GeneralTree(-5);
        GeneralTree<Integer> nodo5 = new GeneralTree(5);
        GeneralTree<Integer> nodo22 = new GeneralTree(22);
        GeneralTree<Integer> nodo19 = new GeneralTree(19);
        GeneralTree<Integer> nodoMinus9 = new GeneralTree(-9);
        GeneralTree<Integer> nodo6 = new GeneralTree(6);
        GeneralTree<Integer> nodo28 = new GeneralTree(28);
        GeneralTree<Integer> nodo55 = new GeneralTree(55);
        GeneralTree<Integer> nodo18 = new GeneralTree(18);
        GeneralTree<Integer> nodo4 = new GeneralTree(4);

        raiz.addChild(nodo8);
        raiz.addChild(nodo42);
        raiz.addChild(nodoMinus5);

        nodo8.addChild(nodo5);
        nodo8.addChild(nodo22);
        nodoMinus5.addChild(nodo19);
        nodoMinus5.addChild(nodoMinus9);

        nodo5.addChild(nodo6);
        nodo22.addChild(nodo28);
        nodo22.addChild(nodo55);
        nodo22.addChild(nodo18);
        nodo19.addChild(nodo4);

        ParcialArboles5 arbol = new ParcialArboles5(raiz);
        LinkedList<Integer> camino = arbol.camino(2);

        if (camino != null) {
            for (int i = 0; i < camino.size(); i++) {
                System.out.print(camino.get(i) + " ");
            }
        } else {
            System.out.println("No se encontró un camino que cumpla la condición.");
        }

    }

}
