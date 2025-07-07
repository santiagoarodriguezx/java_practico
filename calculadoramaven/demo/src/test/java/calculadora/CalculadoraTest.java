package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Calculadora
 */
@DisplayName("Pruebas de Calculadora")
public class CalculadoraTest {
    
    private Calculadora calculadora;
    
    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    @DisplayName("Prueba de suma con números positivos")
    void testSumarNumerosPositivos() {
        assertEquals(8.0, calculadora.sumar(5.0, 3.0), 0.001);
        assertEquals(10.5, calculadora.sumar(7.2, 3.3), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de suma con números negativos")
    void testSumarNumerosNegativos() {
        assertEquals(-8.0, calculadora.sumar(-5.0, -3.0), 0.001);
        assertEquals(2.0, calculadora.sumar(5.0, -3.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de suma con cero")
    void testSumarConCero() {
        assertEquals(5.0, calculadora.sumar(5.0, 0.0), 0.001);
        assertEquals(0.0, calculadora.sumar(0.0, 0.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de resta con números positivos")
    void testRestarNumerosPositivos() {
        assertEquals(2.0, calculadora.restar(5.0, 3.0), 0.001);
        assertEquals(3.9, calculadora.restar(7.2, 3.3), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de resta con números negativos")
    void testRestarNumerosNegativos() {
        assertEquals(-2.0, calculadora.restar(-5.0, -3.0), 0.001);
        assertEquals(8.0, calculadora.restar(5.0, -3.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de resta con cero")
    void testRestarConCero() {
        assertEquals(5.0, calculadora.restar(5.0, 0.0), 0.001);
        assertEquals(-5.0, calculadora.restar(0.0, 5.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de multiplicación")
    void testMultiplicar() {
        assertEquals(15.0, calculadora.multiplicar(5.0, 3.0), 0.001);
        assertEquals(-15.0, calculadora.multiplicar(-5.0, 3.0), 0.001);
        assertEquals(0.0, calculadora.multiplicar(5.0, 0.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de división válida")
    void testDividirValida() {
        assertEquals(2.0, calculadora.dividir(6.0, 3.0), 0.001);
        assertEquals(-2.0, calculadora.dividir(-6.0, 3.0), 0.001);
        assertEquals(0.0, calculadora.dividir(0.0, 5.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de división por cero")
    void testDividirPorCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(10.0, 0.0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
    
    @Test
    @DisplayName("Prueba de potencia")
    void testPotencia() {
        assertEquals(8.0, calculadora.potencia(2.0, 3.0), 0.001);
        assertEquals(1.0, calculadora.potencia(5.0, 0.0), 0.001);
        assertEquals(0.25, calculadora.potencia(2.0, -2.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de raíz cuadrada válida")
    void testRaizCuadradaValida() {
        assertEquals(3.0, calculadora.raizCuadrada(9.0), 0.001);
        assertEquals(0.0, calculadora.raizCuadrada(0.0), 0.001);
        assertEquals(2.0, calculadora.raizCuadrada(4.0), 0.001);
    }
    
    @Test
    @DisplayName("Prueba de raíz cuadrada de número negativo")
    void testRaizCuadradaNumeroNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.raizCuadrada(-4.0);
        });
        assertEquals("No se puede calcular la raíz cuadrada de un número negativo", exception.getMessage());
    }
    
    @Test
    @DisplayName("Pruebas de precisión con decimales")
    void testPrecisionDecimales() {
        assertEquals(0.3, calculadora.sumar(0.1, 0.2), 0.001);
        assertEquals(7.77, calculadora.sumar(3.33, 4.44), 0.001);
        assertEquals(1.11, calculadora.restar(4.44, 3.33), 0.001);
    }
}
