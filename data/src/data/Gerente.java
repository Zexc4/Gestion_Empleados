package data;

/**
 * Clase que representa a un Gerente, que es un tipo especializado de Empleado.
 * Extiende la clase Empleado y proporciona una implementación específica 
 * del método `calcularSalario`, adaptada al cálculo de salario para un Gerente.
 * 
 * Un Gerente tiene un salario base que se ve incrementado por un 15% adicional 
 * sobre el salario base, además de bonos y descuentos aplicables.
 * 
 * La clase Gerente hereda todas las propiedades y métodos de la clase Empleado, 
 * pero proporciona una implementación propia para el cálculo del salario mensual.
 */
public class Gerente extends Empleado {
    
    /**
     * Constructor de la clase Gerente.
     * 
     * Este constructor llama al constructor de la clase padre Empleado para 
     * inicializar los atributos básicos del Gerente.
     * 
     * @param nombre El nombre del Gerente.
     * @param cedula La cédula de identidad del Gerente.
     * @param usuario El nombre de usuario para el inicio de sesión del Gerente.
     * @param clave La clave de acceso del Gerente.
     * @param puesto El tipo de puesto (que debe ser Gerente).
     */
    public Gerente(String nombre, String cedula, String usuario, String clave, tipoEmpleado puesto) {
        super(nombre, cedula, usuario, clave, puesto);
    }

    /**
     * Método para calcular el salario mensual del Gerente.
     * 
     * El salario del Gerente se calcula como:
     *  - Salario base.
     *  - Un incremento del 15% sobre el salario base.
     *  - Bonos adicionales (según se ingresen).
     *  - Descuentos aplicables (según se ingresen).
     * 
     * @param horasTrabajadas El número de horas trabajadas durante el mes.
     * @param bonos El monto de los bonos adicionales al salario base.
     * @param descuentos El monto de los descuentos que se deben aplicar.
     * @return El salario mensual calculado del Gerente.
     */
    @Override
    public double calcularSalario(double horasTrabajadas, double bonos, double descuentos) {
        // El salario base + 15% sobre el salario base + bonos - descuentos
        return getSalarioBase() + (getSalarioBase() * 0.15) + bonos - descuentos;
    }
}
