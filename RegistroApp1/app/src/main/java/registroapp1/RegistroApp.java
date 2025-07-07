package registroapp1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Aplicación que demuestra el uso de Log4j con diferentes niveles de logging
 */
public class RegistroApp {
    
    // Crear el logger para esta clase
    private static final Logger logger = LogManager.getLogger(RegistroApp.class);
    
    /**
     * Simula operaciones de la aplicación con diferentes niveles de logging
     */
    public void ejecutarOperaciones() {
        logger.trace("Iniciando ejecución de operaciones - TRACE");
        logger.debug("Información de debug - DEBUG");
        logger.info("Aplicación iniciada correctamente - INFO");
        logger.warn("Esta es una advertencia - WARN");
        
        try {
            // Simular una operación que puede fallar
            procesarDatos();
            
        } catch (Exception e) {
            logger.error("Error durante el procesamiento de datos", e);
        }
        
        logger.info("Operaciones completadas");
    }
    
    /**
     * Simula el procesamiento de datos con diferentes escenarios
     */
    private void procesarDatos() {
        logger.debug("Iniciando procesamiento de datos");
        
        // Simular diferentes escenarios
        for (int i = 1; i <= 5; i++) {
            logger.info("Procesando elemento {}", i);
            
            if (i == 3) {
                logger.warn("Elemento {} requiere atención especial", i);
            }
            
            if (i == 4) {
                logger.error("Error al procesar elemento {}", i);
                throw new RuntimeException("Error simulado en elemento " + i);
            }
            
            // Simular tiempo de procesamiento
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.warn("Procesamiento interrumpido", e);
                Thread.currentThread().interrupt();
            }
        }
        
        logger.debug("Procesamiento de datos completado");
    }
    
    /**
     * Demuestra el uso de diferentes patrones de logging
     */
    public void demostrarPatronesLogging() {
        logger.info("=== DEMOSTRANDO PATRONES DE LOGGING ===");
        
        // Logging con parámetros
        String usuario = "Juan";
        int intentos = 3;
        logger.info("Usuario {} ha realizado {} intentos de login", usuario, intentos);
        
        // Logging condicional
        if (logger.isDebugEnabled()) {
            logger.debug("Información detallada de debug (solo se muestra si DEBUG está habilitado)");
        }
        
        // Logging de performance
        long inicioTiempo = System.currentTimeMillis();
        
        // Simular operación costosa
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long tiempoTranscurrido = System.currentTimeMillis() - inicioTiempo;
        logger.info("Operación completada en {} ms", tiempoTranscurrido);
        
        // Logging de contexto
        logger.info("Contexto de la aplicación - Versión: 1.0, Entorno: Desarrollo");
    }
    
    /**
     * Simula diferentes tipos de errores para demostrar el logging de excepciones
     */
    public void simularErrores() {
        logger.info("=== SIMULANDO DIFERENTES TIPOS DE ERRORES ===");
        
        // Error de validación
        try {
            validarDatos(null);
        } catch (IllegalArgumentException e) {
            logger.error("Error de validación: {}", e.getMessage());
        }
        
        // Error de conexión simulado
        try {
            conectarBaseDatos();
        } catch (RuntimeException e) {
            logger.error("Error de conexión a la base de datos", e);
        }
        
        // Error de negocio
        try {
            procesarTransaccion(-100);
        } catch (Exception e) {
            logger.error("Error en el procesamiento de transacción", e);
        }
    }
    
    private void validarDatos(String datos) {
        if (datos == null || datos.trim().isEmpty()) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos o vacíos");
        }
    }
    
    private void conectarBaseDatos() {
        logger.debug("Intentando conectar a la base de datos");
        throw new RuntimeException("Conexión a la base de datos falló - servidor no disponible");
    }
    
    private void procesarTransaccion(double monto) {
        logger.debug("Procesando transacción por monto: {}", monto);
        if (monto < 0) {
            throw new IllegalArgumentException("El monto de la transacción no puede ser negativo");
        }
    }
}
