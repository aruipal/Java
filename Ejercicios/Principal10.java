package Ejercicios;

public class Principal10 {
    
    public static void main(String args[]) { // main
        Libro1 l1 = new Libro1("Harry Potter", "J.K. Rowling", 500); // Creo instancia
        l1.imprimirLibro(); // llamo al método
        System.out.println(l1); // imprimo toString

        Alumno1 a1 = new Alumno1("Antonio", 8);
        a1.haAprobado();

        Circulo1 c1 = new Circulo1(8);
        c1.calculaArea();
    }
}
// Crea una clase Libro con atributos titulo, autor y paginas, y un método que muestre su información.
class Libro1 {
    private String titulo;
    private String autor;
    private int paginas;

    public Libro1(String titulo, String autor, int paginas) { // Constructor
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override // método toString
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
    }
    
    public void imprimirLibro() { // método
        System.out.println("Titulo: "+ titulo + ", Autor: "+ autor + ", Paginas: "+ paginas);
    }
}

// Define una clase Alumno con un constructor que reciba nombre y nota, y un método que indique si ha aprobado.

class Alumno1 {
    String nombre;
    double nota;

    public Alumno1(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public void haAprobado() {
        if (nota >= 5){
            System.out.println("\n- El alumno " + nombre + " ha aprobado.");
        } else {
            System.out.println("\n- El alumno " + nombre + " ha suspendido.");
        }
    }
}
// Escribe una clase Circulo con un atributo radio y un método que calcule el área.

class Circulo1 {
    double radio;

    public Circulo1(double radio) {
        this.radio = radio;
    }

    public void calculaArea() {
        double pi = 3.1416;
        double area;
        area = pi * Math.pow(radio, 2);
        System.out.println("\n- El area del circulo es: " + area);
    }
}

// Crea una clase CuentaBancaria con saldo y métodos depositar y retirar
