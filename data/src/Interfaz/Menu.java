package Interfaz;

import java.util.Scanner;

import data.Administrativo;
import data.Empleado;
import data.Empleado.tipoEmpleado;
import data.EmpleadoRegular;
import data.Gerente;
import data.GestorEmpleado;

/**
 * Clase que representa el menú de interacción con el sistema de gestión de empleados.
 * Esta clase permite a los usuarios ingresar al sistema (log in), registrar nuevos empleados,
 * gestionar sus salarios, consultar reportes, y manejar la interacción a través de diversos menús.
 */
public class Menu {
    
    // Atributos para manejar la entrada de datos y gestionar empleados
    private Scanner sc;  // Objeto Scanner para la entrada de datos desde consola
    private GestorEmpleado gestor;  // Objeto que gestiona a los empleados del sistema

    /**
     * Constructor de la clase Menu.
     * Inicializa el objeto Scanner para la entrada de datos y el GestorEmpleado para gestionar empleados.
     */
    public Menu() {
        sc = new Scanner(System.in);
        gestor = new GestorEmpleado();
    }

    /**
     * Método para mostrar el menú de salarios y gestionar las opciones del menú.
     * Permite realizar cálculos y obtener información relacionada con el salario del empleado.
     * 
     * @param empleado El objeto Empleado cuyo salario se va a gestionar.
     */
    private void mostrarMenuSalarios(Empleado empleado) {
        // Solicitar los datos necesarios
        System.out.print("\n>>Ingrese las horas trabajadas: ");
        double horas = sc.nextDouble();
        System.out.print(">>Ingrese los bonos: ");
        double bonos = sc.nextDouble();
        System.out.print(">>Ingrese los descuentos: ");
        double descuentos = sc.nextDouble();
        System.out.print(">>Ingrese los meses trabajados: ");
        int meses = sc.nextInt();
        System.out.print(">>Ingrese las horas extras trabajadas: ");
        double horasExtras = sc.nextDouble();

        // Opciones del menú de salario
        String[] opciones = { "Calcular Sueldo Mensual", 
                            "Calcular Décimo Tercer Sueldo", 
                            "Calcular Utilidades",
                            "Calcular Horas Extras",
                            "Calcular Fondos de Reserva",
                            "Imprimir Rol de Pagos Personal", 
                            "Salir" };

        int opcion;
        do {
            opcion = print("\nMenú Salarios", opciones);
            switch (opcion) {
                case 1:
                    // Calcular salario mensual
                    double salario = empleado.calcularSalario(horas, bonos, descuentos);
                    System.out.printf("Salario mensual: $%.2f\n", salario);
                    break;

                case 2:
                    // Calcular décimo tercer sueldo
                    double decimoTercer = empleado.calcularDecimoTercerSueldo();
                    System.out.printf("Décimo tercer sueldo: $%.2f\n", decimoTercer);
                    break;

                case 3:
                    // Calcular utilidades
                    double utilidades = empleado.calcularUtilidades(meses);
                    System.out.printf("Utilidades: $%.2f\n", utilidades);
                    break;

                case 4:
                    // Calcular horas extras
                    double pagoHorasExtras = empleado.calcularHorasExtras(horasExtras);
                    System.out.printf("Pago por horas extras: $%.2f\n", pagoHorasExtras);
                    break;

                case 5:
                    // Calcular fondos de reserva
                    double fondosReserva = empleado.calcularFondosReserva();
                    System.out.printf("Fondos de reserva: $%.2f\n", fondosReserva);
                    break;

                case 6:
                    // Imprimir rol de pagos personal
                    System.out.println("\n************************************** ROL DE PAGOS PERSONAL **************************************");
                    System.out.println(empleado.toString());
                    System.out.printf("\n\t*Salario Mensual: $%.2f\n",
                            empleado.calcularSalario(horas, bonos, descuentos));
                    System.out.printf("\t*Décimo Tercer Sueldo: $%.2f\n", empleado.calcularDecimoTercerSueldo());
                    System.out.printf("\t*Utilidades: $%.2f\n", empleado.calcularUtilidades(meses));
                    System.out.printf("\t*Pago por Horas Extras: $%.2f\n", empleado.calcularHorasExtras(horasExtras));
                    System.out.printf("\t*Fondos de Reserva: $%.2f\n", empleado.calcularFondosReserva());
                    System.out.println("****************************************************************************************************");
                    break;

                case 7:
                    // Salir del menú de salarios
                    System.out.println("Saliendo del menú de salarios...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);  // Continúa hasta que se elija la opción "Salir"
    }

    /**
     * Método para realizar el log in en el sistema.
     * Permite a los empleados ingresar su usuario y contraseña, y luego acceder al menú principal.
     * Si los intentos son incorrectos más de 3 veces, el sistema se cierra.
     */
    public void logIn() {
        System.out.println("\nLOG IN");

        int intentos = 0;  // Contador de intentos
        boolean logueado = false;  // Indicador de estado de logueo

        // Intentar hasta 3 veces el log in
        while (intentos < 3 && !logueado) {
            System.out.print(">>Ingrese su usuario: ");
            String usuarioIngresado = this.sc.nextLine();

            System.out.print(">>Ingrese su contraseña: ");
            String claveIngresada = this.sc.nextLine();

            Empleado empEncontrado = gestor.buscar(usuarioIngresado);

            if (empEncontrado != null && empEncontrado.getClave().equals(claveIngresada)) {
                System.out.println("\nBIENVENIDO " + empEncontrado.getNombre().toUpperCase());
                mostrarMenuPrincipal(empEncontrado);
                logueado = true;
            } else {
                intentos++;
                if (intentos < 3) {
                    System.out.println("Usuario o contraseña incorrectos. Intentos restantes: " + (3 - intentos));
                } else {
                    System.out.println("Has alcanzado el número máximo de intentos. Saliendo del sistema...");
                    System.exit(0);  // Cerrar el sistema si se alcanzan 3 intentos fallidos
                }
            }
        }
    }

    /**
     * Método para mostrar el menú principal después de que el usuario haya iniciado sesión.
     * Permite generar reportes, acceder al menú de salarios o salir del sistema.
     * 
     * @param empleado El empleado logueado que interactúa con el menú.
     */
    private void mostrarMenuPrincipal(Empleado empleado) {
        String[] opciones = { "Generar Reporte de Rol de Pagos", "Menú Salarios", "Salir" };

        int opcion;
        do {
            opcion = print("\nMenú Principal", opciones);
            switch (opcion) {
                case 1:
                    gestor.generarReporteRolPagos();  // Mostrar reporte de rol de pagos
                    break;

                case 2:
                    mostrarMenuSalarios(empleado);  // Mostrar el menú de salarios
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    menuInicio();  // Salir del sistema
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);  // Continuar hasta que se elija salir
    }

    /**
     * Método para validar entradas no válidas del menú.
     * Asegura que el usuario elija una opción válida.
     * 
     * @param titulo El título del menú.
     * @param arregloOpc Las opciones del menú.
     * @return La opción seleccionada por el usuario.
     */
    public int print(String titulo, String[] arregloOpc) {
        boolean repetir = true;
        int opcion = 0;

        // Validar que la opción seleccionada sea válida
        do {
            try {
                System.out.println(titulo.toUpperCase());

                for (int i = 0; i < arregloOpc.length; i++) {
                    System.out.println(i + 1 + ". " + arregloOpc[i]);
                }
                System.out.print(">>Ingrese el número de la opción: ");
                opcion = this.sc.nextInt();
                sc.nextLine();

                if (opcion > 0 && opcion <= arregloOpc.length) {
                    repetir = false;
                } else {
                    System.out.println("Ingrese un número entre [1-" + arregloOpc.length + "]");
                }
            } catch (Exception e) {
                System.err.println("Se espera opciones numéricas");
                sc.nextLine();
            }
        } while (repetir);
        return opcion;
    }

    /**
     * Método para registrar un nuevo empleado en el sistema.
     * Recibe los datos del nuevo empleado, permite elegir el puesto y lo agrega al gestor.
     */
    public void registrarEmpleado() {
        System.out.println("\nREGISTRO DE NUEVO EMPLEADO");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Clave: ");
        String clave = sc.nextLine();

        // Opciones de puesto para mostrar en el menú
        String[] opcionesPuesto = { "Empleado", "Administrativo", "Gerente" };

        // Mostrar el menú y obtener la opción seleccionada
        int opcionPuesto = print("\nSeleccione el puesto:", opcionesPuesto);

        // Convertir la opción seleccionada a tipoEmpleado
        tipoEmpleado puesto;
        switch (opcionPuesto) {
            case 1:
                puesto = tipoEmpleado.EMPLEADO;
                break;
            case 2:
                puesto = tipoEmpleado.ADMINISTRATIVO;
                break;
            case 3:
                puesto = tipoEmpleado.GERENTE;
                break;
            default:
                System.out.println("Opción no válida. Se asignará como Empleado.");
                puesto = tipoEmpleado.EMPLEADO;
        }

        // Crear el empleado según el puesto seleccionado
        Empleado nuevoEmpleado;
        switch (puesto) {
            case EMPLEADO:
                nuevoEmpleado = new EmpleadoRegular(nombre, cedula, usuario, clave, puesto);
                break;
            case ADMINISTRATIVO:
                nuevoEmpleado = new Administrativo(nombre, cedula, usuario, clave, puesto);
                break;
            case GERENTE:
                nuevoEmpleado = new Gerente(nombre, cedula, usuario, clave, puesto);
                break;
            default:
                nuevoEmpleado = new EmpleadoRegular(nombre, cedula, usuario, clave, puesto);
        }

        // Agregar el empleado al gestor
        gestor.agregarEmpleado(nuevoEmpleado);

        System.out.println("Empleado registrado exitosamente. Redirigiendo al menú de inicio...");
        logIn();
    }

    /**
     * Método para mostrar el menú de inicio (log in o registro de empleado).
     * Permite al usuario acceder al sistema o registrar un nuevo empleado.
     */
    public void menuInicio() {
        String[] opInicio = new String[] { "Ingresar", "Registrar", "Salir" };
        int opcSeleccionada = print("\nMenu de inicio", opInicio);

        switch (opcSeleccionada) {
            case 1:
                logIn();  // Intentar log in
                break;
            case 2:
                registrarEmpleado();  // Registrar un nuevo empleado
                break;
            case 3:
                System.out.println("\nGRACIAS POR UTILIZAR NUESTRO SISTEMA.");
                break;
            default:
                System.out.println("Opción Incorrecta!!!");
                menuInicio();  // Volver a mostrar el menú si la opción es incorrecta
        }
    }
}
