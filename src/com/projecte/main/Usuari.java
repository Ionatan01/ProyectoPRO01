package com.projecte.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

import com.projecte.ionatan.GuardarObjeto;
import com.projecte.utils.*;

public class Usuari implements Accions, Serializable {

	private static int contador = 0;

	// Atributs
	public enum tipusRol {
		ROL_ADMIN, ROL_USUARI
	}

	private int id;
	private String nom;
	private String cognoms;
	private String correuElectronic;
	private String contraseña;
	private String poblacio;
	private tipusRol rol;
	private Date dataNaixement;

	// constructor

	public Usuari() {
		this.id = incrementarContador();
		this.nom = nom;
		this.cognoms = cognoms;
		this.correuElectronic = correuElectronic;
		this.contraseña = contraseña;
		this.poblacio = poblacio;
		this.dataNaixement = dataNaixement;
	}

	public Usuari(int id, String nom, String cognoms, String correuElectronic, String contraseña, String poblacio,
			Date dataNaixement) {
		super();
		this.id = id;
		this.nom = nom;
		this.cognoms = cognoms;
		this.correuElectronic = correuElectronic;
		this.contraseña = contraseña;
		this.poblacio = poblacio;
		this.rol = tipusRol.ROL_USUARI;
		this.dataNaixement = dataNaixement;
	}

	// Metodos

	public static void Login() {
		Scanner leerScanner = new Scanner(System.in);
		String linea;
		boolean contraseñaEncontrada = false;
		boolean usuarioEncontrado = false;
		System.out.print("Nombre: ");
		String nomString = Metodos.demanarNom(leerScanner);
		System.out.print("Contraseña: ");
		String contrasenaLogin = Metodos.DemanarContrasenaLogin(leerScanner);

		try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
			while ((linea = br.readLine()) != null) {
				if (linea.contains(nomString) && linea.contains(contrasenaLogin)) {
					usuarioEncontrado = true;
					contraseñaEncontrada = true;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Error:: Usuario no encontrado");
		}
	}

	public void mostrarMenu() {
		Scanner leerScanner = new Scanner(System.in);
		int opcion = 0;
		System.out.println("¡Bienvenido, " + nom + "!");
		while (true) {
			System.out.println("¿Qué te gustaría hacer?");
			System.out.println("1. Ver listado de películas");
			System.out.println("2. Ver listado de actores");
			System.out.println("3. Ver listado de directores");
			System.out.println("4. Añadir película");
			System.out.println("5. Añadir actor");
			System.out.println("6. Añadir director");
			System.out.println("7. Salir");

			System.out.print("Opción: ");
			opcion = leerScanner.nextInt();

			switch (opcion) {
			case 1:
				// mostrarPeliculas(nom);
				System.out.println("Mostrando listado de películas...");
				break;
			case 2:
				// mostrarActores(nom);
				System.out.println("Mostrando listado de actores...");
				break;
			case 3:
				// mostrarDirectores(nom);
				System.out.println("Mostrando listado de directores...");
				break;
			case 4:
				// AñadirPeliculas(nom);
				System.out.println("Añadiendo película...");
				break;
			case 5:
				// AñadirActor(nom);
				System.out.println("Añadiendo actor...");
				break;
			case 6:
				// AñadirDirector(nom);
				System.out.println("Añadiendo director...");
				break;
			case 7:
				System.out.println("¡Hasta luego!");
				return;
			default:
				System.out.println("Opción inválida. Por favor, elige una opción válida.");
				break;
			}
		}

	}

	public static void registro() {
		Scanner leerScanner = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nomString = Metodos.demanarNom(leerScanner);
		System.out.print("Apellido: ");
		String cognomString = Metodos.demanarNom(leerScanner);
		System.out.print("Correo: ");
		String correoString = Metodos.demanarEmail(leerScanner);
		System.out.print("Poblacion: ");
		String poblacioString = Metodos.demanarNom(leerScanner);
		System.out.print("Contraseña: ");
		String contrasenaString = Metodos.demanarContrasena(leerScanner);
		System.out.print("Fecha nacimiento dd/mm/yyyy: ");
		Date fechaNaixement = Metodos.demanarFecha(leerScanner);

		try {
			// Cambiar 2 per metode contador
			// Cambiar 2 per metode contador
			// Cambiar 2 per metode contador
			// Cambiar 2 per metode contador
			Usuari usuari = new Usuari(2, nomString, cognomString, correoString, contrasenaString, poblacioString, fechaNaixement);
			// Cambiar 2 per metode contador
			// Cambiar 2 per metode contador
			// Cambiar 2 per metode contador
			// Cambiar 2 per metode contador

			crear(usuari);
			
			System.out.println(usuari.toString());

		} catch (Exception e) {
			System.out.println("Error:: Usuario no guardado");
		}

	}

	private static int incrementarContador() {
		return contador++;
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

	public String getNomCorreuElectronic() {
		String correo = this.getCorreuElectronic();
		String[] correoSeparado;

		correoSeparado = correo.split("@");
		return correoSeparado[0];
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
		return "" + rol;
	}

	public Date getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(Date dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuari [id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", correuElectronic=" + correuElectronic
				+ ", contraseña=" + contraseña + ", poblacio=" + poblacio + ", rol=" + rol + ", dataNaixement="
				+ dataNaixement + "]";
	}

	public String toStringParaGuardar() {
		return id + ":" + nom + ":" + cognoms + ":" + correuElectronic + ":" + contraseña + ":" + poblacio + ":" + rol
				+ ":" + dataNaixement;
	}

	// Metodos interfaz

	public static void crear(Usuari p) {
		FileWriter fw;
		// Crear metodo para retornar solo parte de delante del correo
		File carpeta = new File("usuarios/" + p.getId() + p.getNomCorreuElectronic());
		File peliculas = new File(carpeta + "/p.dades");
		File actores = new File(carpeta + "/a.dades");
		File directores = new File(carpeta + "/d.dades");

		try {
			fw = new FileWriter("dades/usuaris.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(p.toStringParaGuardar()); // Ponerlo en el buffer
			bw.newLine(); // Insertar salto de linea
			bw.flush(); /// Guardar en fichero

			bw.close();

			if (!carpeta.isDirectory()) {
				carpeta.mkdir();
			}
			if (!peliculas.isFile()) {
				peliculas.createNewFile();
			}
			if (!actores.isFile()) {
				actores.createNewFile();
			}
			if (!directores.isFile()) {
				directores.createNewFile();
			}

			System.out.println("Usuario " + p.getNom() + " guardado correctamente.");
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el fichero: " + e);
		}

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

	@Override
	public void crear() {
		// TODO Auto-generated method stub
		
	}

}
