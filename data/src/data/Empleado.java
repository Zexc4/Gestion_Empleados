package data;
/**
 * Clase abstracta que representa a un empleado en el sistema.
 * Contiene información general sobre un empleado, como su nombre, cédula,
 * tipo de puesto (Empleado, Administrativo, Gerente) y salario base. 
 * Además, tiene métodos para calcular varios componentes del salario del empleado,
 * como el salario mensual, el décimo tercer sueldo, las utilidades, horas extras,
 * y fondos de reserva.
 * 
 * La clase también tiene un método abstracto `calcularSalario` que deberá ser 
 * implementado por las clases derivadas, como `Administrativo`, `EmpleadoRegular`, etc.
 */
public abstract class Empleado {
    // Atributos encapsulados
    private String nombre;
    private String usuario;
    private String clave;
    private String cedula;
    protected double salarioBase;
    private tipoEmpleado tipo;
    private Salario salario;

    // Enumeración de los tipos de empleado
    public enum tipoEmpleado {
        EMPLEADO, ADMINISTRATIVO, GERENTE
    }

    /**
     * Constructor de la clase Empleado.
     * @param nombre El nombre del empleado.
     * @param cedula La cédula de identidad del empleado.
     * @param usuario El nombre de usuario para el inicio de sesión.
     * @param clave La clave de acceso del empleado.
     * @param tipo El tipo de empleado (Empleado, Administrativo, Gerente).
     */
    public Empleado(String nombre, String cedula, String usuario, String clave, tipoEmpleado tipo) {
        this.nombre = nombre;
        this.setCedula(cedula);
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.salario = new Salario();
        setSalarioBase(tipo); // Establecer salario base según el tipo de empleado
    }

    /**
     * Método privado para establecer el salario base de un empleado 
     * según su tipo (Empleado, Administrativo, Gerente).
     * 
     * @param tipo El tipo de empleado.
     */
    private void setSalarioBase(tipoEmpleado tipo) {
        switch (tipo) {
            case GERENTE:
                this.salarioBase = 700; // Salario base para Gerente
                break;
            case ADMINISTRATIVO:
                this.salarioBase = 450; // Salario base para Administrativo
                break;
            case EMPLEADO:
                this.salarioBase = 300; // Salario base para Empleado Regular
                break;
            default:
                this.salarioBase = 450; // Valor por defecto
        }
    }

    /**
     * Método abstracto para calcular el salario mensual de un empleado.
     * Este método debe ser implementado por las clases derivadas.
     * 
     * @param horasTrabajadas El número de horas trabajadas en el mes.
     * @param bonos El monto de bonos adicionales al salario.
     * @param descuentos El monto de descuentos aplicados al salario.
     * @return El salario mensual calculado.
     */
    public abstract double calcularSalario(double horasTrabajadas, double bonos, double descuentos);

    /**
     * Método para calcular el décimo tercer sueldo basado en el salario base del empleado.
     * 
     * @return El monto del décimo tercer sueldo.
     */
    public double calcularDecimoTercerSueldo() {
        return salario.calcularDecimoTercerSueldo(getSalarioBase());
    }

    /**
     * Método para calcular las utilidades del empleado basadas en el salario base 
     * y los meses trabajados.
     * 
     * @param mesesTrabajados El número de meses trabajados por el empleado.
     * @return El monto de las utilidades.
     */
    public double calcularUtilidades(int mesesTrabajados) {
        return salario.calcularUtilidades(getSalarioBase(), mesesTrabajados);
    }

    /**
     * Método para calcular el pago por horas extras, basado en el salario base 
     * y las horas extras trabajadas.
     * 
     * @param horasExtras El número de horas extras trabajadas.
     * @return El monto de las horas extras.
     */
    public double calcularHorasExtras(double horasExtras) {
        return salario.calcularHorasExtras(getSalarioBase(), horasExtras);
    }

    /**
     * Método para calcular los fondos de reserva del empleado, basado en su salario base.
     * 
     * @return El monto de los fondos de reserva.
     */
    public double calcularFondosReserva() {
        return salario.calcularFondosReserva(getSalarioBase());
    }

    // Métodos Getters y Setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public tipoEmpleado getTipo() {
        return tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * Método para representar al empleado como una cadena de texto.
     * 
     * @return Una cadena con la información del empleado: nombre, cédula, usuario, tipo y salario base.
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s | Cédula: %s |Usuario: %s | Tipo: %s | Salario Base: $%.2f", nombre, cedula, usuario, 
                tipo.name(), getSalarioBase());
    }
}
