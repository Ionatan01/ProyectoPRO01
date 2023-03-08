package com.projecte.main;

import java.io.File;

import com.projecte.christian.CridarChristian;
import com.projecte.classes.Usuari;
import com.projecte.hugo.CridarHugo;
import com.projecte.ionatan.CridarIonatan;
import com.projecte.juanen.CridarJuanen;
import com.projecte.utils.*;

public class ProgramaPrincipal {

	public void inici() {
		boolean salir = false;

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

		while (!salir) {
			Menus.menuPrincipalLoginRegistre();

			switch (Menus.elegirOpcionMenu(1, 3)) {
			case 1:
				File directorio1 = new File("usuarios" + File.separator);
				Usuari.registro();
				break;
			case 2:
				Usuari.Login();

				break;
			case 3:
				salir = true;
				System.out.println("Adios");
				break;
			}
		}
	}

	public static void main(String[] args) {

		ProgramaPrincipal programa = new ProgramaPrincipal();
		programa.inici();

	}
	
	
	
	

}
