package Ejercicios;
// Escribe un programa que diga si un número es positivo, negativo o cero usando if-else-if.

import java.util.Scanner;

public class PositivoNegativo {
     public static void main(String args[]) {
        int numero;
        Scanner input = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        
        numero = input.nextInt();
        
        if (numero < 0) {
            System.out.println("Numero negativo");}
        else if (numero > 0) {
            System.out.println("Numero positivo");}
        else {
            System.out.println("El numero es cero");
        }

    input.close();
    }
    
}
