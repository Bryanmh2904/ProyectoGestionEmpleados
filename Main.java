
package adminempleados;

/**
 *
 * @author Mario
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static class GestionEmpleados {
    private ArrayList<Empleado> empleados;
    private int nextId;
    private Scanner scanner;

    public static void main(String[] args) {
        GestionEmpleados gestion = new GestionEmpleados();
        gestion.menu();
    }

    public GestionEmpleados() {
        empleados = new ArrayList<>();
        nextId = 1; // Para generar IDs únicos
        scanner = new Scanner(System.in);
    }

    // Método para mostrar y manejar el menú
    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Listar todos los empleados");
            System.out.println("5. Buscar empleado por ID");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    actualizarEmpleado();
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 5:
                    buscarEmpleado();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // Método para agregar un empleado
    private void agregarEmpleado() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Ingrese salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); 

        Empleado nuevo = new Empleado(nextId, nombre, apellido, cargo, salario);
        empleados.add(nuevo);
        System.out.println("Empleado agregado con ID: " + nextId);
        nextId++;
    }

    // Método para eliminar un empleado
    private void eliminarEmpleado() {
        System.out.print("Ingrese ID del empleado a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Empleado aEliminar = null;
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                aEliminar = emp;
                break;
            }
        }

        if (aEliminar != null) {
            empleados.remove(aEliminar);
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    // Método para actualizar un empleado
    private void actualizarEmpleado() {
        System.out.print("Ingrese ID del empleado a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                System.out.print("Nuevo nombre (deje en blanco para no cambiar): ");
                String nombre = scanner.nextLine();
                if (!nombre.isEmpty()) {
                    emp.setNombre(nombre);
                }
                System.out.print("Nuevo apellido (deje en blanco para no cambiar): ");
                String apellido = scanner.nextLine();
                if (!apellido.isEmpty()) {
                    emp.setApellido(apellido);
                }
                System.out.print("Nuevo cargo (deje en blanco para no cambiar): ");
                String cargo = scanner.nextLine();
                if (!cargo.isEmpty()) {
                    emp.setCargo(cargo);
                }
                System.out.print("Nuevo salario (ingrese 0 para no cambiar): ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                if (salario != 0) {
                    emp.setSalario(salario);
                }
                System.out.println("Empleado actualizado.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Método para listar todos los empleados
    private void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : empleados) {
                System.out.println(emp);
            }
        }
    }

    // Método para buscar un empleado por ID
    private void buscarEmpleado() {
        System.out.print("Ingrese ID del empleado a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }
}