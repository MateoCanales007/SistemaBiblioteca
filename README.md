# SistemaBiblioteca

## Cómo clonar el repositorio desde IntelliJ IDEA

Para que todos tengamos la misma configuración, sigan estos pasos para descargar el proyecto directamente en IntelliJ:

1. Copia la URL del repositorio desde GitHub (el botón verde que dice **Code**).
2. En **IntelliJ IDEA** en la pantalla de inicio, selecciona **Get from VCS** 
4. En el campo **URL**, pega la dirección del repositorio.
5. guardar el proyecto.
6. Haz clic en el botón **Clone**.

---

## Lo que ya hice (Completado)

Aquí detallo las tareas y configuraciones que ya dejé listas en esta versión:

- [x] Registrar libros con atributos como título, autor, año de publicación, género y disponibilidad.
- [x] Listar libros filtrando por género, autor o disponibilidad.

---

## Lo que hace falta

Estas son las tareas pendientes en las que necesitamos trabajar. Si alguien toma una, recuerde marcarla con una `x` dentro de los corchetes: `- [x]` y hacer el commit.

- [] Registrar usuarios (lectores) con nombre, número de identificación y libros prestados.
- [] Realizar préstamos y devoluciones de libros, validando disponibilidad.
- [] Guardar y cargar datos en un archivo de texto (persistencia básica).

---

## 💡 Notas adicionales

* Por favor, asegúrense de crear una rama nueva (`git checkout -b feature/nombre-rama`) antes de empezar a trabajar en algo nuevo para no chocar con la rama `main` y hacer PRs (si quieren).

## Requisitos Técnicos
* Uso de POO (clases Libro, Usuario, Biblioteca, Main).
* Uso de colecciones en Java (ArrayList, HashMap o similares).
* Manejo de archivos (FileReader, FileWriter, o BufferedReader/BufferedWriter).
* Uso de menú interactivo en consola con opciones numéricas.
* Validaciones de entrada (por ejemplo, que no se pueda prestar un libro ya prestado).
* División de funcionalidades por módulos (métodos bien definidos).
