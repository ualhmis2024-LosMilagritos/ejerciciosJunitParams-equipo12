package ual.hmis.sesion05.ejercicio4;
import java.util.Arrays;

public class Ejercicio4<T extends Comparable<T>> {
	
	public static Comparable[] MeclaLineal(Comparable[] array1, Comparable[] array2) {
		ordenacionInsercion(array1);
		ordenacionInsercion(array2);
		int totalLength = array1.length + array2.length;
		Comparable[] resultado = Arrays.copyOf(array1, totalLength);

		int i = array1.length - 1; // Índice para el final de array1
		int j = array2.length - 1; // Índice para el final de array2
		int k = totalLength - 1;   // Índice para el final de resultado

		// Combinar los dos arrays en el array resultado de manera ordenada
		while (i >= 0 && j >= 0) {
			if (array1[i].compareTo(array2[j]) >= 0) {
				resultado[k--] = array1[i--];
			} else {
				resultado[k--] = array2[j--];
			}
		}

		// Agregar los elementos restantes de array1 (si los hay)
		while (i >= 0) {
			resultado[k--] = array1[i--];
		}

		// Agregar los elementos restantes de array2 (si los hay)
		while (j >= 0) {
			resultado[k--] = array2[j--];
		}
		
		ordenacionInsercion(resultado);
		return resultado;
	}
	
	public static void ordenacionInsercion(Comparable[] array) {
		for (int i = 1; i < array.length; ++i) {
			Comparable aux = array[i];
			int j;
			for (j = i - 1 ; (j >= 0) && (aux.compareTo(array[j]) < 0); j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = aux;
		}
	}
}
