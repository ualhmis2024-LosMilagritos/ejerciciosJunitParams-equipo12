package ual.hmis.sesion05.ejercicio5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class Ejercicio5Test {

    @ParameterizedTest(name = "Contar y ordenar palabras de {0}")
    @CsvFileSource(resources = "ejercicio5.csv", delimiter = ';')
    void testContadorDePalabras(String lista) {
        ContadorDePalabras c = new ContadorDePalabras(lista);

        // Test palabrasOrdenadasAlfabeticamente
        String[] palabrasOrdenadas = c.palabrasOrdenadasAlfabeticamente(lista);
        Arrays.sort(palabrasOrdenadas); // Ordenar la lista original alfabéticamente

        // Verificar que la longitud sea la misma que la lista original
        assertEquals(lista.split(",").length, palabrasOrdenadas.length);

        // Verificar que las palabras estén ordenadas alfabéticamente
        for (int i = 0; i < palabrasOrdenadas.length - 1; i++) {
            assertTrue(palabrasOrdenadas[i].compareTo(palabrasOrdenadas[i + 1]) <= 0);
        }

        // Test palabrasOrdenadasNumeroOcurrencias
        String[] palabras = lista.split(",");
        String[] palabrasOrdenadasPorOcurrencias = c.palabrasOrdenadasNumeroOcurrencias(palabras);

        // Verificar que la longitud sea la misma que la lista original
        assertEquals(palabras.length, palabrasOrdenadasPorOcurrencias.length);

        // Verificar que las palabras estén ordenadas por número de ocurrencias (de mayor a menor)
        int[] ocurrencias = new int[palabras.length];
        for (int i = 0; i < palabras.length; i++) {
            ocurrencias[i] = contarOcurrencias(palabras, palabras[i]);
        }

        // Comprobar orden por número de ocurrencias
        for (int i = 0; i < palabrasOrdenadasPorOcurrencias.length - 1; i++) {
            int index1 = Arrays.asList(palabras).indexOf(palabrasOrdenadasPorOcurrencias[i]);
            int index2 = Arrays.asList(palabras).indexOf(palabrasOrdenadasPorOcurrencias[i + 1]);
            assertTrue(ocurrencias[index1] >= ocurrencias[index2]);
        }
    }

    // Método para contar ocurrencias de una palabra en un array
    private int contarOcurrencias(String[] palabras, String palabra) {
        int count = 0;
        for (String p : palabras) {
            if (p.equals(palabra)) {
                count++;
            }
        }
        return count;
    }
}
