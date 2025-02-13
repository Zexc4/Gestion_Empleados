package main;

import Interfaz.Menu;

public class Main {

    public static void main(String[] args) {
                
        Menu menu = new Menu();  // Crea una instancia del menú
        System.out.println("\n****************** BIENVENIDO SISTEMA DE GESTIÓN DE EMPLEADOS ******************");  // Muestra un mensaje de bienvenida
        
        menu.menuInicio();  // Llama al método menuInicio() de la clase Menu para iniciar el flujo del programa
    }
}
