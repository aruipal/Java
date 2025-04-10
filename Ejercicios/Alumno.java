package Ejercicios;
// Define una clase Alumno con un constructor que reciba nombre y nota, y un método que indique si ha aprobado.
public class Alumno {
    String nombre;
    float nota;

    public Alumno(String nombre, float nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
    public void mostrarNota() {
        if (nota >= 5) {
            System.out.println("Aprobado.");
        } else {
            System.out.println("Suspenso.");
        }
    }
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Antonio", 8.5f);

        alumno1.mostrarNota();  
    }
}
