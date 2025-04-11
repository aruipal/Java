package Ejercicios;

class Principal {
    public static void main(String[] args) {
        Persona p1 = new Persona("Antonio", "Ruiz", 46, "12345678A");
        p1.imprimir();
    }
}
class Persona{
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;

    public Persona(String nombre, String apellidos, int edad, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
    }

    public void imprimir(){
        System.out.printf(nombre+" "+apellidos+", "+edad+", "+dni);
    }
}
