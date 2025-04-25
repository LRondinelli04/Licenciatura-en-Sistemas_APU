import java.util.List;

import Practica_3.GeneralTree;

public class RecorridosAGTest {
    public static void main(String[] args) {
        GeneralTree<Integer> arbol = new GeneralTree<>(13);
        GeneralTree<Integer> nodo1 = new GeneralTree<>(15);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(21);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(53);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(17);


        arbol.addChild(nodo1);
        arbol.addChild(nodo2);
        nodo1.addChild(nodo3);
        nodo1.addChild(nodo4);
        nodo1.addChild(nodo5);


        RecorridosAG recorridos = new RecorridosAG();
        List<Integer> resultado = recorridos.numerosImparesMayoresQuePreOrden(arbol, 0);
        System.out.println("PREORDEN: " + resultado); // Debería imprimir: [15, 21, 17]

        System.out.println("-----------------");

        List<Integer> resultado2 = recorridos.numerosImparesMayoresQueInOrden(arbol, 0);
        System.out.println("INORDEN: " + resultado2); // Debería imprimir: [15, 21, 17]

        System.out.println("-----------------");

        List<Integer> resultado3 = recorridos.numerosImparesMayoresQuePostOrden(arbol, 0);
        System.out.println("POSTORDEN: " + resultado3); // Debería imprimir: [15, 21, 17]

        System.out.println("-----------------");
    }
}
