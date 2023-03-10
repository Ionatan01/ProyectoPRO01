package com.projecte.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registre {
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

	public static Date crearFecha(String fecha) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Date demanarFecha(Scanner leer) {
		Pattern comprobarNombre = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
		boolean correcto = false;
		String fecha;
		do {
			fecha = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(fecha);
			correcto = matcher.matches();
			if (fecha.isBlank() || fecha.contains(" ") || !correcto) {
				System.out.println("Escribe una fecha correcta");
			}
		} while (fecha.isBlank() || fecha.contains(" ") || (correcto == false));

		return crearFecha(fecha);
	}

	public static int demanarEnter(Scanner leer) {
		int ano = 0;
		System.out.println("Introduce el año");
		// Demanar any
		do {
			System.out.println("Introduce un entero (numero entero entre 0 y 2023): ");
			if (leer.hasNextInt()) {
				ano = leer.nextInt();

			} else {
				System.out.println("El valor introducido no es un entero entre 0 y 2023. Introduce un numero entero.");
				leer.nextLine();

			}
		} while ((ano > 2023) || (ano < 0));

		return ano;
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
			return contrasena1;
		} else {
			System.out.println("Les contraseñes no coincideixen, torna a escriureles:");
			return demanarContrasena(leer);
		}

	}

}
