package com.projecte.main;

import com.projecte.christian.CridarChristian;
import com.projecte.hugo.CridarHugo;
import com.projecte.ionatan.CridarIonatan;
import com.projecte.juanen.CridarJuanen;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// Importar noms de membres del grup
		CridarIonatan cridarIonatan = new CridarIonatan();
		CridarChristian cridarChristian = new CridarChristian();
		CridarHugo cridarHugo = new CridarHugo();
		CridarJuanen cridarJuanen=new CridarJuanen();

		// Cridar a membres del grup
		System.out.println("Membres: ");
		cridarIonatan.cridarIonatan();
		cridarChristian.cridarChristian();
		cridarHugo.cridarHugo();
		cridarJuanen.CridarJuanen();
		System.out.println("hola");
	}

}
