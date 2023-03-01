package com.projecte.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Metodos {
	// Metodos

	public static String demanarNom(Scanner leer) {
		Pattern comprobarNombre = Pattern.compile("(?i)[a-zäëïöüáéíóúáéíóúâêîôûàèìòù]{3,15}");
		boolean correcto = false;
		String nom;
		do {
			nom = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(nom);
			correcto = matcher.matches();
			if (nom.isBlank() || nom.contains(" ") || !correcto || nom.length() < 3) {
				System.out.println("Escribe un nombre correcto");
			}
		} while (nom.isBlank() || nom.contains(" ") || nom.length() < 3 || (correcto == false));
		return nom;
	}

	public static String demanarEmail(Scanner leer) {
		Pattern comprobarEmail = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean correcto = false;
		String email;
		do {
			email = leer.nextLine().trim();
			Matcher matcher = comprobarEmail.matcher(email);
			correcto = matcher.matches();
			if (email.isBlank() || email.contains(" ") || !correcto) {
				System.out.println("Escribe un correo correcto");
			}
		} while (email.isBlank() || email.contains(" ") || (correcto == false));
		return email;
	}

	public static Date demanarFecha(Scanner leer) {
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Pattern comprobarNombre = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
		boolean correcto = false;
		Date fechaNaixement = null;
		String fecha;
		do {
			fecha = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(fecha);
			correcto = matcher.matches();
			if (fecha.isBlank() || fecha.contains(" ") || !correcto) {
				System.out.println("Escribe una fecha correcta");
			}
		} while (fecha.isBlank() || fecha.contains(" ") || (correcto == false));
		try {
			// convierte un String en formato fecha en una fecha real
			fechaNaixement = format.parse(fecha);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaNaixement;
	}

	public static String demanarContrasena(Scanner leer) {
		Pattern comprobarNombre = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15}$");
		boolean correcto = false;
		String contrasena1, contrasena2;
		do {
			contrasena1 = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(contrasena1);
			correcto = matcher.matches();
			if (contrasena1.isBlank() || contrasena1.contains(" ") || !correcto || contrasena1.length() < 6) {
				System.out.println("\n ---- Escribe una contraseña segura ----");
				System.out.println("\t*Al menos un digito");
				System.out.println("\t*Al menos una mayuscula");
				System.out.println("\t*Al menos una minuscula");
				System.out.println("\t*De 6 a 20 caracteres\n");
			}
		} while (contrasena1.isBlank() || contrasena1.contains(" ") || contrasena1.length() < 6 || (correcto == false));
		do {
			System.out.print("Vuelve a escribir la contraseña: ");

			contrasena2 = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(contrasena2);
			correcto = matcher.matches();
			if (contrasena2.isBlank() || contrasena2.contains(" ") || !correcto || contrasena2.length() < 6) {
				System.out.println("\n -- Escribe una contraseña segura --");
				System.out.println("\t*Al menos un digito");
				System.out.println("\t*Al menos una mayuscula");
				System.out.println("\t*Al menos una minuscula");
				System.out.println("\t*De 6 a 20 caracteres\n");
			}
		} while (contrasena2.isBlank() || contrasena2.contains(" ") || contrasena2.length() < 6 || (correcto == false));

		if (contrasena1.equals(contrasena2)) {
			System.out.println("Contraseña guardada");
			return contrasena1;

		} else {
			System.out.println("Les contraseñes no coincideixen, torna a escriureles:");
			return demanarContrasena(leer);
		}

	}

	public static String DemanarContrasenaLogin(Scanner leer) {
		Pattern comprobarNombre = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15}$");
		boolean correcto = false;
		String contrasena1;
		do {
			contrasena1 = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(contrasena1);
			correcto = matcher.matches();
			if (contrasena1.isBlank() || contrasena1.contains(" ") || !correcto || contrasena1.length() < 6) {
				System.out.println("\n ---- Escribe una contraseña segura ----");
				System.out.println("\t*Al menos un digito");
				System.out.println("\t*Al menos una mayuscula");
				System.out.println("\t*Al menos una minuscula");
				System.out.println("\t*De 6 a 20 caracteres\n");
			}
		} while (contrasena1.isBlank() || contrasena1.contains(" ") || contrasena1.length() < 6 || (correcto == false));
		return contrasena1;
	}

	public static boolean CrearDirectorioUsuario(String nombre) {
		File directorio = new File("usuarios" + File.separator + nombre.toLowerCase());
		boolean existe = directorio.exists();
		if (directorio.mkdirs()) {
			System.out.println("\nDirectorio del usuario creado");
		} else {
			System.out.println("\nError al crear directorio");
		}
		return existe;
	}

	public static void CrearFitxerosUsuario(String nombre) {
		try {
			File actorsFile = new File("usuarios" + File.separator + nombre.toLowerCase() + File.separator + "actors"
					+ nombre.toLowerCase() + ".dades");
			actorsFile.createNewFile();
			File peliculesFile = new File("usuarios" + File.separator + nombre.toLowerCase() + File.separator
					+ "pelicules" + nombre.toLowerCase() + ".dades");
			peliculesFile.createNewFile();
			File directorsFile = new File("usuarios" + File.separator + nombre.toLowerCase() + File.separator
					+ "directors" + nombre.toLowerCase() + ".dades");
			directorsFile.createNewFile();

		} catch (Exception e) {
			System.out.println("::ERROR::");
		}

	}
}
