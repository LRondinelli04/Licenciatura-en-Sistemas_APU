package Practica_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {

	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * 
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * 
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	/* indica si el arbol esta vacio */
	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}

	/* indica so el arbol no tiene hijos */
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}

	/* indica si tiene hijo izquierdo */
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	/* indica si tiene hijo derecho */
	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------------------------- EJERCICIO 2 ------------------------------------
	 * -----------------------------------------------------------------------------
	 */
	public int contarHojas() {
		/*
		 * recorrer el arbol completo hasta llegar a una hoja
		 * si es hoja, sumar a un contador 1
		 */
		if (this.isEmpty()) {
			return 0;
		}
		if (this.isLeaf()) {
			return 1;
		}
		int HI = 0;
		int HD = 0;
		if (this.hasLeftChild()) {
			HI = this.getLeftChild().contarHojas();
		}
		if (this.hasRightChild()) {
			HD = this.getRightChild().contarHojas();
		}

		return HI + HD;
	}

	/* Devuelve el arbol binario espejo del arbol receptor */
	public BinaryTree<T> espejo() {
		BinaryTree<T> espejo = new BinaryTree<T>(this.getData());

		if (this.hasLeftChild()) {
			espejo.addRightChild(this.getLeftChild().espejo());
		}
		if (this.hasRightChild()) {
			espejo.addLeftChild(this.getRightChild().espejo());
		}
		return espejo;
	}

	// 0<=n<=m
	public void entreNiveles(int n, int m) {
		if (n < 0 || m < n) {
			System.out.println("Los niveles deben cumplir 0 <= n <= m.");
			return;
		}

		// Usar una cola para el recorrido por niveles
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		Queue<Integer> niveles = new LinkedList<>();
		cola.add(this);
		niveles.add(0);

		System.out.println("Elementos entre el nivel " + n + " y " + m + ":");

		while (!cola.isEmpty()) {
			BinaryTree<T> nodoActual = cola.poll();
			int nivelActual = niveles.poll();

			// Si el nivel actual está dentro del rango, imprimir el dato
			if (nivelActual >= n && nivelActual <= m) {
				System.out.println("Nivel " + nivelActual + ": " + nodoActual.getData());
			}

			// Si el nivel actual supera m, detener el recorrido
			if (nivelActual > m) {
				break;
			}

			// Agregar los hijos a la cola con su nivel correspondiente
			if (nodoActual.hasLeftChild()) {
				cola.add(nodoActual.getLeftChild());
				niveles.add(nivelActual + 1);
			}
			if (nodoActual.hasRightChild()) {
				cola.add(nodoActual.getRightChild());
				niveles.add(nivelActual + 1);
			}
		}
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------------- EJERCICIO 3 : RECORRIDOS DE ÁRBOLES BÍNARIOS ----------------
	 * -----------------------------------------------------------------------------
	 */
	/* Números pares en PreOrden */
	public List<Integer> numeroParesPreOrden() {
		List<Integer> pares = new ArrayList<>();
		if (this.isEmpty()) {
			return pares;
		}
		this.PreOrdenPares(pares, (Integer) this.getData());
		return pares;
	}

	/* Números pares en InOrden */
	public List<Integer> numeroParesInOrden() {
		List<Integer> pares = new ArrayList<>();
		if (this.isEmpty()) {
			return pares;
		}
		this.InOrdenPares(pares, (Integer) this.getData());
		return pares;
	}

	/* Recorrido PreOrden que agrega solo números pares */
	private void PreOrdenPares(List<Integer> pares, int valor) {
		if (valor % 2 == 0) {
			pares.add(valor);
		}
		if (this.hasLeftChild()) {
			this.getLeftChild().PreOrdenPares(pares, (Integer) this.getLeftChild().getData());
		}
		if (this.hasRightChild()) {
			this.getRightChild().PreOrdenPares(pares, (Integer) this.getRightChild().getData());
		}
	}

	/* Recorrido InOrden que agrega solo números pares */
	private void InOrdenPares(List<Integer> pares, int valor) {
		if (this.hasLeftChild()) {
			this.getLeftChild().InOrdenPares(pares, (Integer) this.getLeftChild().getData());
		}
		if (valor % 2 == 0) {
			pares.add(valor);
		}
		if (this.hasRightChild()) {
			this.getRightChild().InOrdenPares(pares, (Integer) this.getRightChild().getData());
		}
	}

}
