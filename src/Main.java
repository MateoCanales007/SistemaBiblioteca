import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca miBiblioteca = new Biblioteca();
        int opcion = 0;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Registrar lector");
            System.out.println("4. Listar lectores");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();

                    miBiblioteca.registrarLibro(titulo, autor, anio, genero);
                    break;
                case 2:
                    miBiblioteca.listarTodosLosLibros();
                    break;
                case 3:
                    System.out.print("Nombre del lector: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Número de identificación: ");
                    String id = scanner.nextLine();

                    miBiblioteca.registrarLector(nombre, id);
                    break;
                case 4:
                    miBiblioteca.listarLectores();
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}