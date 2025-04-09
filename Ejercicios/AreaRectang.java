package Ejercicios;
// Escribe un método calcularAreaRectangulo(double base, double altura) que devuelva el área.

public class AreaRectang {
    public static double calcularAreaRectangulo(double base, double altura) {
        double area = base * altura;
        return area;
    
   } 
   public static void main(String[] args) {
        double base = 10.5;
        double altura = 15;
        System.out.println("El area del rectangulo es: " + calcularAreaRectangulo(base, altura));
   }
}
