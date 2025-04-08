package Ejercicios;
//  Declara una variable int y usa un while para restar 1 hasta llegar a 0.
public class RestarElementos {
    public static void main(String[] args) {
        int contador = 10;

        while (contador >= 0) {
            System.out.println("Contador: " + contador);
            contador --;
        }
    }
}
