package calculadora;

/**
 * Clase principal para demostrar el uso de la Calculadora
 */
public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        System.out.println("=== DEMO CALCULADORA MAVEN ===\n");
        
        // Demostraciones de operaciones
        double a = 10.0;
        double b = 3.0;
        
        System.out.printf("Números de prueba: a = %.1f, b = %.1f\n\n", a, b);
        
        System.out.printf("Suma: %.1f + %.1f = %.1f\n", a, b, calc.sumar(a, b));
        System.out.printf("Resta: %.1f - %.1f = %.1f\n", a, b, calc.restar(a, b));
        System.out.printf("Multiplicación: %.1f * %.1f = %.1f\n", a, b, calc.multiplicar(a, b));
        System.out.printf("División: %.1f / %.1f = %.2f\n", a, b, calc.dividir(a, b));
        System.out.printf("Potencia: %.1f ^ %.1f = %.2f\n", a, b, calc.potencia(a, b));
        System.out.printf("Raíz cuadrada de %.1f = %.2f\n", a, calc.raizCuadrada(a));
        
        // Demostrar manejo de excepciones
        System.out.println("\n=== MANEJO DE EXCEPCIONES ===");
        
        try {
            System.out.println("Intentando dividir por cero:");
            calc.dividir(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando calcular raíz cuadrada de número negativo:");
            calc.raizCuadrada(-4);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        
        System.out.println("\nEjecución completada exitosamente!");
    }
}