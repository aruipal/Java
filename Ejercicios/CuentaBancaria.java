package Ejercicios;
// Crea una clase CuentaBancaria con saldo y métodos depositar y retirar
import java.util.Scanner;

public class CuentaBancaria {
    private float saldo;
    
    public CuentaBancaria(float saldo) {
        this.saldo = saldo;
    }
    public void depositar(float cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
            System.out.println("Su saldo ahora es de: " + saldo + " euros.");
        } else {
            System.out.println("La cantidad tiene que ser positiva.");
        }       
    }
    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo = saldo - cantidad;
            System.out.println("Su saldo ahora es de: " + saldo + " euros.");
        }       
    }
    public void mostrar(){
        System.out.println("Su saldo es de: " + saldo + " euros.");
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        CuentaBancaria cuenta1 = new CuentaBancaria(1000f);
                        
        System.out.print("Cuenta bancaria:\n1. Ingresar\n2. Retirar\n3. Mostrar saldo\nOpción: ");
        int opcion = input.nextInt();  

        if (opcion == 1) {
            System.out.print("Ingrese la cantidad a ingresar: ");
            float cantidad = input.nextFloat();
            cuenta1.depositar(cantidad);
        } else if (opcion == 2) {
            System.out.print("Ingrese la cantidad a retirar: ");
            float cantidad = input.nextFloat();
            cuenta1.retirar(cantidad);
        } else if (opcion == 3) {
            cuenta1.mostrar();
        } else {
            System.out.println("Opción no válida.");
        }
        input.close();        
    }   
}
