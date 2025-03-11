package proyecto_empleados;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        while (true) {

            int opcion;
            
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
                        } else {
                            System.out.println("Bienvenido empleado");
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
        }
    }
}
