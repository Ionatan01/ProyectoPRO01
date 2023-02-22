package com.projecte.main;

import com.projecte.christian.CridarChristian;
import com.projecte.ionatan.CridarIonatan;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// Importar noms de membres del grup
		CridarIonatan cridarIonatan = new CridarIonatan();
		CridarChristian cridarChristian = new CridarChristian();

		
		// Cridar a membres del grup
		cridarIonatan.cridarIonatan();
		cridarChristian.cridarChristian();
		
	}

}
