package com.projecte.classes;

import java.io.Serializable;
import java.util.List;

public class Director implements Serializable {
	  private String nombre;
	    private int edad;
	    private String nacionalidad;

	    // El constructor del director
	    public Director(String nombre, int edad, String nacionalidad) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.nacionalidad = nacionalidad;
	    }

	    // Los getters y setters
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public String getNacionalidad() {
	        return nacionalidad;
	    }

	    public void setNacionalidad(String nacionalidad) {
	        this.nacionalidad = nacionalidad;
	    }

	    // metodo para mostrar directores
	    public static void mostrarDirectores(List<Director> directores) {
	        for (Director director : directores) {
	            System.out.println("Nombre: " + director.getNombre());
	            System.out.println("Edad: " + director.getEdad());
	            System.out.println("Nacionalidad: " + director.getNacionalidad());
	        }
	    }
	    //metodo para añadir directores
	    public static void anadirDirector(List<Director> directores, Director director) {
	        directores.add(director);
	    }
	    
	}

