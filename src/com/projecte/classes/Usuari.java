package com.projecte.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

import com.projecte.utils.*;

public class Usuari implements Accions, Serializable {

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
	File directorio1 = new File("usuarios" + File.separator);

	public Usuari(int id, String nom, String cognoms, String correuElectronic, String contraseña) {
		super();
		this.id = id;
		this.nom = nom;
		this.cognoms = cognoms;
		this.correuElectronic = correuElectronic;
		this.contraseña = contraseña;
		this.rol = tipusRol.ROL_USUARI;
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

	// MetodoLogin

	public static void Login() {
		Scanner leerScanner = new Scanner(System.in);
		String linea;
		boolean usuarioExiste = false;
		do {
			System.out.print("Correo: ");
			String emailString = Login.demanarEmail(leerScanner);
			System.out.print("Contraseña: ");
			String contrasenaLogin = Login.DemanarContrasenaLogin(leerScanner);
			try (BufferedReader br = new BufferedReader(new FileReader("dades/usuaris.txt"))) {
				while ((linea = br.readLine()) != null) {
					if (linea.contains(emailString) && linea.contains(contrasenaLogin)) {
						String[] infoUsuario = linea.split(":::");
						int id = Integer.parseInt(infoUsuario[0]);
						Usuari usuari = new Usuari(id, infoUsuario[1], infoUsuario[2], infoUsuario[3], infoUsuario[4]);
						usuarioExiste = true;

						Menus.menuLogeado(id, infoUsuario[1], infoUsuario[2], usuari.getNomCorreuElectronic());
					}
				}
				if (usuarioExiste == false) {
					System.out.println("Usuario no encontrado :: Vuelve a escribir la informacion:");
				}
			} catch (Exception e) {
				System.out.println("Error::" + e);
			}
		} while (usuarioExiste == false);

	}

	// MetodoRegistro

	public static void registro() {
		Scanner leerScanner = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nomString = Registre.demanarNom(leerScanner);
		System.out.print("Apellido: ");
		String cognomString = Registre.demanarNom(leerScanner);
		System.out.print("Correo: ");
		String correoString = Registre.demanarEmail(leerScanner);
		System.out.print("Poblacion: ");
		String poblacioString = Registre.demanarNom(leerScanner);
		System.out.print("Contraseña: ");
		String contrasenaString = Registre.demanarContrasena(leerScanner);
		System.out.print("Fecha nacimiento dd/mm/yyyy: ");
		Date fechaNaixement = Registre.demanarFecha(leerScanner);

		try {
			Usuari usuari = new Usuari(siguienteId(), nomString, cognomString, correoString, contrasenaString,
					poblacioString, fechaNaixement);
			crear(usuari);

			System.out.println(usuari.toString());

		} catch (Exception e) {
			System.out.println("Error:: Usuario no guardado -->" + e);
		}

	}

	public static int siguienteId() {
		int ultimoIdAsignado = 0;
		File ficheroALeer = new File("dades/usuaris.txt");
		Scanner entrada;
		String lineaActual = "";
		String[] paraulesLineaActual;
		try {
			entrada = new Scanner(ficheroALeer);
			while (entrada.hasNextLine()) {
				// Assignar valors
				lineaActual = entrada.nextLine();
				paraulesLineaActual = lineaActual.split(":::");
				ultimoIdAsignado = Integer.parseInt(paraulesLineaActual[0]);

			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido leer el fichero: dades/usuaris.txt -> " + e);
		}
		return ultimoIdAsignado + 1;
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

//	public void setId(int id) {
//		this.id = id;
//	}

	@Override
	public String toString() {
		return "Usuari [id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", correuElectronic=" + correuElectronic
				+ ", contraseña=" + contraseña + ", poblacio=" + poblacio + ", rol=" + rol + ", dataNaixement="
				+ dataNaixement + "]";
	}

	public String toStringParaGuardar() {
		return id + ":::" + nom + ":::" + cognoms + ":::" + correuElectronic + ":::" + contraseña + ":::" + poblacio
				+ ":::" + rol + ":::" + dataNaixement;
	}

	// Metodos interfaz

	public static void crear(Usuari p) {
		FileWriter fw;
		String nomUsuari = p.getNomCorreuElectronic();
		int idUsuari = p.getId();
		// Crear metodo para retornar solo parte de delante del correo
		File carpeta = new File("usuarios/" + idUsuari + nomUsuari);
		File peliculas = new File(carpeta + "/pelicules" + nomUsuari.substring(0, 1).toUpperCase()
				+ nomUsuari.substring(1, nomUsuari.length()) + ".llista");
		File actores = new File(carpeta + "/actors" + nomUsuari.substring(0, 1).toUpperCase()
				+ nomUsuari.substring(1, nomUsuari.length()) + ".llista");
		File directores = new File(carpeta + "/directors" + nomUsuari.substring(0, 1).toUpperCase()
				+ nomUsuari.substring(1, nomUsuari.length()) + ".llista");

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
