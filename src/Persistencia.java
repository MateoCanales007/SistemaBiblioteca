import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    private String archivo = "libros_db.txt";

    public void guardarLibros(ArrayList<Libro> listaLibros) {

        try {
            FileWriter escritor = new FileWriter(archivo, false);

            for (Libro libro : listaLibros) {

                escritor.write(
                        libro.getTitulo() + "," +
                            libro.getAutor() + "," +
                            libro.getAnioPublicacion() + "," +
                            libro.getGenero() + "," +
                            libro.isDisponible() + "\n"
                );
            }

            escritor.close();
        }   catch (Exception e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
}

    public ArrayList<Libro> cargarLibros() {

        ArrayList<Libro> listaLibros = new ArrayList<>();

        try {

            File archivoLibros = new File(archivo);

            if (!archivoLibros.exists()) {
                return listaLibros;
            }

            BufferedReader lector = new BufferedReader(new FileReader(archivoLibros));

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 5) {

                    String titulo = datos[0];
                    String autor = datos[1];
                    int anio = Integer.parseInt(datos[2]);
                    String genero = datos[3];
                    boolean disponible = Boolean.parseBoolean(datos[4]);

                    Libro libro = new Libro(titulo, autor, anio, genero, disponible);

                    listaLibros.add(libro);
                }
            }

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al cargar libros: " + e.getMessage());
        }

        return listaLibros;
    }
}