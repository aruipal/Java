package Ejercicios;
// Crea un bucle do-while que imprima un menú hasta que el usuario elija salir.

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        int numero;
        Scanner input = new Scanner(System.in);

        do {
        System.out.print("Introduzca un numero o -1 para salir: ");
        numero = input.nextInt();

        
        } while (numero != -1);
        System.out.println("Has salido. Adios.");

        input.close();
    }
    
    
}
