package Ejercicios;
// Define un método mostrarTablaDel5() que imprima la tabla de multiplicar del 5.
public class TablaDel5 {

    public static void mostrarTablaDel5(){

        for (int i= 1; i<=10; i++){
            System.out.println("5x"+i+"="+(i*5));
        }
    }
    public static void main(String[] args){
        mostrarTablaDel5();
    }
    
}
