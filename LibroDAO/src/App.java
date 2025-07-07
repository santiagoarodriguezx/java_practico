import java.util.List;

/**
 * Clase principal que demuestra el uso del sistema de gestión de libros
 * utilizando el patrón DAO (Data Access Object)
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE LIBROS ===\n");
        
        // Crear una instancia del DAO
        LibroDAO libroDAO = new LibroDAOImpl();
        
        // Crear algunos libros de ejemplo
        System.out.println("1. CREANDO LIBROS:");
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Libro libro2 = new Libro("Don Quijote de La Mancha", "Miguel de Cervantes", 1605);
        Libro libro3 = new Libro("1984", "George Orwell", 1949);
        Libro libro4 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", 1985);
        
        libroDAO.crear(libro1);
        libroDAO.crear(libro2);
        libroDAO.crear(libro3);
        libroDAO.crear(libro4);
        
        System.out.println("\n2. LISTANDO TODOS LOS LIBROS:");
        List<Libro> todosLosLibros = libroDAO.obtenerTodos();
        todosLosLibros.forEach(System.out::println);
        
        System.out.println("\n3. BUSCANDO LIBRO POR ID:");
        Libro libroEncontrado = libroDAO.buscarPorId(2);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado: " + libroEncontrado);
        } else {
            System.out.println("Libro no encontrado");
        }
        
        System.out.println("\n4. BUSCANDO LIBROS POR AUTOR:");
        List<Libro> librosGarciaMarquez = libroDAO.buscarPorAutor("García Márquez");
        System.out.println("Libros de García Márquez:");
        librosGarciaMarquez.forEach(System.out::println);
        
        System.out.println("\n5. BUSCANDO LIBROS POR TITULO:");
        List<Libro> librosConAmor = libroDAO.buscarPorTitulo("amor");
        System.out.println("Libros que contienen 'amor' en el titulo:");
        librosConAmor.forEach(System.out::println);
        
        System.out.println("\n6. ACTUALIZANDO UN LIBRO:");
        Libro libroParaActualizar = libroDAO.buscarPorId(3);
        if (libroParaActualizar != null) {
            libroParaActualizar.setTitulo("1984 - Edición Especial");
            libroParaActualizar.setAnoPublicacion(2024);
            boolean actualizado = libroDAO.actualizar(libroParaActualizar);
            if (actualizado) {
                System.out.println("Libro actualizado: " + libroParaActualizar);
            }
        }
        
        System.out.println("\n7. ELIMINANDO UN LIBRO:");
        boolean eliminado = libroDAO.eliminar(4);
        if (eliminado) {
            System.out.println("Libro eliminado correctamente");
        }
        
        System.out.println("\n8. ESTADO FINAL - TODOS LOS LIBROS:");
        List<Libro> librosFinales = libroDAO.obtenerTodos();
        librosFinales.forEach(System.out::println);
        
        System.out.println("\n9. ESTADISTICAS:");
        System.out.println("Total de libros en el sistema: " + libroDAO.contarTotal());
        
        // Demostrar manejo de casos edge
        System.out.println("\n10. CASOS DE PRUEBA:");
        
        // Buscar libro que no existe
        Libro libroInexistente = libroDAO.buscarPorId(999);
        System.out.println("Buscando libro con ID 999: " + 
                         (libroInexistente == null ? "No encontrado" : libroInexistente));
        
        // Buscar con cadena vacía
        List<Libro> busquedaVacia = libroDAO.buscarPorTitulo("");
        System.out.println("Busqueda por titulo vacio: " + busquedaVacia.size() + " resultados");
        
        // Intentar eliminar libro que no existe
        boolean eliminacionFallida = libroDAO.eliminar(999);
        System.out.println("Intentar eliminar ID 999: " + 
                         (eliminacionFallida ? "Eliminado" : "No encontrado"));
    }
}
