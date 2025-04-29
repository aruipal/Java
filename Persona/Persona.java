package Persona;

public class Persona {
    // Atributos
    private String nombre;
    private String apellidos;
    private int anioNacimiento;

    // Constructor
    public Persona(String nombre, int anioNacimiento, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anioNacimiento = anioNacimiento;
    }

    // Método para calcular la edad
    public int calcularEdad(int anioActual) {
        return anioActual - anioNacimiento;
    }

    // Método para mostrar información
    public void mostrarInformacion(int anioActual) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Edad: " + calcularEdad(anioActual));
    }
}
    
