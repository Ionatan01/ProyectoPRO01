package com.projecte.main;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuari implements Accions {

	// Atributs

	private static int id;
	private String nom;
	private String cognoms;
	private String correuElectronic;
	private String contraseña;
	private String poblacio;
	private String rol = "ROL_USUARI";
	private Date dataNaixement;

	// constructor

	public Usuari(String nom, String cognoms, String correuElectronic, String contraseña, String poblacio,
			Date dataNaixement) {
		Usuari.id = id++;
		this.nom = nom;
		this.cognoms = cognoms;
		this.correuElectronic = correuElectronic;
		this.contraseña = contraseña;
		this.poblacio = poblacio;
		this.dataNaixement = dataNaixement;
	}

	// Metodos

	public static String demanarNom(Scanner leer) {
		Pattern comprobarNombre = Pattern.compile("(?i)[a-zäëïöüáéíóúáéíóúâêîôûàèìòù]{3,15}");
		boolean correcto = false;
		String nom;
		do {
			System.out.print("Nombre: ");
			nom = leer.nextLine().trim();
			Matcher matcher = comprobarNombre.matcher(nom);
			correcto = matcher.matches();
			if (nom.isBlank() || nom.contains(" ") || !correcto || nom.length() < 3) {
				System.out.println("Escribe un nombre correcto");
			}
		} while (nom.isBlank() || nom.contains(" ") || nom.length() < 3 || (correcto == false));
		return nom;
	}

	public static String demanarCognom(Scanner leer) {
		Pattern comprobarCognom = Pattern.compile("(?i)[a-zäëïöüáéíóúáéíóúâêîôûàèìòù]{3,15}");
		boolean correcto = false;
		String apellido;
		do {
			System.out.print("Apellido: ");
			apellido = leer.nextLine().trim();
			Matcher matcher = comprobarCognom.matcher(apellido);
			correcto = matcher.matches();
			if (apellido.isBlank() || apellido.contains(" ") || !correcto || apellido.length() < 3) {
				System.out.println("Escribe un apellido correcto");
			}
		} while (apellido.isBlank() || apellido.contains(" ") || apellido.length() < 3 || (correcto == false));
		return apellido;
	}

	public static String demanarEmail(Scanner leer) {
		Pattern comprobarEmail = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean correcto = false;
		String email;
		do {
			System.out.print("Email: ");
			email = leer.nextLine().trim();
			Matcher matcher = comprobarEmail.matcher(email);
			correcto = matcher.matches();
			if (email.isBlank() || email.contains(" ") || !correcto) {
				System.out.println("Escribe un correo correcto");
			}
		} while (email.isBlank() || email.contains(" ") || (correcto == false));
		return email;
	}

	public static String demanarPoblacio(Scanner leer) {
		Pattern comprobarPoblacio = Pattern.compile("(?i)[a-zäëïöüáéíóúáéíóúâêîôûàèìòù]{3,15}");
		boolean correcto = false;
		String poblacio;
		do {
			System.out.print("Poblacio: ");
			poblacio = leer.nextLine().trim();
			Matcher matcher = comprobarPoblacio.matcher(poblacio);
			correcto = matcher.matches();
			if (poblacio.isBlank() || poblacio.contains(" ") || !correcto || poblacio.length() < 3) {
				System.out.println("Escribe un nombre de población correcto");
			}
		} while (poblacio.isBlank() || poblacio.contains(" ") || poblacio.length() < 3 || (correcto == false));
		return poblacio;
	}

	public static Date demanarFecha(Scanner leer) {
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Pattern comprobarNombre = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
		boolean correcto = false;
		Date fechaNaixement = null;
		String fecha;
		do {
			System.out.print("Fecha nacimiento (dd/mm/yyyy): ");
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
			System.out.print("Contraseña: ");

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

	public static void registro() {
		Scanner leerScanner = new Scanner(System.in);
		String nomString = demanarNom(leerScanner);
		String cognomString = demanarCognom(leerScanner);
		String correoString = demanarEmail(leerScanner);
		String contrasenaString = demanarContrasena(leerScanner);
		String poblacioString = demanarPoblacio(leerScanner);
		Date fechaNaixement = demanarFecha(leerScanner);

		try {
			Usuari usuari = new Usuari(nomString, cognomString, correoString, contrasenaString, poblacioString,
					fechaNaixement);
			System.out.println("Correcto:: Usuario guardado");
			System.out.println(usuari.getNom());
			System.out.println(usuari.getCognoms());
			System.out.println(usuari.getContraseña());
			System.out.println(usuari.getRol());
			System.out.println(usuari.getCorreuElectronic());
			System.out.println(usuari.getDataNaixement());
			System.out.println(Usuari.getId());

		} catch (Exception e) {
			System.out.println("Error:: Usuario no guardado");
		}

	}

	// getters y setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getCorreuElectronic() {
		return correuElectronic;
	}

	public void setCorreuElectronic(String correuElectronic) {
		this.correuElectronic = correuElectronic;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(Date dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Usuari.id = id;
	}
	// Metodos interfaz

	@Override
	public void crear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub

	}

}
