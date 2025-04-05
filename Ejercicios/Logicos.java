package Ejercicios;
// Declara un booleano y usa operadores lógicos con una condición.
public class Logicos {
        public static void main(String[] args) {
            boolean cond1 = ( 5 > 3); 
            boolean cond2 = (10 < 20);
            // se utilizan para determinar la lógica entre variables o valores
            System.out.println("- Lógico and &&: " + (cond1 && cond2)); // devuelve true si los dos son verdaderos
            System.out.println("- Lógico or ||: " + (cond1 || cond2)); // devuelve true si uno es verdadero
            System.out.println("- Lógico not !: " + !(cond1 && cond2)); // devuelve false si el resultado es true

        }   
}
