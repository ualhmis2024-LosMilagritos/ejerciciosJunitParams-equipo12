package ual.hmis.sesion05.ejercicio5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio5Test {

    @ParameterizedTest(name = "Contar y ordenar palabras de {0}")
    @CsvFileSource(resources = "ejercicio5.csv", delimiter = ';')
    void testContadorDePalabras(String lista) {
        ContadorDePalabras contador = new ContadorDePalabras(lista);

        // Obtener palabras de la lista
        String[] palabras = lista.split(",");

        // Verificar orden alfabético
        String[] palabrasOrdenadasAlfabeticamente = contador.palabrasOrdenadasAlfabeticamente(lista);
        assertArrayEquals(obtenerPalabrasOrdenadasAlfabeticamente(palabras), palabrasOrdenadasAlfabeticamente);

        // Verificar orden por número de ocurrencias (de mayor a menor)
        String[] palabrasOrdenadasPorOcurrencias = contador.palabrasOrdenadasNumeroOcurrencias(palabras);
        verificarOrdenPorOcurrencias(palabras, palabrasOrdenadasPorOcurrencias);
    }

    // Método para obtener palabras ordenadas alfabéticamente
    private String[] obtenerPalabrasOrdenadasAlfabeticamente(String[] palabras) {
        Arrays.sort(palabras);
        return palabras;
    }

 // Método para verificar el orden por número de ocurrencias
    private void verificarOrdenPorOcurrencias(String[] palabras, String[] palabrasOrdenadasPorOcurrencias) {
        Map<String, Integer> contadorOcurrencias = new HashMap<>();
        for (String palabra : palabras) {
            contadorOcurrencias.put(palabra, contadorOcurrencias.getOrDefault(palabra, 0) + 1);
        }

        // Comprobar orden por número de ocurrencias y alfabético si las ocurrencias son iguales
        for (int i = 0; i < palabrasOrdenadasPorOcurrencias.length - 1; i++) {
            String palabraActual = palabrasOrdenadasPorOcurrencias[i];
            String palabraSiguiente = palabrasOrdenadasPorOcurrencias[i + 1];

            // Obtener las ocurrencias de las palabras actual y siguiente
            int ocurrenciasActual = contadorOcurrencias.getOrDefault(palabraActual, 0);
            int ocurrenciasSiguiente = contadorOcurrencias.getOrDefault(palabraSiguiente, 0);

         // Verificar el orden por número de ocurrencias (de mayor a menor)
            assertTrue(ocurrenciasActual > ocurrenciasSiguiente|| 
            		(ocurrenciasActual == ocurrenciasSiguiente && palabraActual.compareTo(palabraSiguiente) <= 0));
        }
    }

}
