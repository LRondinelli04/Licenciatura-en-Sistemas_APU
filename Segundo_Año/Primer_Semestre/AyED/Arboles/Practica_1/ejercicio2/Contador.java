package Practica_1.ejercicio2;

import java.util.Scanner;

public class Contador {

	public static int[] generarMultiplos(int n) {
		// crear el array
		int[] multiplos = new int[n];
		// cargar los multiplos de ese numero con el maximo de n indices
		for (int i = 0; i < n; i++) {
			multiplos[i] = n * (i + 1);
		}
		
		return multiplos;
	}
	
	// Metodo para probar el ingreso de multiplos
	public static void probarMultiplos() {
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		int n = s.nextInt(); // valor que se ingresa por teclado
		
		// Generar los multiplos
		int[] resultado = generarMultiplos(n);
		
		// Mostrar resultado
		System.out.print("Los primeros " + n + " multiplos de " + n + " son: [");
		for (int i = 0; i < resultado.length; i++) {
			System.out.print(resultado[i]);
			if (i < resultado.length - 1) {				
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
	
}
