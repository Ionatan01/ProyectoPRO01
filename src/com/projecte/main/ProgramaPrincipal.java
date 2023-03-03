package com.projecte.main;

import java.util.Scanner;

import com.projecte.christian.CridarChristian;
import com.projecte.classes.Usuari;
import com.projecte.hugo.CridarHugo;
import com.projecte.ionatan.CridarIonatan;
import com.projecte.juanen.CridarJuanen;
import com.projecte.utils.*;

public class ProgramaPrincipal {
	public void menuLoginRegistre() {
		System.out.println("\t\n ---- Menu ---- ");
		System.out.println(" 1.- Login");
		System.out.println(" 2.- Registre");

	}

	public int elegirOpcionMenuLoginRegistre() {
		Scanner leerOpcionMenu = new Scanner(System.in);
		int numEleccion = 0;
		do {
			while (!leerOpcionMenu.hasNextInt()) {
				System.out.println("::ERROR:: Escribe un numero correcto (1-2)");
				leerOpcionMenu.next();
			}
			numEleccion = leerOpcionMenu.nextInt();
			if (numEleccion < 1 || numEleccion > 2) {
				System.out.println("::ERROR:: Escribe un numero correcto (1-2)");
			}
		} while (numEleccion < 1 || numEleccion > 2);
		return numEleccion;
	}

	public void inici() {
		Scanner leer = new Scanner(System.in);

		// Importar noms de membres del grup
		CridarIonatan cridarIonatan = new CridarIonatan();
		CridarChristian cridarChristian = new CridarChristian();
		CridarHugo cridarHugo = new CridarHugo();
		CridarJuanen cridarJuanen = new CridarJuanen();

		// Cridar a membres del grup
		System.out.println("Membres: ");
		cridarIonatan.cridarIonatan();
		cridarChristian.cridarChristian();
		cridarHugo.cridarHugo();
		cridarJuanen.CridarJuanen();

		menuLoginRegistre();

		switch (elegirOpcionMenuLoginRegistre()) {
		case 1: {
			System.out.println("\t\n ---- Login ----");
			Usuari.Login();
			break;
		}
		case 2: {
			System.out.println("\t\n ---- Registro ----");
			Usuari.registro();
			break;
		}
		default:
		}

	}

	public static void main(String[] args) {

		ProgramaPrincipal programa = new ProgramaPrincipal();
		programa.inici();

	}

}
