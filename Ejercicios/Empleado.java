package Ejercicios;
// Crea una clase Empleado con los atributos nombre y salario, y un método mostrarInfo(). 
// Luego crea una clase Gerente que herede de Empleado y añada el atributo departamento. 
// Utiliza super() para llamar al constructor de la clase base.

class Empleado2 {
    protected String nombre; // protected, se pueden acceder a los atributos si estoy dentro del mismo paquete
    protected double salario;

    public Empleado2(String nombre, double salario){ // constructor
        this.nombre = nombre;
        this.salario = salario;
    }

    public void mostrarInfo(){ // método
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
    }   
}

class Gerente extends Empleado2 {
    private String departamento; // nuevo atributo

    public Gerente(String nombre, double salario, String departamento){
        super(nombre, salario); // llamo al constructor de la clase base.
        this.departamento = departamento;
    }

    @Override // añadir al metodo mostrarInfo el departamento
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Departamento: " + departamento);
    }
}

public class Empleado {
    public static void main(String[] args){
        Gerente juan = new Gerente("Juan", 100, "TCI");
        juan.mostrarInfo();
    }
}