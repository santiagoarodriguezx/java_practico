/**
 * Clase que representa un libro en el sistema
 */
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacion;

    // Constructor vacío
    public Libro() {}

    // Constructor con parámetros
    public Libro(int id, String titulo, String autor, int anoPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }

    // Constructor sin ID (para crear nuevos libros)
    public Libro(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public String toString() {
        return String.format("Libro{id=%d, titulo='%s', autor='%s', año=%d}", 
                           id, titulo, autor, anoPublicacion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return id == libro.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
