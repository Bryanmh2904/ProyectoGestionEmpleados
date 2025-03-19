/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajos.trabajoempleados;

import java.util.ArrayList;
import java.util.Scanner;
import trabajos.trabajoempleados.Usuario;

/**
 *
 * @author hellen
 */
public class Login {

    private ArrayList<Usuario> usuarios;
    private Scanner scanner;

    public Login() {
        usuarios = new ArrayList<>();
        scanner = new Scanner(System.in);
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        usuarios.add(new Usuario("admin", "admin123", "ADMIN"));
        usuarios.add(new Usuario("empleado1", "empleado123", "EMPLEADO"));
        usuarios.add(new Usuario("empleado2", "clave456", "EMPLEADO"));
    }

    public Usuario iniciarSesion() {

        int intentos = 3;

        while (intentos > 0) {
            System.out.print("\nIngrese su usuario: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();

            // esta orden valida si el usuario y contraseña son correctos
            Usuario usuarioEncontrado = validarCredenciales(nombre, contraseña);

            // este if verifica si se encontro un usuario con esas credenciales,y devulve al usuario encontrado, y si no se reduce el numero de intentos
            if (usuarioEncontrado != null) {
                System.out.println("\nInicio de sesion exitoso");
                return usuarioEncontrado;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas, intentos restantes: " + intentos);
            }
        }

        System.out.println("\nDemasiados intentos fallidos, sistema bloqueado");
        return null;
    }

    private Usuario validarCredenciales(String nombre, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public String revisarInformacion(Usuario usuario) {
        System.out.println("Detalles:");
        return "Nombre del usuario:" + usuario.getNombre() + "\nRol del usuario: " + usuario.getRol();
    }

    public void cambiarClave(Usuario usuario) {
        System.out.println("\nIngrese su contraseña actual:");
        String contraseñaActual = scanner.nextLine();

        if (!usuario.getContraseña().equals(contraseñaActual)) {
            System.out.println("La contraseña actual no es correcta.");
            return;
        }

        System.out.println("Ingrese su nueva contraseña:");
        String nuevaContraseña = scanner.nextLine();

        usuario.setContraseña(nuevaContraseña);
        System.out.println("Contraseña cambiada exitosamente");
    }

}
