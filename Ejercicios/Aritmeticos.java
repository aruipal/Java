package Ejercicios;
// Declara dos variables int y usa operadores aritméticos para mostrar sus resultados.

import java.util.Scanner;

public class Aritmeticos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Introduzca otro número: ");
        int num2 = scanner.nextInt();

        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        int division = num1 / num2;

        System.out.println("- Suma: " + suma);
        System.out.println("- Resta: " + resta);
        System.out.println("- Multiplicación: " + multiplicacion);
        System.out.println("- División: " + division);

        scanner.close();

    }
   
}
