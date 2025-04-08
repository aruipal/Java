package Ejercicios;

public class ClaseSaludo {
    public void imprimirSaludo(){
        System.out.println("Buenos dias.");
    }
    
    public void imprimirAdios(){
        System.out.println("Adios.");
    }

    public void imprimirNombre(String nombre, String apellido){
        System.out.println("Hola " + nombre +" "+ apellido);
    }
    
    public static void main(String[] args) {
        ClaseSaludo saludo = new ClaseSaludo();

        saludo.imprimirSaludo();
        saludo.imprimirNombre("Antonio", "Ruiz");
        saludo.imprimirAdios();
        
    }
    
}
