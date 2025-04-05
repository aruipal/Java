package Ejercicios;

import java.util.Scanner;

public class AreaRectangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para introducir los datos

        System.out.print("Introduzca la base: ");
        double base = scanner.nextDouble();

        System.out.print("Introduzca la altura: ");
        double altura = scanner.nextDouble();

        double area = base * altura; // Se calcula el area
        // Imprime el resultado
        System.out.println("El area del rectangulo es: " + area);

        scanner.close(); // Cerramos el scanner
    }  
}
