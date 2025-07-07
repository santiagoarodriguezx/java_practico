import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Implementación de LibroDAO que simula el almacenamiento en memoria
 * utilizando un ArrayList
 */
public class LibroDAOImpl implements LibroDAO {
    
    private List<Libro> libros;
    private AtomicInteger contadorId;
    
    public LibroDAOImpl() {
        this.libros = new ArrayList<>();
        this.contadorId = new AtomicInteger(0);
    }
    
    @Override
    public Libro crear(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser null");
        }
        
        // Asignar un nuevo ID
        libro.setId(contadorId.incrementAndGet());
        libros.add(libro);
        
        System.out.printf("Libro creado exitosamente: %s\n", libro);
        return libro;
    }
    
    @Override
    public Libro buscarPorId(int id) {
        return libros.stream()
                    .filter(libro -> libro.getId() == id)
                    .findFirst()
                    .orElse(null);
    }
    
    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return libros.stream()
                    .filter(libro -> libro.getTitulo().toLowerCase()
                                         .contains(titulo.toLowerCase()))
                    .collect(Collectors.toList());
    }
    
    @Override
    public List<Libro> buscarPorAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return libros.stream()
                    .filter(libro -> libro.getAutor().toLowerCase()
                                         .contains(autor.toLowerCase()))
                    .collect(Collectors.toList());
    }
    
    @Override
    public List<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }
    
    @Override
    public boolean actualizar(Libro libro) {
        if (libro == null || libro.getId() <= 0) {
            return false;
        }
        
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                System.out.printf("Libro actualizado exitosamente: %s\n", libro);
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean eliminar(int id) {
        boolean eliminado = libros.removeIf(libro -> libro.getId() == id);
        
        if (eliminado) {
            System.out.printf("Libro con ID %d eliminado exitosamente\n", id);
        }
        
        return eliminado;
    }
    
    @Override
    public int contarTotal() {
        return libros.size();
    }
}
