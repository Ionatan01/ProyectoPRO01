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
		return "Título: " + this.titulo + "\nAño: " + this.ano + "\nDirector: " + this.director + "\nGénero: "
				+ this.genero + "\n";

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

class CrearPeliculaUsuarioGlobal {
	private ArrayList<Pelicula> peliculas;

	public CrearPeliculaUsuarioGlobal() {
		peliculas = new ArrayList<Pelicula>();
	}

	public void agregarPelicula(Pelicula pelicula) {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("peliculas.txt"))) {
			peliculas = (ArrayList<Pelicula>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo peliculas.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo peliculas.txt.");
			e.printStackTrace();
		}

		peliculas.add(pelicula);
	}

	public void guardarPeliculasGlobal() {
		try {
			FileOutputStream leerFile = new FileOutputStream("peliculas.txt");
			ObjectOutputStream objFile = new ObjectOutputStream(leerFile);
			objFile.writeObject(peliculas);
			objFile.close();
			leerFile.close();
			System.out.println("Se han guardado las películas en el archivo peliculas.txt.");
		} catch (IOException e) {
			System.out.println("Error al guardar las películas en el archivo peliculas.txt.");
			e.printStackTrace();
		}
	}

	public String toString() {
		String listaPeliculas = "";
		for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			listaPeliculas += pelicula.toString() + "\n";
		}
		return listaPeliculas;
	}

	public void mostrarPeliculasGlobal() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("peliculas.txt"))) {
			peliculas = (ArrayList<Pelicula>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo peliculas.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo peliculas.txt.");
			e.printStackTrace();
		}

		System.out.println("Peliculas guardadas:");
		System.out.println(this.toString()); // Aquí se llama al método toString()
	}

	public void modificarPeliculaGlobal() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("peliculas.txt"))) {
			peliculas = (ArrayList<Pelicula>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo peliculas.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo peliculas.txt.");
			e.printStackTrace();
		}

		Scanner ea = new Scanner(System.in);
		System.out.print("Ingrese el título de la película que desea modificar: ");
		String titulo = ea.nextLine();
		boolean encontrada = false;

		for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				encontrada = true;
				System.out.println("La película ha sido encontrada.");
				System.out.print("Ingrese el atributo que desea modificar (titulo, ano, director o genero): ");
				String atributo = ea.nextLine().toLowerCase();

				switch (atributo) {
				case "titulo":
					System.out.print("Ingrese el nuevo título: ");
					String nuevoTitulo = ea.nextLine();
					pelicula.setTitulo(nuevoTitulo);
					break;

				case "ano":
					System.out.print("Ingrese el nuevo año: ");
					int nuevoAno = ea.nextInt();
					pelicula.setAno(nuevoAno);
					break;

				case "director":
					System.out.print("Ingrese el nuevo director: ");
					String nuevoDirector = ea.nextLine();
					pelicula.setDirector(nuevoDirector);
					break;

				case "genero":
					System.out.print("Ingrese el nuevo género: ");
					String nuevoGenero = ea.nextLine();
					pelicula.setGenero(nuevoGenero);
					break;

				default:
					System.out.println("Atributo no válido.");
					break;
				}

				try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("peliculas.txt"))) {
					salida.writeObject(peliculas);
				} catch (FileNotFoundException e) {
					System.out.println("El archivo peliculas.txt no existe.");
				} catch (IOException e) {
					System.out.println("Error al escribir en el archivo peliculas.txt.");
					e.printStackTrace();
				}

				System.out.println("La película ha sido modificada correctamente.");
				break;
			}
		}

		if (!encontrada) {
			System.out.println("La película no ha sido encontrada.");
		}
	}

	public void agregarPeliculaPersonalDeGlobal() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("peliculas.txt"))) {
			peliculas = (ArrayList<Pelicula>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo peliculas.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo peliculas.txt.");
			e.printStackTrace();
		}

		Scanner ea = new Scanner(System.in);
		System.out.print("Ingrese el nombre de la película que desea agregar a su lista personal: ");
		String nombre = ea.nextLine();
		boolean encontrada = false;

		// Buscar la película en el archivo peliculas.txt
		Pelicula peliculaAgregada = null;
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getTitulo().equalsIgnoreCase(nombre)) {
				encontrada = true;
				peliculaAgregada = pelicula;
				break;
			}
		}

		if (!encontrada) {
			System.out.println("La película no se encuentra en el archivo peliculas.txt.");
		} else {
			System.out.println("La película ha sido encontrada:");
			System.out.println(peliculaAgregada);

			try (FileReader fr = new FileReader("ea.txt"); BufferedReader br = new BufferedReader(fr)) {

				String linea;
				boolean existe = false;
				while ((linea = br.readLine()) != null) {
					String[] campos = linea.split(",");
					if (campos[0].equalsIgnoreCase(peliculaAgregada.getTitulo())) {
						System.out.println("La película ya se encuentra en la lista personal.");
						existe = true;
						break;
					}
				}

				if (!existe) {
					try (FileWriter fw = new FileWriter("ea.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter out = new PrintWriter(bw)) {
						out.println(peliculaAgregada.getTitulo() + "," + peliculaAgregada.getAno() + ","
								+ peliculaAgregada.getDirector() + "," + peliculaAgregada.getGenero());
						System.out.println("La película se ha agregado al archivo ea.txt.");
					} catch (IOException e) {
						System.out.println("Error al guardar la película en el archivo ea.txt.");
						e.printStackTrace();
					}
				}

			} catch (IOException e) {
				System.out.println("Error al leer el archivo ea.txt.");
				e.printStackTrace();
			}
		}
	}

	public void listarPeliculasPersonal() {
		try (BufferedReader br = new BufferedReader(new FileReader("ea.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] atributos = linea.split(",");
				System.out.println("Título: " + atributos[0]  + "\nAño: " + atributos[1] +  "\nDirector: "
						+ atributos[2]  + "\nGénero: " + atributos[3] +  "\n----------------------------");

			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo ea.txt no existe.");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo ea.txt.");
			e.printStackTrace();
		}
	}

}
