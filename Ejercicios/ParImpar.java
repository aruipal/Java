package Ejercicios;
// Crea una estructura if-else que imprima "Es par" si un número es divisible por 2.

import java.util.Scanner;

public class ParImpar {
        public static void main(String args[]) {

        int numero;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        numero = input.nextInt();
        
        if (numero % 2 == 0) {
            System.out.println("Es numero par");}

        else {
            System.out.println("Es impar");
        }
        input.close();
    }   
}
