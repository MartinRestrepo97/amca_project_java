package amca;

import java.util.ArrayList;
import java.util.List;

import modelo.Animales;
import modelo.Cultivos;
import modelo.Preparados;
import modelo.SectorProductivo;
import util.AmazonUtil;

/**
 * Clase principal de la aplicación AMCA (Apoyo al Mercado Campesino Agrícola).
 * Proporciona la interfaz de consola para gestionar productos agrícolas.
 * 
 * @author AMCA Development Team
 * @version 1.0
 * @since 2024
 */
public class Main {

	/** Lista de cultivos cargada desde el modelo */
	private static List<Cultivos> cultivos = Cultivos.obtenerListaCultivos();
	
	/** Lista de animales cargada desde el modelo */
	private static List<Animales> animales = Animales.listaAnimales();
	
	/** Lista de preparados cargada desde el modelo */
	private static List<Preparados> preparados = Preparados.listaPreparados();
	
	/** Lista de sectores productivos cargada desde el modelo */
	private static List<SectorProductivo> sectorProductivo = SectorProductivo.listaSectorProductivo();

	/**
	 * Método principal de la aplicación.
	 * 
	 * @param args Argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		mostrarMenu();
	}

	/**
	 * Muestra el menú principal de la aplicación.
	 */
	public static void mostrarMenu() {
		int opcionSalida = 0;
		
		do {
			mostrarOpcionesMenu();
			
			// Leer la respuesta del usuario
			int respuesta = AmazonUtil.validarRespuestaMenu(0, 4);

			switch (respuesta) {
				case 0:
					// Salir
					opcionSalida = 0;
					System.out.println("¡Gracias por usar AMCA!");
					break;
				case 1:
					mostrarCultivos();
					break;
				case 2:
					mostrarAnimales();
					break;
				case 3:
					mostrarPreparados();
					break;
				case 4:
					mostrarSectorProductivo();
					break;
				default:
					System.out.println();
					System.out.println("....¡Selecciona una opción válida!!....");
					System.out.println();
					break;
			}
			
		} while (opcionSalida != 0);
	}
	
	/**
	 * Muestra las opciones del menú principal.
	 */
	private static void mostrarOpcionesMenu() {
		System.out.println("==========================================");
		System.out.println("  APOYO AL MERCADO CAMPESINO AGRÍCOLA");
		System.out.println("==========================================");
		System.out.println();
		System.out.println("Selecciona el número de la opción deseada:");
		System.out.println("1. Cultivos");
		System.out.println("2. Animales");
		System.out.println("3. Preparados");
		System.out.println("4. Sector Productivo");
		System.out.println("0. Salir");
		System.out.println();
		System.out.print("Opción: ");
	}

	/**
	 * Muestra la información de cultivos.
	 */
	public static void mostrarCultivos() {
		int opcionSalida = 1;
		
		do {
			System.out.println();
			System.out.println("==========================================");
			System.out.println("                CULTIVOS");
			System.out.println("==========================================");
			System.out.println("Nombre\t\t\tHectáreas");
			System.out.println("------------------------------------------");
			
			for (int i = 0; i < cultivos.size(); i++) {
				Cultivos cultivo = cultivos.get(i);
				System.out.printf("%d. %-20s %d hectáreas%n", 
					i + 1, cultivo.getNombre(), cultivo.getExtended());
			}
			
			System.out.println("0. Regresar al menú principal");
			System.out.println();
			
			int respuesta = AmazonUtil.validarRespuestaMenu(0, cultivos.size());
			if (respuesta == 0) {
				opcionSalida = 0;
			}
			
		} while (opcionSalida != 0);
	}

	/**
	 * Muestra la información de preparados.
	 */
	public static void mostrarPreparados() {
		int opcionSalida = 1;
		
		do {
			System.out.println();
			System.out.println("==========================================");
			System.out.println("               PREPARADOS");
			System.out.println("==========================================");
			System.out.println("Finca\t\tTipo\t\tProducto\t\tCantidad");
			System.out.println("------------------------------------------");
			
			for (int i = 0; i < preparados.size(); i++) {
				Preparados preparado = preparados.get(i);
				System.out.printf("%d. %-15s %-15s %-20s %s%n", 
					i + 1, 
					preparado.getNombreFinca(), 
					preparado.getTipo(), 
					preparado.getNombreProducto(), 
					preparado.getCantidad());
			}
			
			System.out.println("0. Regresar al menú principal");
			System.out.println();
			
			int respuesta = AmazonUtil.validarRespuestaMenu(0, preparados.size());
			if (respuesta == 0) {
				opcionSalida = 0;
			}
			
		} while (opcionSalida != 0);
	}

	/**
	 * Muestra la información de animales.
	 */
	public static void mostrarAnimales() {
		int opcionSalida = 1;
		
		do {
			System.out.println();
			System.out.println("==========================================");
			System.out.println("                ANIMALES");
			System.out.println("==========================================");
			System.out.println("Nombre\t\t\tCantidad");
			System.out.println("------------------------------------------");
			
			for (int i = 0; i < animales.size(); i++) {
				Animales animal = animales.get(i);
				System.out.printf("%d. %-20s %d unidades%n", 
					i + 1, animal.getNombre(), animal.getCantidad());
			}
			
			System.out.println("0. Regresar al menú principal");
			System.out.println();
			
			int respuesta = AmazonUtil.validarRespuestaMenu(0, animales.size());
			if (respuesta == 0) {
				opcionSalida = 0;
			}
			
		} while (opcionSalida != 0);
	}

	/**
	 * Muestra la información de sectores productivos.
	 */
	public static void mostrarSectorProductivo() {
		int opcionSalida = 1;
		
		do {
			System.out.println();
			System.out.println("==========================================");
			System.out.println("           SECTOR PRODUCTIVO");
			System.out.println("==========================================");
			System.out.println("Nombre\t\t\tHectáreas");
			System.out.println("------------------------------------------");
			
			for (int i = 0; i < sectorProductivo.size(); i++) {
				SectorProductivo sector = sectorProductivo.get(i);
				System.out.printf("%d. %-20s %d hectáreas%n", 
					i + 1, sector.getNombre(), sector.getExtended());
			}
			
			System.out.println("0. Regresar al menú principal");
			System.out.println();
			
			int respuesta = AmazonUtil.validarRespuestaMenu(0, sectorProductivo.size());
			if (respuesta == 0) {
				opcionSalida = 0;
			}
			
		} while (opcionSalida != 0);
	}
}
	
