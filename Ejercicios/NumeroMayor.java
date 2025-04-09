package Ejercicios;
// Crea un método que reciba dos números y devuelva el mayor
public class NumeroMayor {
    public static int mayor(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else if (num2 > num1) {
            return num2; 
        } else {  
            System.out.println("Los números son iguales.");
            return num1; 
        }
    }
    public static void main(String[] args) {
        int numero1 = 5;
        int numero2 = 7;
        
        System.out.println("El número mayor es el: " + mayor(numero1, numero2));
    }
}
