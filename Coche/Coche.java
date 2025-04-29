package Coche;

public class Coche {
    // Atributos (características del coche)
    private String marca;
    private String modelo;
    private int velocidad;

    // Constructor (crea un coche con marca y modelo)
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;  // por defecto, el coche está parado
    }

    // Método para acelerar
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("El coche ha acelerado a " + velocidad + " km/h");
    }

    // Método para frenar
    public void frenar(int decremento) {
        velocidad -= decremento;
        if (velocidad < 0) {
            velocidad = 0;
        }
        System.out.println("El coche ha frenado a " + velocidad + " km/h");
    }

    // Método para mostrar información
    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad actual: " + velocidad + " km/h");
    }
}