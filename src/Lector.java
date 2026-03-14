import java.util.ArrayList;

public class Lector {
    private String nombre;
    private String identificacion;
    private ArrayList<String> librosPrestados;

    public Lector(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.librosPrestados = new ArrayList<>();
    }

    public Lector(String nombre, String identificacion, ArrayList<String> librosPrestados) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.librosPrestados = librosPrestados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public ArrayList<String> getLibrosPrestados() {
        return librosPrestados;
    }

    public void agregarLibroPrestado(String tituloLibro) {
        librosPrestados.add(tituloLibro);
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);

        if (librosPrestados.isEmpty()) {
            System.out.println("Libros prestados: Ninguno");
        } else {
            System.out.println("Libros prestados: " + librosPrestados);
        }

        System.out.println("-----------------------");
    }
}