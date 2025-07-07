package calculadora;

/**
 * Clase Calculadora que implementa operaciones matemáticas básicas
 */
public class Calculadora {
    
    /**
     * Suma dos números
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public double sumar(double a, double b) {
        return a + b;
    }
    
    /**
     * Resta dos números
     * @param a primer número (minuendo)
     * @param b segundo número (sustraendo)
     * @return la resta de a menos b
     */
    public double restar(double a, double b) {
        return a - b;
    }
    
    /**
     * Multiplica dos números
     * @param a primer número
     * @param b segundo número
     * @return el producto de a y b
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }
    
    /**
     * Divide dos números
     * @param a dividendo
     * @param b divisor
     * @return el cociente de a dividido por b
     * @throws IllegalArgumentException si b es cero
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }
    
    /**
     * Calcula la potencia de un número
     * @param base la base
     * @param exponente el exponente
     * @return base elevado a la potencia exponente
     */
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
    
    /**
     * Calcula la raíz cuadrada de un número
     * @param numero el número
     * @return la raíz cuadrada del número
     * @throws IllegalArgumentException si el número es negativo
     */
    public double raizCuadrada(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        return Math.sqrt(numero);
    }
}
