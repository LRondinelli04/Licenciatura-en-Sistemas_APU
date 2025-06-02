package Arboles.Parcial_Arboles;
import Arboles.Clases.GeneralTree;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/* Parcial tema 4 10/05/2025
 * Recorrer un arbol general y devolver en una lista el primer camino que se encuentre que cumpla la siguientes condiciones:
 * - El camino tiene que ser intercalado por valores que terminan en 0 y el siguiente por un valor que no termine en 0 
 * - Si por ejemplo tenemos la raiz 20, el siguiente nodo es 3 y el siguiente nodo es 42, no es valido
 * - Si por ejemplo tenemos la raiz 20, el siguiente nodo es 3 y el siguiente nodo es 40, es valido o si la raiz es 3, el siguiente nodo es 40 y el siguiente nodo es 21, es valido 
 * - Solamente agregar el metodo que pide en el parcial, no hay que instanciar variables ni clases dentro de la clase.
 * - Se pueden crear los metodos y variables locales que crea necesarias
 * - Si no se encuentra ningun camino que cumpla la condicion, devolver una lista vacia
 */

public class Parcial {

    public List<Integer> buscarIntercaladoCeroYSinCero(GeneralTree<Integer> arbol) {
        LinkedList<Integer> camino = new LinkedList<>();
        if (arbol.isEmpty() || arbol.isLeaf() || arbol == null) {
            return camino;
        }
        if (arbol.getData() % 10 == 0) {
            recorrerConCero(arbol, camino);
        } else {
            recorrerSinCero(arbol, camino);
        }

        return camino;
    }

    public boolean recorrerConCero(GeneralTree<Integer> arbol, LinkedList<Integer> camino) {
        camino.add(arbol.getData());
        if (arbol.getData() % 10 == 0) {
            if (arbol.isLeaf()) {
                return true;
            }
            List<GeneralTree<Integer>> hijos = arbol.getChildren();
            for (GeneralTree<Integer> hijo : hijos) {
                if (recorrerSinCero(hijo, camino)) {
                    return true;
                }
            }
        }
        camino.removeLast();
        return false;
    }

    public boolean recorrerSinCero(GeneralTree<Integer> arbol, LinkedList<Integer> camino) {
        camino.add(arbol.getData());
        if (arbol.getData() % 10 != 0) {
            if (arbol.isLeaf()) {
                return true;
            }
            List<GeneralTree<Integer>> hijos = arbol.getChildren();
            for (GeneralTree<Integer> hijo : hijos) {
                if (recorrerConCero(hijo, camino)) {
                    return true;
                }
            }
        }
        camino.removeLast();
        return false;
    }

}