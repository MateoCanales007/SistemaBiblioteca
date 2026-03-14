/*
 * Autor: Mateo André Canales Pinto
 */
import java.io.*;
import java.util.ArrayList;


public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    private ArrayList<Lector> listaLectores;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        cargarLibros(); // Carga los libros guardados al iniciar
        listaLectores = new ArrayList<>();
        cargarLectores();
    }

    public void registrarLector(String nombre, String identificacion) {

        for (Lector lector : listaLectores) {
            if (lector.getIdentificacion().equals(identificacion)) {
                System.out.println("Ya existe un lector con esa identificación.");
                return;
            }
        }

        Lector nuevoLector = new Lector(nombre, identificacion);
        listaLectores.add(nuevoLector);

        System.out.println("¡Lector registrado con éxito!");
        guardarLectores();
    }

    public void listarLectores() {

        if (listaLectores.isEmpty()) {
            System.out.println("No hay lectores registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE LECTORES ---");

        for (Lector lector : listaLectores) {
            lector.mostrarInfo();
        }
    }

    private void guardarLectores() {

        try {
            FileWriter escritor = new FileWriter("lectores_db.txt", false);

            for (Lector lector : listaLectores) {

                String libros = String.join(";", lector.getLibrosPrestados());

                escritor.write(
                        lector.getNombre() + "," +
                                lector.getIdentificacion() + "," +
                                libros + "\n"
                );
            }

            escritor.close();

        } catch (Exception e) {
            System.out.println("Error al guardar lectores: " + e.getMessage());
        }
    }

    private void cargarLectores() {

        try {

            File archivo = new File("lectores_db.txt");

            if (!archivo.exists()) return;

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",", 3);

                if (datos.length >= 2) {

                    ArrayList<String> librosPrestados = new ArrayList<>();

                    if (datos.length == 3 && !datos[2].isEmpty()) {

                        String[] libros = datos[2].split(";");

                        for (String libro : libros) {
                            librosPrestados.add(libro);
                        }
                    }

                    listaLectores.add(
                            new Lector(datos[0], datos[1], librosPrestados)
                    );
                }
            }

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al cargar lectores: " + e.getMessage());
        }
    }

    public void registrarLibro(String titulo, String autor, int anio, String genero) {
        Libro nuevoLibro = new Libro(titulo, autor, anio, genero);
        listaLibros.add(nuevoLibro);
        System.out.println("¡Libro '" + titulo + "' registrado con éxito!");
        guardarLibros();
    }

    public void listarTodosLosLibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }
        System.out.println("\n--- LISTA DE LIBROS ---");
        for (Libro libro : listaLibros) {
            libro.mostrarInfo();
        }
    }

    private void guardarLibros() {
        try {
            FileWriter escritor = new FileWriter("libros_db.txt", false);
            for (Libro libro : listaLibros) {
                escritor.write(libro.getTitulo() + "," + libro.getAutor() + "," +
                        libro.getAnioPublicacion() + "," + libro.getGenero() + "," +
                        libro.isDisponible() + "\n");
            }
            escritor.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    private void cargarLibros() {
        try {
            File archivo = new File("libros_db.txt");
            if (!archivo.exists()) return;

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    listaLibros.add(new Libro(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], Boolean.parseBoolean(datos[4])));
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo de libros: " + e.getMessage());
        }
    }
}