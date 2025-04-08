package Ejercicios;
// Usa un for para sumar los elementos de un array de enteros
public class ForSuma {
    public static void main(String[] arg) {

        int[] numeros = {1,5,8,2,10};
        int resultado = 0;

        for (int i = 0; i < numeros.length; i++) {
            resultado = resultado + numeros[i];
            
        }
        System.out.println("Suma: " + resultado);
    
    }
}
