package Ejercicios;
// Escribe un método esPar(int n) que devuelva true si el número es par, false en caso contrario.
public class EsPar {
    public static boolean esPar(int n) {
        boolean par = (n % 2 == 0);
        if (par == true){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(esPar(n));

    }
    
}
