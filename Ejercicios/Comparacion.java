package Ejercicios;
// Utiliza operadores de comparación entre dos valores y muestra el resultado
import java.util.Scanner;

public class Comparacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Introduce otro número: ");
        int num2 = scanner.nextInt();

        System.out.println("Igual == : " + (num1 == num2));
        System.out.println("No es igual != : " + (num1 != num2));
        System.out.println("Mayor que > : " + (num1 > num2));
        System.out.println("Menor que < : " + (num1 < num2));
        System.out.println("Mayor o igual que >= : " + (num1 >= num2));
        System.out.println("Menor o igual que <= : " + (num1 <= num2));

        scanner.close();

    }
    
}
