package com.projecte.utils;

import java.util.Scanner;

import com.projecte.classes.CrearActorUsuarioGlobal;
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

	public static void limpiarConsola() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void menuPrincipalLoginRegistre() {
		limpiarConsola();
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
				System.out.println("\nMostrando listado de películas: \n");
				CrearPeliculaUsuarioGlobal.listarPeliculas(id, nomCorreo);
				break;
			case 2:
				System.out.println("\nMostrando listado de actores: \n");
				CrearActorUsuarioGlobal.listarActores(id, nomCorreo);

				break;
			case 3:
				System.out.println("\nMostrando listado de directores: \n");
				CrearDirectorUsuarioGlobal.listarDirectores(id, nomCorreo);
				break;
			case 4:
				CrearPeliculaUsuarioGlobal.agregarPelicula(id, nomCorreo);
				System.out.println("Pelicula añadida!");
				break;
			case 5:
				CrearActorUsuarioGlobal.agregarActor(id, nomCorreo);
				System.out.println("Actor añadido!");
				break;
			case 6:
				CrearDirectorUsuarioGlobal.agregarDirector(id, nomCorreo);
				System.out.println("Director añadido!");
				break;
			case 7:
				salir = true;
				System.out.println("Adios " + nom + ", Nos vemos pronto!");
				break;

			}
		}

	}

}
