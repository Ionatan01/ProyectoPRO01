package com.projecte.utils;

import java.util.Scanner;

import com.projecte.classes.CrearDirectorUsuarioGlobal;
import com.projecte.classes.CrearPeliculaUsuarioGlobal;

public class Menus {
	static Scanner leerOpcionMenu = new Scanner(System.in);

	public static int elegirOpcionMenu(int min, int max) {
		int numEleccion = 0;
		do {
			System.out.print("Opcion (" + min + "-" + max + "): ");
			while (!leerOpcionMenu.hasNextInt()) {
				System.out.println("::ERROR:: Escribe un numero correcto (" + min + "-" + max + ")");
				leerOpcionMenu.next();
			}
			numEleccion = leerOpcionMenu.nextInt();
			if (numEleccion < min || numEleccion > max) {
				System.out.println("::ERROR:: Escribe un numero correcto (" + min + "-" + max + ")");
			}
		} while (numEleccion < min || numEleccion > max);
		return numEleccion;
	}

	public static void menuPrincipalLoginRegistre() {
		System.out.println("\n---- Menu ---- ");
		System.out.println("1.- Registre");
		System.out.println("2.- Login");
		System.out.println("3.- salir");

	}

	public static void menuLogeado(int id, String nom, String cognoms, String nomCorreo) {
		boolean salir = false;

		while (!salir) {
			System.out.println("\n¡Bienvenido, " + nom + " " + cognoms + "!");
			System.out.println("\n\t---- Menu ---- ");
			System.out.println("1. Ver listado de películas");
			System.out.println("2. Ver listado de actores");
			System.out.println("3. Ver listado de directores");
			System.out.println("4. Añadir película");
			System.out.println("5. Añadir actor");
			System.out.println("6. Añadir director");
			System.out.println("7. Salir");

			switch (elegirOpcionMenu(1, 7)) {
			case 1:
				// mostrarPeliculas(nom);
				System.out.println("Mostrando listado de películas...");
				CrearPeliculaUsuarioGlobal.listarPeliculas(id, nomCorreo);;
				break;
			case 2:
				// mostrarActores(nom);
				System.out.println("Mostrando listado de actores...");
				break;
			case 3:
				// mostrarDirectores(nom);
				System.out.println("Mostrando listado de directores: ");
				CrearDirectorUsuarioGlobal.listarDirectores(id, nomCorreo);
				break;
			case 4:
				// AñadirPeliculas(nom);
				System.out.println("Añadiendo película...");
				CrearPeliculaUsuarioGlobal.agregarPelicula(id, nomCorreo);;
				break;
			case 5:
				// AñadirActor(nom);
				System.out.println("Añadiendo actor...");
				break;
			case 6:
				// AñadirDirector(nom);
				CrearDirectorUsuarioGlobal.agregarDirector(id, nomCorreo);
				System.out.println("Director añadido!");
				break;
			case 7:
				salir = true;
				System.out.println("Adios");
				break;

			}
		}

	}

}
