import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad Libro
 * Implementa el patrón DAO (Data Access Object)
 */
public interface LibroDAO {
    
    /**
     * Crea un nuevo libro en el sistema
     * @param libro El libro a crear
     * @return El libro creado con su ID asignado
     */
    Libro crear(Libro libro);
    
    /**
     * Busca un libro por su ID
     * @param id El ID del libro a buscar
     * @return El libro encontrado o null si no existe
     */
    Libro buscarPorId(int id);
    
    /**
     * Busca libros por título
     * @param titulo El título a buscar (búsqueda parcial)
     * @return Lista de libros que contienen el título especificado
     */
    List<Libro> buscarPorTitulo(String titulo);
    
    /**
     * Busca libros por autor
     * @param autor El autor a buscar (búsqueda parcial)
     * @return Lista de libros del autor especificado
     */
    List<Libro> buscarPorAutor(String autor);
    
    /**
     * Obtiene todos los libros del sistema
     * @return Lista con todos los libros
     */
    List<Libro> obtenerTodos();
    
    /**
     * Actualiza un libro existente
     * @param libro El libro con los datos actualizados
     * @return true si se actualizó correctamente, false si no existe
     */
    boolean actualizar(Libro libro);
    
    /**
     * Elimina un libro por su ID
     * @param id El ID del libro a eliminar
     * @return true si se eliminó correctamente, false si no existe
     */
    boolean eliminar(int id);
    
    /**
     * Cuenta el total de libros en el sistema
     * @return El número total de libros
     */
    int contarTotal();
}
