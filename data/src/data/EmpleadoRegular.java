package data;

/**
 * Clase que representa a un Empleado Regular, que es un tipo especializado de Empleado.
 * Extiende la clase Empleado y proporciona una implementación específica 
 * del método `calcularSalario`, adaptada al cálculo de salario para un Empleado Regular.
 * 
 * Un Empleado Regular tiene un salario que se calcula como un pago por hora trabajado,
 * más bonos adicionales y descuentos aplicables.
 * 
 * La clase EmpleadoRegular hereda todas las propiedades y métodos de la clase Empleado,
 * pero proporciona una implementación propia para el cálculo del salario mensual.
 */
public class EmpleadoRegular extends Empleado {
    
    /**
     * Constructor de la clase EmpleadoRegular.
     * 
     * Este constructor llama al constructor de la clase padre Empleado para 
     * inicializar los atributos básicos del Empleado Regular.
     * 
     * @param nombre El nombre del Empleado Regular.
     * @param cedula La cédula de identidad del Empleado Regular.
     * @param usuario El nombre de usuario para el inicio de sesión del Empleado Regular.
     * @param clave La clave de acceso del Empleado Regular.
     * @param puesto El tipo de puesto (que debe ser EMPLEADO).
     */
    public EmpleadoRegular(String nombre, String cedula, String usuario, String clave, tipoEmpleado puesto) {
        super(nombre, cedula, usuario, clave, puesto);
    }

    /**
     * Método para calcular el salario mensual del Empleado Regular.
     * 
     * El salario del Empleado Regular se calcula multiplicando el salario base
     * por las horas trabajadas en el mes, y luego sumando los bonos y restando los descuentos.
     * 
     * @param horasTrabajadas El número de horas trabajadas durante el mes.
     * @param bonos El monto de los bonos adicionales al salario base.
     * @param descuentos El monto de los descuentos que se deben aplicar.
     * @return El salario mensual calculado del Empleado Regular.
     */
    @Override
    public double calcularSalario(double horasTrabajadas, double bonos, double descuentos) {
        // El salario base por hora trabajado + bonos - descuentos
        return (getSalarioBase() * horasTrabajadas) + bonos - descuentos;
    }
}
