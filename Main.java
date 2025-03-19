/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package trabajos.trabajoempleados;

import java.util.Scanner;

/**
 *
 * @author hellen
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        int opcion;
        int eleccion;
        String clave;

        while (true) {

            System.out.println("\nMenu de Inicio de Sesion");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");

            // el siguiente try lee la entrada del usuario como texto y se convierte a un numero entero
            // Si el usuario ingresa algo que no es un numero se muestra un mensaje de error
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida, intente de nuevo ");
                continue;
            }

            // en este switch Se llama al metodo iniciarSesion y se guarda el usuario,
            // Si el usuario ingresó credenciales correctas, se verifica si es administrador o se considera como empleado
            switch (opcion) {
                case 1 -> {
                    Usuario usuario = login.iniciarSesion();
                    if (usuario != null) {
                        if (usuario.getRol().equals("ADMIN")) {
                            System.out.println("Bienvenido administrador");

                            System.out.println("Elija una opción: \n1 Ver detalles \n2 Cambiar contraseña");

                            eleccion = Integer.parseInt(scanner.nextLine());

                            switch (eleccion) {
                                case 1 -> {
                                   
                                    System.out.println(login.revisarInformacion(usuario));
                                }
                                case 2 -> {
                                   login.cambiarClave(usuario);
                                }
                            }
                        } else {
                            System.out.println("Bienvenido empleado");
                            System.out.println("Nombre del usuario:" + usuario.getNombre() + "\nRol del usuario: " + usuario.getRol());
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Saliendo del sistema");
                    scanner.close();
                    return;
                }
                default ->
                    System.out.println("Opcion no valida, intente de nuevo.");
            }
        }//While
    }
}//Cierre clase
