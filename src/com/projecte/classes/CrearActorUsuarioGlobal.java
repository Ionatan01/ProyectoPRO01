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

public class CrearActorUsuarioGlobal {

	public static ArrayList<Actor> leerFitxeroActores(String ruta) {
		ArrayList<Actor> actoresArrayList = new ArrayList<>();

		try {
			FileInputStream file = new FileInputStream(ruta);
			if (file.available() != 0) {
				ObjectInputStream reader = new ObjectInputStream(file);
				actoresArrayList = (ArrayList<Actor>) reader.readObject();
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
		return actoresArrayList;
	}

	public static void agregarActor(Integer id, String nom) {

		String rutaGeneralString = "dades/actors.dades";
		String rutaPersonalString = "usuarios/" + id + nom + "/actors" + nom + ".llista";

		ArrayList<Actor> directoresArrayListGeneral = leerFitxeroActores(rutaGeneralString);
		ArrayList<Actor> directoresArrayListPersonal = leerFitxeroActores(rutaPersonalString);

		Scanner leerScanner = new Scanner(System.in);
		System.out.print("Nombre del actor: ");
		String nomString = Registre.demanarNom(leerScanner);
		System.out.print("Apellido del actor: ");
		String cognomString = Registre.demanarNom(leerScanner);
		System.out.print("Nacionalidad del actor: ");
		String nacionalidadString = Registre.demanarNom(leerScanner);

		Actor actor = new Actor(nom, cognomString, nacionalidadString);

		directoresArrayListGeneral.add(actor);
		directoresArrayListPersonal.add(actor);

		guardarActorGlobal(rutaGeneralString, directoresArrayListGeneral);
		guardarActorGlobal(rutaPersonalString, directoresArrayListPersonal);

	}

	public static void guardarActorGlobal(String ruta, ArrayList<Actor> actoresArrayList) {
		try {
			OutputStream file = new FileOutputStream(ruta);
			OutputStream bufffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(bufffer);
			output.writeObject(actoresArrayList);
			output.close();
			bufffer.close();
		} catch (IOException e) {
			System.out.println("Error al guardar los directores en el archivo directores.dades.");
			e.printStackTrace();
		}
	}

	public static void listarActores(int id, String nom) {
		String rutaPersonalString = "usuarios/" + id + nom + "/actors" + nom + ".llista";
		ArrayList<Actor> actoresArrayList = leerFitxeroActores(rutaPersonalString);
		System.out.println();

		if (actoresArrayList.size() < 1) {
			System.out.println("Aún no has añadido ningun actor");
		} else {
			for (int i = 0; i < actoresArrayList.size(); i++) {
				Actor actor = actoresArrayList.get(i);
				String separadorString = "";
				for (int j = 0; j < actor.toString().length() + 4; j++) {
					separadorString += "-";
				}
				System.out.println(i + " - " + actor.toString() + "\n" + separadorString);
			}
		}

	}
}
