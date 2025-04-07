package Ejercicios;

public class BucleFor {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) { // Bucle for
            System.out.println("Iteracion numero: " + i);
        }
        for (int i = 10; i > 0; i--) { // Bucle decreciente
            System.out.println("Cuenta atras: " + i);
        }

        int[] numeros = {10,20,30,40,50}; // Recorriendo arrays
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento: " + numeros[i]);
        }

        String nombre = "Antonio";
        for (int i = 0; i < nombre.length(); i++) {
            System.out.println("Letra: " + nombre.charAt(i));
        }
    }
    
}
