package Arboles.Clases;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private int valor;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }

    public GeneralTree(T data, int valor) {
        this.data = data;
        this.valor = valor;
    }

    public GeneralTree(T data, int valor, List<GeneralTree<T>> children) {
        this(data, valor);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }

    public int getValor() {
        return this.valor;
    }

    public int altura() {

        return 0;
    }

    public int nivel(T dato) {
        return 0;
    }

    public int ancho() {

        return 0;
    }

    public List<T> caminoPorValor() {
        List<T> camino = new LinkedList<T>();
        GeneralTree<T> nodoActual = this;

        while (nodoActual != null) {
            camino.add(nodoActual.getData());

            if (nodoActual.isLeaf()) {
                break; // si es hoja salimos del bucle
            }

            int valor = nodoActual.getValor();
            int indiceHijo = valor - 1;
            List<GeneralTree<T>> hijos = nodoActual.getChildren();

            if (indiceHijo < 0 || indiceHijo >= hijos.size()) {
                break; // si el indice no es valido salimos del bucle
            }

            nodoActual = hijos.get(indiceHijo);
        }
        return camino;
    }

}