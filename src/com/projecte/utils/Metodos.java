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

	
}
