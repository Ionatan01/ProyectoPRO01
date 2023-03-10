package com.projecte.classes;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.projecte.utils.Registre;

public class CrearPeliculaUsuarioGlobal {
	public static ArrayList<Pelicula> leerFitxeroPeliculas(String ruta) {
		ArrayList<Pelicula> peliculasArrayList = new ArrayList<>();

		try {
			FileInputStream file = new FileInputStream(ruta);
			if (file.available() != 0) {
				ObjectInputStream reader = new ObjectInputStream(file);
				peliculasArrayList = (ArrayList<Pelicula>) reader.readObject();
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe.");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculasArrayList;
	}

	public static void agregarPelicula(Integer id, String nom) {

		String rutaGeneralString = "dades/pelicules.dades";
		String rutaPersonalString = "usuarios/" + id + nom + "/pelicules" + nom + ".llista";

		ArrayList<Pelicula> peliculasArrayListGeneral = leerFitxeroPeliculas(rutaGeneralString);
		ArrayList<Pelicula> peliculasArrayListPersonal = leerFitxeroPeliculas(rutaPersonalString);

		Scanner leerScanner = new Scanner(System.in);
		System.out.print("Titulo de la pelicula: ");
		String titulo = Registre.demanarNom(leerScanner);
		System.out.print("Año de la pelicula: ");
		int ano = Registre.demanarEnter(leerScanner);
		System.out.print("Director de la pelicula: ");
		String directorPelicula = Registre.demanarNom(leerScanner);
		System.out.print("Genero de la pelicula: ");
		String genero = Registre.demanarNom(leerScanner);

		Pelicula pelicula = new Pelicula(titulo, ano, directorPelicula, genero);
		// Director director = new Director(nomString, cognomString, poblacioString,
		// peliculasArrayListGeneral.size() + 1);

		peliculasArrayListGeneral.add(pelicula);
		peliculasArrayListPersonal.add(pelicula);

		guardarPeliculasGlobal(rutaGeneralString, peliculasArrayListGeneral);
		guardarPeliculasGlobal(rutaPersonalString, peliculasArrayListPersonal);

	}

	public static void guardarPeliculasGlobal(String ruta, ArrayList<Pelicula> directoresArrayList) {
		try {
			OutputStream file = new FileOutputStream(ruta);
			OutputStream bufffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(bufffer);
			output.writeObject(directoresArrayList);
			output.close();
			bufffer.close();
		} catch (IOException e) {
			System.out.println("Error al guardar los peliculas en el archivo pelicules.dades.");
			e.printStackTrace();
		}
	}

	public static void listarPeliculas(int id, String nom) {
		String rutaPersonalString = "usuarios/" + id + nom + "/pelicules" + nom + ".llista";
		ArrayList<Pelicula> peliculasArrayList = leerFitxeroPeliculas(rutaPersonalString);

		if (peliculasArrayList.size() < 1) {
			System.out.println("--> Aún no has añadido ninguna pelicula");
		} else {
			for (int i = 0; i < peliculasArrayList.size(); i++) {
				Pelicula pelicula = peliculasArrayList.get(i);
				String separadorString = "";
				for (int j = 0; j < pelicula.toShortString().length() + 4; j++) {
					separadorString += "-";
				}
				System.out.println((i + 1) + " - " + pelicula.toShortString() + "\n" + separadorString);
			}

			System.out.println(
					"\nPulsa 0 para salir al menu principal o selecciona una pelicula para ver mas informacion");
			int num = elegirOpcionMenu(0, peliculasArrayList.size());
			if (num != 0) {
				System.out.println("\n" + peliculasArrayList.get((num - 1)).toLongString());
			}
		}
	}

	public static int elegirOpcionMenu(int min, int max) {
		Scanner leerOpcion = new Scanner(System.in);
		int numEleccion = 0;
		do {
			System.out.print("Opcion (" + min + "-" + max + "): ");
			while (!leerOpcion.hasNextInt()) {
				System.out.println("::ERROR:: Escribe un numero correcto (" + min + "-" + max + ")");
				leerOpcion.next();
			}
			numEleccion = leerOpcion.nextInt();
			if (numEleccion < min || numEleccion > max) {
				System.out.println("::ERROR:: Escribe un numero correcto (" + min + "-" + max + ")");
			}
		} while (numEleccion < min || numEleccion > max);
		return numEleccion;
	}
}
