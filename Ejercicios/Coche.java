package Ejercicios;

public class Coche {
    String marca;  // atributos
    String modelo;
    int velocidad;

    public void mostrarInfo() { // metodo
        System.out.println("Marca: " + marca); 
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad: " + velocidad);
    }
    
}

Coche miCoche = new Coche();
miCoche.marca = "Toyota";
miCoche.modelo = "Corolla";
miCoche.velocidad = 120;
miCoche.mostrarInfo();