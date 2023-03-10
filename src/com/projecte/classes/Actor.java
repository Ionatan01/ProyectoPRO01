package com.projecte.classes;

import java.io.*;

public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private String nacionalidad;
	private int id_actor;

	public Actor(String nombre, String apellidos, String nacionalidad, int id_actor) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacionalidad = nacionalidad;
		this.id_actor = id_actor;
	}

	public String toLongString() {
		return "[Id_actor -> " + this.id_actor + "; Nombre -> " + this.nombre + "; Apellidos -> " + this.apellidos
				+ "; Nacionalidad -> " + this.nacionalidad + "]";
	}

	public String toShortString() {
		return this.nombre + " " + this.apellidos;

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

}
