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

public class CrearDirectorUsuarioGlobal {

	public static ArrayList<Director> leerFitxeroDirectores(String ruta) {
		ArrayList<Director> directoresArrayList = new ArrayList<>();

		try {
			FileInputStream file = new FileInputStream(ruta);
			if (file.available() != 0) {
				ObjectInputStream reader = new ObjectInputStream(file);
				directoresArrayList = (ArrayList<Director>) reader.readObject();
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
		return directoresArrayList;
	}

	public static void agregarDirector(Integer id, String nom) {

		String rutaGeneralString = "dades/directors.dades";
		String rutaPersonalString = "usuarios/" + id + nom + "/directors" + nom + ".llista";

		ArrayList<Director> directoresArrayListGeneral = leerFitxeroDirectores(rutaGeneralString);
		ArrayList<Director> directoresArrayListPersonal = leerFitxeroDirectores(rutaPersonalString);

		Scanner leerScanner = new Scanner(System.in);
		System.out.print("Nombre del director: ");
		String nomString = Registre.demanarNom(leerScanner);
		System.out.print("Apellido del director: ");
		String cognomString = Registre.demanarNom(leerScanner);
		System.out.print("Nacionalidad del director: ");
		String poblacioString = Registre.demanarNom(leerScanner);

		Director director = new Director(nomString, cognomString, poblacioString,
				directoresArrayListGeneral.size() + 1);

		directoresArrayListGeneral.add(director);
		directoresArrayListPersonal.add(director);

		guardarDirectoresGlobal(rutaGeneralString, directoresArrayListGeneral);
		guardarDirectoresGlobal(rutaPersonalString, directoresArrayListPersonal);

	}

	public static void guardarDirectoresGlobal(String ruta, ArrayList<Director> directoresArrayList) {
		try {
			OutputStream file = new FileOutputStream(ruta);
			OutputStream bufffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(bufffer);
			output.writeObject(directoresArrayList);
			output.close();
			bufffer.close();
		} catch (IOException e) {
			System.out.println("Error al guardar los directores en el archivo directores.dades.");
			e.printStackTrace();
		}
	}

	public static void listarDirectores(int id, String nom) {
		String rutaPersonalString = "usuarios/" + id + nom + "/directors" + nom + ".llista";
		ArrayList<Director> directoresArrayList = leerFitxeroDirectores(rutaPersonalString);
		if (directoresArrayList.size() < 1) {
			System.out.println("--> Aún no has añadido ningun actor");
		} else {
			for (int i = 0; i < directoresArrayList.size(); i++) {
				Director director = directoresArrayList.get(i);
				String separadorString = "";
				for (int j = 0; j < director.toShortString().length() + 4; j++) {
					separadorString += "-";
				}
				System.out.println((i + 1) + " - " + director.toShortString() + "\n" + separadorString);
			}

			System.out.println(
					"\nPulsa 0 para salir al menu principal o selecciona un director para ver mas informacion");
			int num = elegirOpcionMenu(0, directoresArrayList.size());
			if (num != 0) {
				System.out.println("\n" + directoresArrayList.get((num - 1)).toLongString());
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