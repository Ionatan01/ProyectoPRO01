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
		//Director director = new Director(nomString, cognomString, poblacioString,
		//		peliculasArrayListGeneral.size() + 1);

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

		for (int i = 0; i < peliculasArrayList.size(); i++) {
			Pelicula pelicula = peliculasArrayList.get(i);
			String separadorString = "";
			for (int j = 0; j < pelicula.toString().length(); j++) {
				separadorString += "-";
			}
			System.out.println("\n\n\n" + separadorString + "\n\n" + pelicula.toString() + "\n\n" + separadorString);
		}
	}
}
