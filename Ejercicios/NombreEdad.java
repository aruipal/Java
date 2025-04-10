package Ejercicios;
//  Crea un método que reciba el nombre y la edad de una persona y devuelva un mensaje personalizado.
public class NombreEdad {
    public static String nombreEdad(String nombre, String edad) {
        return "Tu nombre es " + nombre + " y tienes " + edad + " años.";

    }
    public static void main(String[] args){
        String nombre = "Antonio";
        String edad = "46";
        System.out.println(nombreEdad(nombre, edad));
    }   
}
