package com.projecte.main;

import com.projecte.hugo.CridarHugo;
import com.projecte.ionatan.CridarIonatan;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// Importar noms de membres del grup
		CridarIonatan cridarIonatan = new CridarIonatan();
		CridarHugo cridarHugo = new CridarHugo();

		// Cridar a membres del grup
		System.out.println("Membres: ");
		cridarIonatan.cridarIonatan();
		cridarHugo.cridarHugo();

	}

}
