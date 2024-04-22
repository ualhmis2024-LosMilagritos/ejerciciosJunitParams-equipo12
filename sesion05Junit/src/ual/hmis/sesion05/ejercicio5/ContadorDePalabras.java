package ual.hmis.sesion05.ejercicio5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ContadorDePalabras {

	public ContadorDePalabras(String[] ejemplo) {
	}


	public String[] palabrasOrdenadasAlfabeticamente(String lista) {
		String[] listaPalabras = lista.split(",");
		ordenacionInsercion(listaPalabras);
		return listaPalabras;
	}


	public String[] palabrasOrdenadasNumeroOcurrencias(String[] lista) {
		Map<String, Integer> contadorOcurrencias = new HashMap<>();
		for (String palabra : lista) {
			contadorOcurrencias.put(palabra, contadorOcurrencias.getOrDefault(palabra, 0) + 1);
		}
		
		Comparator<String> comparadorPorOcurrencias = Comparator.comparingInt(contadorOcurrencias::get);
		Arrays.sort(lista, comparadorPorOcurrencias.reversed());
		return lista;
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
