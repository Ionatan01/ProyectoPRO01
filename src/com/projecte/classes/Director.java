package com.projecte.classes;

import java.io.Serializable;
import java.util.List;

public class Director implements Serializable {
	  private String nombre;
	    private int IdDirector;
	    private String apellidos;

	    // El constructor del director
	    public Director(String nombre, int IdDirector, String apellidos) {
	        this.nombre = nombre;
	        this.IdDirector = IdDirector;
	        this.apellidos = apellidos;
	    }

	    // Los getters y setters
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getIdDirector() {
	        return IdDirector;
	    }

	    public void setIdDirector(int IdDirector) {
	        this.IdDirector = IdDirector;
	    }

	    public String getapellidos() {
	        return apellidos;
	    }

	    public void setapellidos(String apellidos) {
	        this.apellidos = apellidos;
	    }

	    // metodo para mostrar directores
	    public static void mostrarDirectores(List<Director> directores) {
	        for (Director director : directores) {
	            System.out.println("Nombre: " + director.getNombre());
	            System.out.println("ID_Director: " + director.getIdDirector());
	            System.out.println("Nacionalidad: " + director.getapellidos());
	        }
	    }
	    //metodo para añadir directores
	    public static void anadirDirector(List<Director> directores, Director director) {
	        directores.add(director);
	    }
	    
	}

