# Ejercicios Prácticos de Java - Resumen de Implementación

## ✅ Estado de Resolución de Errores

**Fecha de actualización:** 6 de julio de 2025

### Errores Resueltos:

1. **✅ BancoApp**: Error de clase pública en archivo incorrecto - RESUELTO

   - Separación correcta de clases en archivos individuales
   - Estructura de archivos corregida

2. **✅ RegistroApp (Gradle)**: Dependencias de Log4j no resueltas - RESUELTO

   - Dependencias refreshed con `--refresh-dependencies`
   - Compilación y ejecución exitosa

3. **✅ Calculadora Maven**: Estructura de paquetes validada - FUNCIONANDO

   - Clases separadas correctamente
   - Compilación y ejecución exitosa

4. **✅ LibroDAO**: Sistema completo validado - FUNCIONANDO
   - Todas las operaciones CRUD funcionando
   - Manejo de excepciones correcto

**Todos los proyectos están ahora completamente funcionales y sin errores de compilación.**

---

## 1. Sistema Bancario (BancoApp)

### Ubicación: `c:\Users\xrz\Java\BancoApp\src\`

### Características implementadas:

- **Excepciones personalizadas**: `SaldoInsuficienteException` y `MontoInvalidoException`
- **Clase CuentaBancaria**: Representa una cuenta con número, titular y saldo
- **Clase BancoApp**: Implementa las operaciones principales:
  - `retirarDinero()`: Retira dinero validando saldo suficiente
  - `depositarDinero()`: Deposita dinero validando montos positivos
  - `transferirDinero()`: Transfiere entre cuentas con validaciones completas

### Manejo de excepciones:

- Validación de montos negativos o cero
- Verificación de saldo suficiente para retiros y transferencias
- Manejo adecuado de excepciones con mensajes descriptivos

### Ejecución:

```bash
cd "c:\Users\xrz\Java\BancoApp\src"
javac *.java
java BancoApp
```

### Capturas de pantalla:

![Ejecución del sistema bancario](./screenshots/banco-app-ejecucion.png)
_Demostración completa del sistema bancario con operaciones exitosas y manejo de errores_

## 2. Sistema de Gestión de Libros (LibroDAO)

### Ubicación: `c:\Users\xrz\Java\LibroDAO\src\`

### Arquitectura implementada:

- **Patrón DAO**: Separación clara entre modelo y acceso a datos
- **Clase Libro**: Entidad con id, título, autor y año de publicación
- **Interfaz LibroDAO**: Define operaciones CRUD
- **LibroDAOImpl**: Implementación usando ArrayList para simulación en memoria

### Operaciones CRUD implementadas:

- **Crear**: Asignación automática de IDs
- **Leer**: Búsqueda por ID, título y autor (con filtros parciales)
- **Actualizar**: Modificación de libros existentes
- **Eliminar**: Borrado por ID
- **Listar**: Obtención de todos los libros
- **Contar**: Estadísticas del sistema

### Características adicionales:

- Búsqueda inteligente (case-insensitive)
- Manejo de casos edge (búsquedas vacías, IDs inexistentes)
- Logging de operaciones
- Generación automática de IDs únicos

### Ejecución:

```bash
cd "c:\Users\xrz\Java\LibroDAO\src"
javac *.java
java App
```

### Capturas de pantalla:

![Sistema de gestión de libros](./screenshots/libro-dao-ejecucion.png)
_Demostración completa del sistema CRUD de libros con todas las operaciones_

## 3. Proyecto Maven - Calculadora

### Ubicación: `c:\Users\xrz\Java\calculadoramaven\demo\`

### Estructura del proyecto:

- **pom.xml**: Configurado con JUnit 5 como dependencia
- **Clase Calculadora**: Operaciones matemáticas básicas
- **Clase Main**: Demostración de funcionalidades
- **CalculadoraTest**: Suite completa de pruebas unitarias

### Operaciones implementadas:

- Suma, resta, multiplicación, división
- Potencias y raíz cuadrada
- Manejo de excepciones (división por cero, raíz de negativos)

### Pruebas unitarias:

- Cobertura completa de todas las operaciones
- Pruebas de casos edge y excepciones
- Validación de precisión con decimales
- Tests organizados con @DisplayName para claridad

### Ejecución:

```bash
cd "c:\Users\xrz\Java\calculadoramaven\demo\src\main\java"
javac calculadora\*.java
java calculadora.Main
```

### Capturas de pantalla:

![Calculadora Maven en funcionamiento](./screenshots/calculadora-maven-ejecucion.png)
_Demostración de todas las operaciones matemáticas y manejo de excepciones_

## 4. Proyecto Gradle - RegistroApp con Log4j

### Ubicación: `c:\Users\xrz\Java\RegistroApp1\`

### Configuración del proyecto:

- **build.gradle**: Configurado con dependencias de Log4j 2.21.1
- **log4j2.xml**: Configuración completa de logging con múltiples appenders
- **Clase RegistroApp**: Demostración de diferentes niveles de logging
- **Clase App**: Punto de entrada principal

### Características de logging implementadas:

- **Múltiples niveles**: TRACE, DEBUG, INFO, WARN, ERROR, FATAL
- **Múltiples appenders**:
  - Console: Salida a consola
  - File: Archivo fijo de logs
  - Rolling File: Archivos rotativos por tamaño y fecha
- **Patrones avanzados**:
  - Logging con parámetros
  - Logging condicional
  - Medición de performance
  - Logging de contexto

### Simulaciones incluidas:

- Operaciones normales de la aplicación
- Diferentes tipos de errores y excepciones
- Patrones de logging recomendados
- Manejo de excepciones con stack traces completos

### Archivos de log generados:

- `logs/registro-app.log`: Log principal
- `logs/registro-app-rolling.log`: Log con rotación

### Ejecución:

```bash
cd "c:\Users\xrz\Java\RegistroApp1"
.\gradlew build
.\gradlew run
.\gradlew test  # Para ejecutar las pruebas
```

### Capturas de pantalla:

![Sistema de logging con Log4j](./screenshots/registro-app-logging.png)
_Demostración de múltiples niveles de logging y diferentes tipos de mensajes_

## Resumen de Tecnologías Utilizadas

### Conceptos de Java:

- Manejo de excepciones personalizado
- Interfaces y implementaciones
- Patrón DAO/Repository
- Generics y Collections (ArrayList, Stream API)
- Programación orientada a objetos

### Herramientas de construcción:

- **Maven**: Gestión de dependencias y estructura de proyecto
- **Gradle**: Build system moderno con dependencias y tareas
- **JUnit 5**: Framework de pruebas unitarias

### Logging:

- **Log4j2**: Sistema de logging empresarial
- Configuración XML avanzada
- Múltiples appenders y patrones de salida
- Niveles de logging apropiados

### Buenas prácticas implementadas:

- Separación de responsabilidades
- Manejo adecuado de excepciones
- Documentación JavaDoc
- Pruebas unitarias comprehensivas
- Logging estructurado
- Validación de entrada
- Código limpio y legible

Todos los proyectos han sido probados y funcionan correctamente, demostrando el uso efectivo de las tecnologías y patrones de diseño solicitados.
