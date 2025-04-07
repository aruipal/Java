package Ejercicios;
// Escribe un bucle while que imprima los números pares entre 2 y 20.

public class While2al20 {
    public static void main(String[] args) {
        int contador = 2;

        while (contador <= 20) {
            if (contador % 2 == 0) {
                System.out.println("Numero: " + contador);}
            contador ++;        
            
        }
    }
    
}
