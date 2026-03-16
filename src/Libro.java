/*
 * Autor: Mateo André Canales Pinto
 */
public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponible;

    // Constructor para registrar un libro nuevo
    public Libro(String titulo, String autor, int anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = true;
    }

    // cargar desde el TXT
    public Libro(String titulo, String autor, int anioPublicacion, String genero, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = disponible;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getGenero() { return genero; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public void mostrarInfo() {
        String estado = disponible ? "Disponible" : "Prestado";
        System.out.println("- '" + titulo + "' por " + autor + " (" + anioPublicacion + ") | Género: " + genero + " | Estado: " + estado);
    }
}