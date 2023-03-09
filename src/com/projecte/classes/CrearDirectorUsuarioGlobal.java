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
			System.out.println("Aún no has añadido ningun actor");
		} else {
			for (int i = 0; i < directoresArrayList.size(); i++) {
				Director director = directoresArrayList.get(i);
				String separadorString = "";
				for (int j = 0; j < director.toString().length() + 4; j++) {
					separadorString += "-";
				}
				System.out.println(i + " - " + director.toString() + "\n" + separadorString);
			}
		}
	}

//	public String toString() {
//		String listaDirectores = "";
//		for (int i = 0; i < directoresArrayList.size(); i++) {
//			Director director = directoresArrayList.get(i);
//			listaDirectores += director.toString() + "\n";
//		}
//		return listaDirectores;
//
//	}
//
//	public void mostrarDirectoresGlobal() {
//		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("dades/directors.dades"))) {
//			directoresArrayList = (ArrayList<Director>) entrada.readObject();
//		} catch (FileNotFoundException e) {
//			System.out.println("El archivo directores.dades no existe.");
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println("Error al leer el archivo directores.dades.");
//			e.printStackTrace();
//		}
//
//		System.out.println("Directores guardadas:");
//		System.out.println(this.toString()); // Aquí se llama al método toString()
//	}
//
//	public void modificarDirectorGlobal() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Introduce el nombre del director que deseas modificar:");
//		String nombreDirector = scanner.nextLine();
//		boolean encontrado = false;
//		ArrayList<Director> actores = null;
//		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("dades/directors.txt"))) {
//			directoresArrayList = (ArrayList<Director>) entrada.readObject();
//		} catch (FileNotFoundException e) {
//			System.out.println("El archivo directores.dades no existe.");
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println("Error al leer el archivo directores.dades.");
//			e.printStackTrace();
//		}
//
//		for (int i = 0; i < directoresArrayList.size(); i++) {
//			Director director = directoresArrayList.get(i);
//			if (director.getNombre().equals(nombreDirector)) {
//				System.out.println("Introduce el nuevo nombre del director:");
//				String nuevoNombre = scanner.nextLine();
//				System.out.println("Introduce los nuevos apellidos del director:");
//				String nuevosApellidos = scanner.nextLine();
//				System.out.println("Introduce la nueva nacionalidad del director:");
//				String nuevaNacionalidad = scanner.nextLine();
//				System.out.println("Introduce la nueva fecha de nacimiento del director:");
//				int nuevoId = scanner.nextInt();
//
//				director.setNombre(nuevoNombre);
//				director.setApellidos(nuevosApellidos);
//				director.setNacionalidad(nuevaNacionalidad);
//				director.setId_director(nuevoId);
//
//				encontrado = true;
//				directoresArrayList.set(i, director);
//				break;
//			}
//		}
//
//		if (encontrado) {
//			try {
//				FileOutputStream leerFile = new FileOutputStream("dades/directors.dades");
//				ObjectOutputStream objFile = new ObjectOutputStream(leerFile);
//				objFile.writeObject(directoresArrayList);
//				objFile.close();
//				leerFile.close();
//				System.out.println("Se ha modificado el actor en el archivo directores.dades.");
//			} catch (IOException e) {
//				System.out.println("Error al guardar los actores en el archivo directores.dades.");
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("El director no se ha encontrado en el archivo directores.dades.");
//		}
//	}
//
//	public void agregarDirectorPersonalDeGlobal() {
//		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("dades/directors.dades"))) {
//			directoresArrayList = (ArrayList<Director>) entrada.readObject();
//		} catch (FileNotFoundException e) {
//			System.out.println("El archivo directores.txt no existe.");
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println("Error al leer el archivo directores.txt.");
//			e.printStackTrace();
//		}
//
//		Scanner ea = new Scanner(System.in);
//		System.out.print("Ingrese el nombre del actor que desea agregar a su lista personal: ");
//		String nombre = ea.nextLine();
//		boolean encontrado = false;
//
//		// Buscar el actor en el archivo actores.txt
//		Director directorAgregado = null;
//		for (int i = 0; i < directoresArrayList.size(); i++) {
//			Director director = directoresArrayList.get(i);
//			if (director.getNombre().equalsIgnoreCase(nombre)) {
//				encontrado = true;
//				directorAgregado = director;
//				break;
//			}
//		}
//
//		if (!encontrado) {
//			System.out.println("El director no se encuentra en el archivo directores.dades.");
//		} else {
//			System.out.println("El director ha sido encontrado:");
//			System.out.println(directorAgregado);
//			try (FileReader fr = new FileReader("ea.txt"); BufferedReader br = new BufferedReader(fr)) {
//				String linea;
//				boolean existe = false;
//				while ((linea = br.readLine()) != null) {
//					String[] campos = linea.split(",");
//					if (campos[0].equalsIgnoreCase(directorAgregado.getNombre())) {
//						System.out.println("El director ya se encuentra en la lista personal.");
//						existe = true;
//						break;
//					}
//				}
//				if (!existe) {
//					try (FileWriter fw = new FileWriter("ea.txt", true);
//							BufferedWriter bw = new BufferedWriter(fw);
//							PrintWriter out = new PrintWriter(bw)) {
//						System.out.println(directorAgregado.getNombre() + "," + directorAgregado.getApellidos() + ","
//								+ directorAgregado.getNacionalidad() + "," + directorAgregado.getFechaNacimiento());
//						System.out.println("El director se ha agregado al archivo ea.txt.");
//					} catch (IOException e) {
//						System.out.println("Error al guardar el director en el archivo ea.txt.");
//						e.printStackTrace();
//					}
//				}
//			} catch (IOException e) {
//				System.out.println("Error al leer el archivo ea.txt.");
//				e.printStackTrace();
//			}
//		}
//	}
//

//
//	public void buscarDirector() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Introduce el nombre del director que deseas buscar:");
//		String nombreDirector = scanner.nextLine();
//		boolean encontrado = false;
//		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("dades/directors.dades"))) {
//			ArrayList<Director> directores = (ArrayList<Director>) entrada.readObject();
//			for (int i = 0; i < directores.size(); i++) {
//				Director director = directores.get(i);
//				if (director.getNombre().equals(nombreDirector)) {
//					System.out.println("Director encontrado: \n" + director.toString());
//					encontrado = true;
//					break;
//				}
//			}
//			if (!encontrado) {
//				System.out.println("No se encontró el director con nombre " + nombreDirector);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("El archivo directores.txt no existe.");
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println("Error al leer el archivo directores.dades.");
//			e.printStackTrace();
//		}
//	}
}