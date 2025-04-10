package Ejercicios;
// Escribe una clase Circulo con un atributo radio y un método que calcule el área.
public class Circulo {
    double radio;
    double pi = 3.1416;
    double resultado;

    public Circulo(double radio){
        this.radio = radio;
    }   
    public void Area(){
        double resultado =  pi * Math.pow(radio, 2);
        System.out.println("El área del circulo es de: " + resultado);

    }
    public static void main(String[] args) {
        
        Circulo circulo1 = new Circulo(8);
        circulo1.Area();
    }
}
