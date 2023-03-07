package com.projecte.ionatan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Scanner;

import com.projecte.main.Usuari;

public class GuardarObjeto {

	public static void main(String[] args) {
		Usuari prueba = new Usuari(2, "otro", "otro", "otro@gmail.com", "1234", "Ontinyent", null);
		GuardarObjeto programa = new GuardarObjeto();

		programa.guardarInfoUsuario(prueba);
		//programa.guardarInfoUsuario(prueba);

		//System.out.println(prueba.getNomCorreuElectronic());

		// int id, String nom, String cognoms, String correuElectronic, String
		// contraseña, String poblacio,
		// String rol, Date dataNaixement
		
		// Enum rol
		
		// Metodo id
	}

//	public void guardarObjeto(Usuari p) {
//
//	}

	public void guardarInfoUsuario(Usuari p) {
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
	
	public int siguienteId() {
		int ultimoIdAsignado = 0;
		File ficheroAEditar = new File("dades/usuaris.txt");
		Scanner escaner = new Scanner(System.in);
		
		
		
		
		return ultimoIdAsignado + 1;
	}

}
