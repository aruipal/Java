package Coche;

public class Main {
    public static void main(String[] args) {
        // Crear un coche
        Coche miCoche = new Coche("Toyota", "Corolla");

        // Mostrar información inicial
        miCoche.mostrarInformacion();

        // Acelerar y frenar
        miCoche.acelerar(50);
        miCoche.acelerar(30);
        miCoche.frenar(60);
        miCoche.frenar(30);

        // Mostrar información final
        miCoche.mostrarInformacion();
    }
}