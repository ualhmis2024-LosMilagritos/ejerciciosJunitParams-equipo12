package ual.hmis.sesion05.ejercicio3;

import ual.hmis.sesion05.ejercicio3.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class Ejercicio3Test {

	@CsvFileSource(resources = "ejercicio3.csv", delimiter = ';')
	@ParameterizedTest(name = "{index} => Con password ({0}) sale {1}")
	void testEncrypted_parametrized(String password, String result) {

		// Arrange
		Ejercicio3 e3 = new Ejercicio3();
		String resultencrypted = e3.encrypted(password);
		// Act
		// Assert
		if (password.length() < 5 || password.length() > 40) {
			assertNull(resultencrypted);

		} else if (password.length() >= 5 && password.length() <= 8) {
			assertNotNull(result); // Verificar que el resultado no sea null para contraseñas de longitud válida
			assertEquals(resultencrypted.length(), result.length()); // Verificar longitud de la cadena cifrada
			assertEquals(resultencrypted, result); // Verificar la cadena cifrada

		} else if (password.length() >= 12 && password.length() <= 40) {
			assertNotNull(result); // Verificar que el resultado no sea null para contraseñas de longitud válida
			assertEquals("************", resultencrypted); // Verificar la cadena cifrada
		}

	}

}
