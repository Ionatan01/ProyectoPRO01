package com.projecte.main;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.projecte.utils.Metodos;

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
	public static void registro() {
		Scanner leerScanner = new Scanner(System.in);
		String nomString = Metodos.demanarNom(leerScanner);
		String cognomString = Metodos.demanarNom(leerScanner);
		String correoString = Metodos.demanarEmail(leerScanner);
		String contrasenaString = Metodos.demanarContrasena(leerScanner);
		String poblacioString = Metodos.demanarNom(leerScanner);
		Date fechaNaixement = Metodos.demanarFecha(leerScanner);

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
