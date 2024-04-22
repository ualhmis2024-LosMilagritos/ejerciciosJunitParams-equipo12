package ual.hmis.sesion05.ejercicio4;

import org.junit.jupiter.params.provider.CsvFileSource;
import ual.hmis.sesion05.ejercicio4.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio4Test {

	@ParameterizedTest(name = "Mezclar {0} con {1}")
//	@CsvFileSource(resources = "ejercicio4.csv", delimiter = ';')
	@CsvSource({
		"'','',''",
		"'','2,4,6,8,10','2,4,6,8,10'",
		"'1,3,5,7,9','','1,3,5,7,9'",
		"'1,3,15,7,9','2,4,6,8,10','1,2,3,4,6,7,8,9,10,15'",
		"'3,1,5,7,9','3,4,5,8,10','1,3,3,4,5,5,7,8,9,10'",
		"'1.5,2.5,3.5','4.5,5.5','1.5,2.5,3.5,4.5,5.5'",
		"'azul,celeste,negro','blanco,rojo','azul,blanco,celeste,negro,rojo'"
	})


	void testMezclarArraysOrdenados(String array1, String array2, String expected) {
		Ejercicio4 c = new Ejercicio4();
		Comparable[] intArray1 = parseIntArray(array1);
		Comparable[] intArray2 = parseIntArray(array2);
		Comparable[] expectedArray = parseIntArray(expected);

		Comparable[] resultado = c.MeclaLineal(intArray1, intArray2);
		assertArrayEquals(expectedArray, resultado);
	}

	Comparable[] parseIntArray(String arrayStr) {
		if (arrayStr.isEmpty()) {
			return new Comparable[0];
		}
		String[] parts = arrayStr.split(",");
		Comparable[] array = new Comparable[parts.length];
		for (int i = 0; i < parts.length; i++) {
	        String part = parts[i].trim(); // Eliminar espacios en blanco alrededor del elemento
	        try {
	            // Intentar convertir a Integer
	            array[i] = Integer.parseInt(part);
	        } catch (NumberFormatException e) {
	            try {
	                // Intentar convertir a Double
	                array[i] = Double.parseDouble(part);
	            } catch (NumberFormatException ex) {
	                // Si no es un número, se asume que es una cadena
	                array[i] = part;
	            }
	        }
	    }
		return array;
	}
}
