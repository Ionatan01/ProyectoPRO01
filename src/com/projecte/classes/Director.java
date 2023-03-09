package com.projecte.classes;

import java.io.*;

public class Director implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private String nacionalidad;
	private int id_director;

	public Director(String nombre, String apellidos, String nacionalidad, int id_director) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacionalidad = nacionalidad;
		this.id_director = id_director;
	}

	public String toString() {
		return "[Id_director: " + this.id_director + " Nombre: " + this.nombre + " Apellidos: " + this.apellidos
				+ " Nacionalidad: " + this.nacionalidad + "]";

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getFechaNacimiento() {
		return id_director;
	}

	public void setId_director(int id_director) {
		this.id_director = id_director;
	}
}
