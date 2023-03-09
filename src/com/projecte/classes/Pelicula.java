package com.projecte.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelicula implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private int ano;
	private String director;
	private String genero;

	public Pelicula(String titulo, int anio, String director, String genero) {
		this.titulo = titulo;
		this.ano = anio;
		this.director = director;
		this.genero = genero;
	}

	public String toString() {
		return "Título: " + this.titulo + "  --  Año: " + this.ano + "  --  Director: " + this.director + "  --  Género: "
				+ this.genero;

	}

	// getters y setters

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}

