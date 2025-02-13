package data;

import data.Empleado.tipoEmpleado;

/**
 * Clase que representa el gestor o administrador de los empleados.
 * Esta clase se encarga de gestionar a los empleados del sistema, permitiendo
 * registrar nuevos empleados, buscar empleados por su nombre de usuario y generar
 * reportes de rol de pagos para todos los empleados registrados.
 * 
 * El gestor almacena a los empleados en un arreglo y proporciona funcionalidades 
 * para manipular esta información de manera eficiente.
 */
public class GestorEmpleado {
    
    // Atributos que representan la lista de empleados y su capacidad máxima
    private Empleado[] empleados;
    private int capacidad;   // Capacidad máxima del arreglo de empleados
    private int cantidad;    // Número actual de empleados registrados
    
    /**
     * Constructor de la clase GestorEmpleado.
     * Este constructor inicializa la capacidad del gestor y crea un arreglo
     * vacío de empleados. Además, registra 3 empleados por defecto: un Administrador,
     * un Empleado Regular y un Gerente.
     */
    public GestorEmpleado() {
        capacidad = 10;            // Capacidad máxima de 10 empleados
        cantidad = 0;              // Inicialmente no hay empleados
        empleados = new Empleado[capacidad];
        
        // Creación de usuarios por defecto
        agregarEmpleado(new Administrativo("Admin", "1700000000", "admin", "1234", tipoEmpleado.ADMINISTRATIVO));
        agregarEmpleado(new EmpleadoRegular("Vendedor", "1700000000", "ventas", "1234", tipoEmpleado.EMPLEADO));
        agregarEmpleado(new Gerente("Gerente", "1700000000", "gerente", "1234", tipoEmpleado.GERENTE));
    }

    /**
     * Método para agregar un nuevo empleado al sistema.
     * Si hay espacio en el arreglo de empleados, el nuevo empleado se agrega al mismo.
     * Si no hay espacio, se muestra un mensaje indicando que no se pueden agregar más empleados.
     * 
     * @param emp El objeto empleado a agregar.
     */
    public void agregarEmpleado(Empleado emp) {
        if (cantidad < capacidad) {
            empleados[cantidad++] = emp;  // Agrega el empleado al arreglo y aumenta el contador
            System.out.println("Empleado registrado exitosamente.");
        } else {
            System.out.println("No se pueden registrar más empleados. Límite alcanzado.");
        }
    }

    /**
     * Método para buscar un empleado por su nombre de usuario.
     * 
     * @param usuario El nombre de usuario del empleado a buscar.
     * @return El objeto `Empleado` correspondiente si se encuentra, o `null` si no existe.
     */
    public Empleado buscar(String usuario) {
        for (int i = 0; i < cantidad; i++) {
            if (empleados[i].getUsuario().equals(usuario)) {
                return empleados[i];
            }
        }
        return null;  // Retorna null si no se encuentra el empleado
    }
    
    /**
     * Método para generar y mostrar un reporte de rol de pagos para todos los empleados registrados.
     * Este reporte muestra el nombre del empleado, cédula, cargo y salario mensual calculado basado
     * en las horas trabajadas (160 horas en este caso), sin bonos ni descuentos.
     */
    public void generarReporteRolPagos() {
        System.out.println("\n************************************** NÓMINA BASE DE EMPLEADOS REGISTRADOS ****************************");
        for (int i = 0; i < cantidad; i++) {
            Empleado emp = empleados[i];
            double salarioMensual = emp.calcularSalario(160, 0, 0);  // Calcula el salario mensual (160 horas trabajadas)
            System.out.printf("Empleado: %s \t| C.I: %s |\t Cargo: %s \t | Salario Mensual: $%.2f\n", 
                              emp.getNombre(), emp.getCedula(), emp.getTipo().name(), salarioMensual);
        }
        System.out.println("********************************************************************************************************");
    }
}
