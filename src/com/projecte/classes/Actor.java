package com.projecte.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private String nacionalidad;
	private String fechaNacimiento;

	public Actor(String nombre, String apellidos, String nacionalidad, String fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String toString() {
		return "Nombre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nNacionalidad: " + this.nacionalidad
				+ "\nFecha de Nacimiento: " + this.fechaNacimiento + "\n";

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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}

class CrearActorUsuarioGlobal {
	private ArrayList<Actor> actores;

	public CrearActorUsuarioGlobal() {
		actores = new ArrayList<Actor>();
	}

	public void agregarActor(Actor actor) {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
			actores = (ArrayList<Actor>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo actores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo actores.txt.");
			e.printStackTrace();
		}

		actores.add(actor);
	}

	public void guardarActoresGlobal() {
		try {
			FileOutputStream leerFile = new FileOutputStream("actores.txt");
			ObjectOutputStream objFile = new ObjectOutputStream(leerFile);
			objFile.writeObject(actores);
			objFile.close();
			leerFile.close();
			System.out.println("Se han guardado los actores en el archivo actores.txt.");
		} catch (IOException e) {
			System.out.println("Error al guardar los actores en el archivo actores.txt.");
			e.printStackTrace();
		}
	}

	public String toString() {
		String listaActores = "";
		for (int i = 0; i < actores.size(); i++) {
			Actor actor = actores.get(i);
			listaActores += actor.toString() + "\n";
		}
		return listaActores;
	}

	public void mostrarActoresGlobal() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
			actores = (ArrayList<Actor>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo actores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo actores.txt.");
			e.printStackTrace();
		}

		System.out.println("Actores guardados:");
		System.out.println(this.toString());
	}

	public void modificarActorGlobal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el nombre del actor que deseas modificar:");
		String nombreActor = scanner.nextLine();
		boolean encontrado = false;
		ArrayList<Actor> actores = null;
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
			actores = (ArrayList<Actor>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo actores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo actores.txt.");
			e.printStackTrace();
		}

		for (int i = 0; i < actores.size(); i++) {
			Actor actor = actores.get(i);
			if (actor.getNombre().equals(nombreActor)) {
				System.out.println("Introduce el nuevo nombre del actor:");
				String nuevoNombre = scanner.nextLine();
				System.out.println("Introduce los nuevos apellidos del actor:");
				String nuevosApellidos = scanner.nextLine();
				System.out.println("Introduce la nueva nacionalidad del actor:");
				String nuevaNacionalidad = scanner.nextLine();
				System.out.println("Introduce la nueva fecha de nacimiento del actor:");
				String nuevaFechaNacimiento = scanner.nextLine();

				actor.setNombre(nuevoNombre);
				actor.setApellidos(nuevosApellidos);
				actor.setNacionalidad(nuevaNacionalidad);
				actor.setFechaNacimiento(nuevaFechaNacimiento);

				encontrado = true;
				actores.set(i, actor);
				break;
			}
		}

		if (encontrado) {
			try {
				FileOutputStream leerFile = new FileOutputStream("actores.txt");
				ObjectOutputStream objFile = new ObjectOutputStream(leerFile);
				objFile.writeObject(actores);
				objFile.close();
				leerFile.close();
				System.out.println("Se ha modificado el actor en el archivo actores.txt.");
			} catch (IOException e) {
				System.out.println("Error al guardar los actores en el archivo actores.txt.");
				e.printStackTrace();
			}
		} else {
			System.out.println("El actor no se ha encontrado en el archivo actores.txt.");
		}
	}

	public void agregarActorPersonalDeGlobal() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
			actores = (ArrayList<Actor>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo actores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo actores.txt.");
			e.printStackTrace();
		}

		Scanner ea = new Scanner(System.in);
		System.out.print("Ingrese el nombre del actor que desea agregar a su lista personal: ");
		String nombre = ea.nextLine();
		boolean encontrado = false;

		// Buscar el actor en el archivo actores.txt
		Actor actorAgregado = null;
		for (int i = 0; i < actores.size(); i++) {
			Actor actor = actores.get(i);
			if (actor.getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
				actorAgregado = actor;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("El actor no se encuentra en el archivo actores.txt.");
		} else {
			System.out.println("El actor ha sido encontrado:");
			System.out.println(actorAgregado);

			try (FileReader fr = new FileReader("ea.txt"); BufferedReader br = new BufferedReader(fr)) {

				String linea;
				boolean existe = false;
				while ((linea = br.readLine()) != null) {
					String[] campos = linea.split(",");
					if (campos[0].equalsIgnoreCase(actorAgregado.getNombre())) {
						System.out.println("El actor ya se encuentra en la lista personal.");
						existe = true;
						break;
					}
				}

				if (!existe) {
					try (FileWriter fw = new FileWriter("ea.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter out = new PrintWriter(bw)) {
						out.println(actorAgregado.getNombre() + "," + actorAgregado.getApellidos() + ","
								+ actorAgregado.getNacionalidad() + "," + actorAgregado.getFechaNacimiento());
						System.out.println("El actor se ha agregado al archivo ea.txt.");
					} catch (IOException e) {
						System.out.println("Error al guardar el actor en el archivo ea.txt.");
						e.printStackTrace();
					}
				}

			} catch (IOException e) {
				System.out.println("Error al leer el archivo ea.txt.");
				e.printStackTrace();
			}
		}
	}

	public void listarActores() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
			ArrayList<Actor> actores = (ArrayList<Actor>) entrada.readObject();
			for (int i = 0; i < actores.size(); i++) {
				Actor actor = actores.get(i);
				System.out.println("Nombre: " + actor.getNombre() + "\nApellidos: " + actor.getApellidos()
						+ "\nNacionalidad: " + actor.getNacionalidad() + "\nFecha de Nacimiento: "
						+ actor.getFechaNacimiento() + "\n------------------------");
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo actores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo actores.txt.");
			e.printStackTrace();
		}
	}

	public void buscarActor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el nombre del actor que deseas buscar:");
		String nombreActor = scanner.nextLine();
		boolean encontrado = false;
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
			ArrayList<Actor> actores = (ArrayList<Actor>) entrada.readObject();
			for (int i = 0; i < actores.size(); i++) {
				Actor actor = actores.get(i);
				if (actor.getNombre().equals(nombreActor)) {
					System.out.println("Actor encontrado: \n" + actor.toString());
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("No se encontró el actor con nombre " + nombreActor);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo actores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo actores.txt.");
			e.printStackTrace();
		}
	}

}