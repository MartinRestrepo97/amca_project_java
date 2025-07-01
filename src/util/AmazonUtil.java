package util;

import java.util.Scanner;

/**
 * Clase de utilidades para validación de entrada de usuario.
 * Proporciona métodos para validar respuestas numéricas en menús.
 * 
 * @author AMCA Development Team
 * @version 1.0
 * @since 2024
 */
public class AmazonUtil {
	
	/** Scanner para lectura de entrada del usuario */
	private static Scanner scanner;

	/**
	 * Valida la respuesta del usuario en un menú numérico.
	 * Asegura que la entrada sea un número entero dentro del rango especificado.
	 * 
	 * @param min Valor mínimo permitido (inclusive)
	 * @param max Valor máximo permitido (inclusive)
	 * @return La respuesta validada del usuario
	 */
	public static int validarRespuestaMenu(int min, int max) {
		inicializarScanner();
		
		int respuesta;
		
		// Validar que la entrada sea un número entero
		while (!scanner.hasNextInt()) {
			scanner.next(); // Consumir entrada inválida
			System.out.println("Error: Debes ingresar un número válido.");
			System.out.println("Intenta nuevamente.");
			System.out.print("Opción: ");
		}
		
		respuesta = scanner.nextInt();
		
		// Validar que esté dentro del rango permitido
		while (respuesta < min || respuesta > max) {
			System.out.println("Error: La opción debe estar entre " + min + " y " + max + ".");
			System.out.println("Intenta nuevamente.");
			System.out.print("Opción: ");
			
			// Validar que la nueva entrada sea un número
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Error: Debes ingresar un número válido.");
				System.out.println("Intenta nuevamente.");
				System.out.print("Opción: ");
			}
			
			respuesta = scanner.nextInt();
		}
		
		System.out.println("Opción seleccionada: " + respuesta);
		System.out.println();
		
		return respuesta;
	}

	/**
	 * Valida si una cadena no está vacía o es nula.
	 * 
	 * @param texto Texto a validar
	 * @return true si el texto es válido, false en caso contrario
	 */
	public static boolean esTextoValido(String texto) {
		return texto != null && !texto.trim().isEmpty();
	}

	/**
	 * Valida si una cadena representa un número entero positivo.
	 * 
	 * @param numero Texto que representa el número
	 * @return true si es un número entero positivo válido
	 */
	public static boolean esNumeroEnteroPositivo(String numero) {
		try {
			int valor = Integer.parseInt(numero.trim());
			return valor > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Limpia una cadena eliminando espacios en blanco y caracteres especiales.
	 * 
	 * @param texto Texto a limpiar
	 * @return Texto limpio
	 */
	public static String limpiarTexto(String texto) {
		if (texto == null) {
			return "";
		}
		return texto.trim().replaceAll("[^a-zA-Z0-9\\s]", "");
	}

	/**
	 * Inicializa el scanner si no está inicializado.
	 */
	private static void inicializarScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
	}

	/**
	 * Cierra el scanner para liberar recursos.
	 */
	public static void cerrarScanner() {
		if (scanner != null) {
			scanner.close();
		}
	}

	/**
	 * Método original mantenido para compatibilidad.
	 * @deprecated Usar validarRespuestaMenu en su lugar
	 */
	@Deprecated
	public static int validateUserResponseMenu(int min, int max) {
		return validarRespuestaMenu(min, max);
	}
}
