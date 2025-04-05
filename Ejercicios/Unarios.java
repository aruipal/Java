package Ejercicios;
// Usa un operador unario para incrementar y luego decrementar una variable.
public class Unarios {
    public static void main(String[] args) {
        int num1 = 5;
        
        System.out.println("Incrementar += : " + (num1 += 1));
        System.out.println("Decrementar -= : " + (num1 -= 1));
    }
    
}
