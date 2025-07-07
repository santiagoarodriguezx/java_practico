// Excepción personalizada para saldo insuficiente
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para monto inválido
class MontoInvalidoException extends Exception {
    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Clase que representa una cuenta bancaria
class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private String titular;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return String.format("Cuenta: %s | Titular: %s | Saldo: $%.2f", 
                           numeroCuenta, titular, saldo);
    }
}

// Clase principal del sistema bancario
public class BancoApp {
    
    /**
     * Retira dinero de una cuenta
     * @param cuenta La cuenta de la cual retirar
     * @param monto El monto a retirar
     * @throws SaldoInsuficienteException Si no hay saldo suficiente
     * @throws MontoInvalidoException Si el monto es negativo o cero
     */
    public void retirarDinero(CuentaBancaria cuenta, double monto) 
            throws SaldoInsuficienteException, MontoInvalidoException {
        
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a retirar debe ser mayor a cero");
        }
        
        if (cuenta.getSaldo() < monto) {
            throw new SaldoInsuficienteException(
                String.format("Saldo insuficiente. Saldo actual: $%.2f, Monto solicitado: $%.2f", 
                            cuenta.getSaldo(), monto));
        }
        
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        System.out.printf("Retiro exitoso: $%.2f de la cuenta %s\n", monto, cuenta.getNumeroCuenta());
    }
    
    /**
     * Deposita dinero en una cuenta
     * @param cuenta La cuenta en la cual depositar
     * @param monto El monto a depositar
     * @throws MontoInvalidoException Si el monto es negativo o cero
     */
    public void depositarDinero(CuentaBancaria cuenta, double monto) 
            throws MontoInvalidoException {
        
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a depositar debe ser mayor a cero");
        }
        
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        System.out.printf("Depósito exitoso: $%.2f en la cuenta %s\n", monto, cuenta.getNumeroCuenta());
    }
    
    /**
     * Transfiere dinero entre dos cuentas
     * @param cuentaOrigen La cuenta de origen
     * @param cuentaDestino La cuenta de destino
     * @param monto El monto a transferir
     * @throws SaldoInsuficienteException Si la cuenta origen no tiene saldo suficiente
     * @throws MontoInvalidoException Si el monto es negativo o cero
     */
    public void transferirDinero(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, double monto) 
            throws SaldoInsuficienteException, MontoInvalidoException {
        
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a transferir debe ser mayor a cero");
        }
        
        if (cuentaOrigen.getSaldo() < monto) {
            throw new SaldoInsuficienteException(
                String.format("Saldo insuficiente en cuenta origen. Saldo actual: $%.2f, Monto solicitado: $%.2f", 
                            cuentaOrigen.getSaldo(), monto));
        }
        
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
        
        System.out.printf("Transferencia exitosa: $%.2f de %s a %s\n", 
                         monto, cuentaOrigen.getNumeroCuenta(), cuentaDestino.getNumeroCuenta());
    }

    public static void main(String[] args) {
        BancoApp banco = new BancoApp();
        
        // Crear cuentas de prueba
        CuentaBancaria cuenta1 = new CuentaBancaria("001", "Juan Pérez", 1000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("002", "María García", 500.0);
        
        System.out.println("=== SISTEMA BANCARIO ===\n");
        System.out.println("Estado inicial:");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println();
        
        try {
            // Operación 1: Depósito exitoso
            System.out.println("1. Depositando $200 en cuenta 001:");
            banco.depositarDinero(cuenta1, 200.0);
            System.out.println(cuenta1);
            System.out.println();
            
            // Operación 2: Retiro exitoso
            System.out.println("2. Retirando $150 de cuenta 001:");
            banco.retirarDinero(cuenta1, 150.0);
            System.out.println(cuenta1);
            System.out.println();
            
            // Operación 3: Transferencia exitosa
            System.out.println("3. Transfiriendo $300 de cuenta 001 a cuenta 002:");
            banco.transferirDinero(cuenta1, cuenta2, 300.0);
            System.out.println(cuenta1);
            System.out.println(cuenta2);
            System.out.println();
            
            // Operación 4: Intento de retiro con saldo insuficiente
            System.out.println("4. Intentando retirar $1000 de cuenta 001 (debería fallar):");
            banco.retirarDinero(cuenta1, 1000.0);
            
        } catch (SaldoInsuficienteException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println();
        } catch (MontoInvalidoException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println();
        }
        
        try {
            // Operación 5: Intento de depósito con monto negativo
            System.out.println("5. Intentando depositar $-50 en cuenta 002 (debería fallar):");
            banco.depositarDinero(cuenta2, -50.0);
            
        } catch (MontoInvalidoException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println();
        }
        
        try {
            // Operación 6: Intento de transferencia con saldo insuficiente
            System.out.println("6. Intentando transferir $2000 de cuenta 002 a cuenta 001 (debería fallar):");
            banco.transferirDinero(cuenta2, cuenta1, 2000.0);
            
        } catch (SaldoInsuficienteException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println();
        } catch (MontoInvalidoException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println();
        }
        
        System.out.println("Estado final:");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }
}
