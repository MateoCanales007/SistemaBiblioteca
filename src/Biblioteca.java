/*
 * Autor: Mateo André Canales Pinto
 */
import java.io.*;
import java.util.ArrayList;


public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public Biblioteca() {
        listaLibros = new ArrayList<>();
//        cargarLibros(); // Carga los libros guardados al iniciar
    }

    public void registrarLibro(String titulo, String autor, int anio, String genero) {
        Libro nuevoLibro = new Libro(titulo, autor, anio, genero);
        listaLibros.add(nuevoLibro);
        System.out.println("¡Libro '" + titulo + "' registrado con éxito!");
//        guardarLibros();
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
}

//    private void cargarLibros() {
//        try {
//            File archivo = new File("libros_db.txt");
//            if (!archivo.exists()) return;
//
//            BufferedReader lector = new BufferedReader(new FileReader(archivo));
//            String linea;
//            while ((linea = lector.readLine()) != null) {
//                String[] datos = linea.split(",");
//                if (datos.length == 5) {
//                    listaLibros.add(new Libro(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], Boolean.parseBoolean(datos[4])));
//                }
//            }
//            lector.close();
//        } catch (Exception e) {
//            System.out.println("Error al cargar el archivo de libros: " + e.getMessage());
//        }
//    }
//}