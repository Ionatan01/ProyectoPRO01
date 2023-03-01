package com.projecte.main;

import java.util.Date;
import java.util.Scanner;

import com.projecte.utils.*;

public class Usuari implements Accions {

	private static int contador = 0;

	// Atributs

	private int id;
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
		this.id = incrementarContador();
		this.nom = nom;
		this.cognoms = cognoms;
		this.correuElectronic = correuElectronic;
		this.contraseña = contraseña;
		this.poblacio = poblacio;
		this.dataNaixement = dataNaixement;
	}

	// Metodos

	public static void Login() {
		Scanner leerScanner = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nomString = Metodos.demanarNom(leerScanner);
		System.out.print("Contraseña: ");
		String contrasenaLogin = Metodos.DemanarContrasenaLogin(leerScanner);

		try {

		} catch (Exception e) {
			System.out.println("Error:: Usuario no encontrado");
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
			Usuari usuari = new Usuari(nomString, cognomString, correoString, contrasenaString, poblacioString,
					fechaNaixement);
			if (Metodos.CrearDirectorioUsuario(usuari.nom) == true) {
				System.out.println("Usuario ya existe");
			} else {
				Metodos.CrearFitxerosUsuario(usuari.nom);
			}
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
