package com.projecte.classes;



import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



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
        return "Nombre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nNacionalidad: "
                + this.nacionalidad + "\nFecha de Nacimiento: " + this.id_director + "\n";

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

class CrearDirectorUsuarioGlobal {
    private ArrayList<Director> directores;

    public CrearDirectorUsuarioGlobal() {
        directores = new ArrayList<Director>();
    }

    public void agregarDirector(Director director) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("directores.txt"))) {
            directores = (ArrayList<Director>) entrada.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo directores.txt no existe.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo directores.txt.");
            e.printStackTrace();
        }

        directores.add(director);
    }

    public void guardarDirectoresGlobal() {
        try {
            FileOutputStream leerFile = new FileOutputStream("directores.txt");
            ObjectOutputStream objFile = new ObjectOutputStream(leerFile);
            objFile.writeObject(directores);
            objFile.close();
            leerFile.close();
            System.out.println("Se han guardado los directores en el archivo directores.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar los directores en el archivo directores.txt.");
            e.printStackTrace();
        }
    }

    public String toString() {
        String listaDirectores = "";
        for (int i = 0; i < directores.size(); i++) {
            Director director = directores.get(i);
            listaDirectores += director.toString() + "\n";
        }
        return listaDirectores;

        
        
    }
    public void mostrarPeliculasGlobal() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("directores.txt"))) {
			directores = (ArrayList<Director>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo directores.txt no existe.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo directores.txt.");
			e.printStackTrace();
		}

		System.out.println("Directores guardadas:");
		System.out.println(this.toString()); // Aquí se llama al método toString()
	}

    public void modificarActorGlobal() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Introduce el nombre del director que deseas modificar:");
    	String nombreDirector = scanner.nextLine();
    	boolean encontrado = false;
    	ArrayList<Director> actores = null;
    	try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("directores.txt"))) {
    	    directores = (ArrayList<Director>) entrada.readObject();
    	} catch (FileNotFoundException e) {
    	    System.out.println("El archivo directores.txt no existe.");
    	} catch (IOException | ClassNotFoundException e) {
    	    System.out.println("Error al leer el archivo directores.txt.");
    	    e.printStackTrace();
    	}

    	for (int i = 0; i < directores.size(); i++) {
    	    Director director = directores.get(i);
    	    if (director.getNombre().equals(nombreDirector)) {
    	        System.out.println("Introduce el nuevo nombre del director:");
    	        String nuevoNombre = scanner.nextLine();
    	        System.out.println("Introduce los nuevos apellidos del director:");
    	        String nuevosApellidos = scanner.nextLine();
    	        System.out.println("Introduce la nueva nacionalidad del director:");
    	        String nuevaNacionalidad = scanner.nextLine();
    	        System.out.println("Introduce la nueva fecha de nacimiento del director:");
    	        int nuevoId = scanner.nextInt();

    	        director.setNombre(nuevoNombre);
    	        director.setApellidos(nuevosApellidos);
    	        director.setNacionalidad(nuevaNacionalidad);
    	        director.setId_director(nuevoId);

    	        encontrado = true;
    	        directores.set(i, director);
    	        break;
    	    }
    	}

    	if (encontrado) {
    	    try {
    	        FileOutputStream leerFile = new FileOutputStream("directores.txt");
    	        ObjectOutputStream objFile = new ObjectOutputStream(leerFile);
    	        objFile.writeObject(directores);
    	        objFile.close();
    	        leerFile.close();
    	        System.out.println("Se ha modificado el actor en el archivo directores.txt.");
    	    } catch (IOException e) {
    	        System.out.println("Error al guardar los actores en el archivo directores.txt.");
    	        e.printStackTrace();
    	    }
    	} else {
    	    System.out.println("El director no se ha encontrado en el archivo directores.txt.");
    	}
    	}




    	public void agregarDirectorPersonalDeGlobal() {
    	    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("directores.txt"))) {
    	        directores = (ArrayList<Director>) entrada.readObject();
    	    } catch (FileNotFoundException e) {
    	        System.out.println("El archivo directores.txt no existe.");
    	    } catch (IOException | ClassNotFoundException e) {
    	        System.out.println("Error al leer el archivo directores.txt.");
    	        e.printStackTrace();
    	    }

    	    Scanner ea = new Scanner(System.in);
    	    System.out.print("Ingrese el nombre del actor que desea agregar a su lista personal: ");
    	    String nombre = ea.nextLine();
    	    boolean encontrado = false;

    	    // Buscar el actor en el archivo actores.txt
    	    Director directorAgregado = null;
    	    for (int i = 0; i < directores.size(); i++) {
    	        Director director = directores.get(i);
    	        if (director.getNombre().equalsIgnoreCase(nombre)) {
    	            encontrado = true;
    	            directorAgregado = director;
    	            break;
    	        }
    	    }

    	    if (!encontrado) {
    	        System.out.println("El director no se encuentra en el archivo actores.txt.");
    	    } else {
    	        System.out.println("El director ha sido encontrado:");
    	        System.out.println(directorAgregado);

    	        try (FileReader fr = new FileReader("ea.txt"); BufferedReader br = new BufferedReader(fr)) {

    	            String linea;
    	            boolean existe = false;
    	            while ((linea = br.readLine()) != null) {
    	                String[] campos = linea.split(",");
    	                if (campos[0].equalsIgnoreCase(directorAgregado.getNombre())) {
    	                    System.out.println("El director ya se encuentra en la lista personal.");
    	                    existe = true;
    	                    break;
    	                }
    	            }

    	            if (!existe) {
    	                try (FileWriter fw = new FileWriter("ea.txt", true);
    	                        BufferedWriter bw = new BufferedWriter(fw);
    	                        PrintWriter out = new PrintWriter(bw)) {
    	                    System.out.println(directorAgregado.getNombre() + "," + directorAgregado.getApellidos() + ","
    	                            + directorAgregado.getNacionalidad() + "," + directorAgregado.getFechaNacimiento());
    	                    System.out.println("El director se ha agregado al archivo ea.txt.");
    	                } catch (IOException e) {
    	                    System.out.println("Error al guardar el director en el archivo ea.txt.");
    	                    e.printStackTrace();
    	                }
    	            }

    	        } catch (IOException e) {
    	            System.out.println("Error al leer el archivo ea.txt.");
    	            e.printStackTrace();
    	        }
    	    }
    	}

    	public void listarDirectores() {
    	try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("actores.txt"))) {
    	ArrayList<Director> directores = (ArrayList<Director>) entrada.readObject();
    	for (int i = 0; i < directores.size(); i++) {
    	Director director = directores.get(i);
    	System.out.println("Nombre: " + director.getNombre() + "\nApellidos: " + director.getApellidos() +
    	"\nNacionalidad: " + director.getNacionalidad() + "\nFecha de Nacimiento: " + director.getFechaNacimiento()
    	+ "\n------------------------");
    	}
    	} catch (FileNotFoundException e) {
    	System.out.println("El archivo directores.txt no existe.");
    	} catch (IOException | ClassNotFoundException e) {
    	System.out.println("Error al leer el archivo directores.txt.");
    	e.printStackTrace();
    	}
    	}

    	public void buscarDirector() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Introduce el nombre del director que deseas buscar:");
    	String nombreDirector = scanner.nextLine();
    	boolean encontrado = false;
    	try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("directores.txt"))) {
    	ArrayList<Director> directores = (ArrayList<Director>) entrada.readObject();
    	for (int i = 0; i < directores.size(); i++) {
    	Director director = directores.get(i);
    	if (director.getNombre().equals(nombreDirector)) {
    	System.out.println("Actor encontrado: \n" + director.toString());
    	encontrado = true;
    	break;
    	}
    	}
    	if (!encontrado) {
    	System.out.println("No se encontró el actor con nombre " + nombreDirector);
    	}
    	} catch (FileNotFoundException e) {
    	System.out.println("El archivo directores.txt no existe.");
    	} catch (IOException | ClassNotFoundException e) {
    	System.out.println("Error al leer el archivo directores.txt.");
    	e.printStackTrace();
    	}
    	}
}
    