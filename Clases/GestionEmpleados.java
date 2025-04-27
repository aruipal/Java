package Clases;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEmpleados {
    private List<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    // Agregar un empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado correctamente.");
    }

    // Listar todos los empleados
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    // Buscar un empleado por nombre
    public Empleado buscarEmpleadoPorNombre(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                return empleado;
            }
        }
        return null;
    }

    // Actualizar el salario de un empleado
    public void actualizarSalario(String nombre, double nuevoSalario) {
        Empleado empleado = buscarEmpleadoPorNombre(nombre);
        if (empleado != null) {
            empleado.setSalario(nuevoSalario);
            System.out.println("Salario actualizado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    // Eliminar un empleado
    public void eliminarEmpleado(String nombre) {
        Empleado empleado = buscarEmpleadoPorNombre(nombre);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        while (true) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar empleado por nombre");
            System.out.println("4. Actualizar salario de un empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Salario del empleado: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Cargo del empleado: ");
                    String cargo = scanner.nextLine();

                    Empleado nuevoEmpleado = new Empleado(nombre, salario, cargo);
                    gestionEmpleados.agregarEmpleado(nuevoEmpleado);
                    break;

                case 2:
                    gestionEmpleados.listarEmpleados();
                    break;

                case 3:
                    System.out.print("Nombre del empleado a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Empleado empleadoBuscado = gestionEmpleados.buscarEmpleadoPorNombre(nombreBuscar);
                    if (empleadoBuscado != null) {
                        System.out.println("Empleado encontrado: " + empleadoBuscado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre del empleado para actualizar salario: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Nuevo salario: ");
                    double nuevoSalario = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    gestionEmpleados.actualizarSalario(nombreActualizar, nuevoSalario);
                    break;

                case 5:
                    System.out.print("Nombre del empleado a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestionEmpleados.eliminarEmpleado(nombreEliminar);
                    break;

                case 6:
                    System.out.println("¡Hasta pronto!");
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }
}

