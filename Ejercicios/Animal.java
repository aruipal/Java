package Ejercicios;

import java.util.Scanner;

// Crea varios objetos de una clase Animal y haz que cada uno tenga un método que imprima su sonido.
public class Animal {
    String perro = "guau";
    String gato = "miau";
    String vaca = "muuuu";
    String cabra = "beeee";

    public void perro() {
        System.out.println("El perro hace: " + perro);
    }
    public void gato() {
        System.out.println("El gato hace: " + gato);
    }
    public void vaca() {
        System.out.println("La vaca hace: " + vaca);
    }
    public void cabra() {
        System.out.println("La cabra hace: " + cabra);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Animal animal1 = new Animal();
                        
        System.out.print("- Sonido de animales:\n1. Perro\n2. Gato\n3. Vaca\n4. Cabra\nOpción: ");
        int opcion = input.nextInt();

        if (opcion == 1) {
            animal1.perro();

        } else if (opcion == 2) {
            animal1.gato();
        } else if (opcion == 3) {
            animal1.vaca();
        } else if (opcion == 4) {
            animal1.cabra();
        } else {
            System.out.println("Opción incorrecta.");
        }
        input.close();        
    }    
   
}
