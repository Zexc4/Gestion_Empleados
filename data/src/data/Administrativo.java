package data;

/**
 * Clase que representa un empleado del tipo Administrativo.
 * Hereda de la clase {@link Empleado}.
 * Esta clase define el comportamiento específico de un empleado Administrativo en cuanto al cálculo de su salario.
 */
public class Administrativo extends Empleado {

    /**
     * Constructor de la clase Administrativo.
     * Inicializa un empleado Administrativo con los parámetros proporcionados.
     *
     * @param nombre   El nombre del empleado.
     * @param cedula   La cédula de identidad del empleado.
     * @param usuario  El nombre de usuario para el empleado.
     * @param clave    La contraseña asociada al usuario del empleado.
     * @param puesto   El puesto o tipo de empleado, que debe ser de tipo {@link tipoEmpleado}.
     */
    public Administrativo(String nombre, String cedula, String usuario, String clave, tipoEmpleado puesto) {
        super(nombre, cedula, usuario, clave, puesto);
    }

    /**
     * Calcula el salario de un empleado Administrativo. 
     * El salario se calcula sumando el salario base con los bonos y restando los descuentos.
     * El salario base es el valor definido en la clase {@link Empleado}.
     *
     * @param horasTrabajadas La cantidad de horas trabajadas por el empleado (no se utiliza en este caso, ya que es un salario fijo).
     * @param bonos Los bonos adicionales que recibe el empleado.
     * @param descuentos Los descuentos aplicados al salario.
     * @return El salario neto calculado para el empleado Administrativo.
     */
    @Override
    public double calcularSalario(double horasTrabajadas, double bonos, double descuentos) {
        return  getSalarioBase() + bonos - descuentos; 
        // Salario fijo + bonos - descuentos
    }
}
