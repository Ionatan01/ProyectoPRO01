package com.projecte.juanen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class juanen {

	 public static boolean main(String[] args) {
	      
	        Usuario usuario = new Usuario("Juan", "Pérez", "juan123", "password");
	        boolean contraseñaEncontrada = false;
	        boolean usuarioEncontrado=false;
	        String linea;

	   
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Nombre de usuario: ");
	        String nombreUsuario = scanner.nextLine();
	        System.out.print("Contraseña: ");
	        String contraseña = scanner.nextLine();
	       

	        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
	            while ((linea = br.readLine()) != null) {
	                if (linea.contains(nombreUsuario) && linea.contains(contraseña)) {
	  		 usuarioEncontrado = true;
	                    contraseñaEncontrada = true;
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return contraseñaEncontrada;
	    
	


	       // if (!usuario.esCredencialValida(nombreUsuario, contraseña)) {
	         //   System.out.println("Credenciales inválidas. Por favor, inténtalo de nuevo.");
	           // return;
	        //}

	        System.out.println("¡Bienvenido, " + nombreUsuario.getNombreCompleto() + "!");
	        public static void mostrarMenu() {
	        while (true) {
	            System.out.println("¿Qué te gustaría hacer?");
	            System.out.println("1. Ver listado de películas");
	            System.out.println("2. Ver listado de actores");
	            System.out.println("3. Ver listado de directores");
	            System.out.println("4. Añadir película");
	            System.out.println("5. Añadir actor");
	            System.out.println("6. Añadir director");
	            System.out.println("7. Salir");

	          
	            System.out.print("Opción: ");
	            int opcion = scanner.nextInt();

	       
	            switch (opcion) {
	                case 1:
	                	mostrarPeliculas(usuario);
	                    System.out.println("Mostrando listado de películas...");
	                    break;
	                case 2:
	                	mostrarActores(usuario);
	                    System.out.println("Mostrando listado de actores...");
	                    break;
	                case 3:
	                	mostrarDirectores(usuario);
	                    System.out.println("Mostrando listado de directores...");
	                    break;
	                case 4:
	                	AñadirPeliculas(usuario);
	                    System.out.println("Añadiendo película...");
	                    break;
	                case 5:
	                	AñadirActor(usuario);
	                    System.out.println("Añadiendo actor...");
	                    break;
	                case 6:
	                	AñadirDirector(usuario);
	                    System.out.println("Añadiendo director...");
	                    break;
	                case 7:
	                    System.out.println("¡Hasta luego!");
	                    return;
	                default:
	                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
	                    break;
	            }
	        }
	    }
	}

	class Usuario {
	    private String nombre;
	    private String apellido;
	    private String nombreUsuario;
	    private String contraseña;

	    public Usuario(String nombre, String apellido, String nombreUsuario, String contraseña) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.nombreUsuario = nombreUsuario;
	        this.contraseña = contraseña;
	    }

	    public boolean esCredencialValida(String nombreUsuario, String contraseña) {
	        return this.nombreUsuario.equals(nombreUsuario) && this.contraseña.equals(contraseña);
	    }

	    public String getNombreCompleto() {
	        return this.nombre + " " + this.apellido;
	    }
	}
