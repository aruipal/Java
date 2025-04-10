package Ejercicios;
// Crea una clase Libro con atributos titulo, autor y paginas, y un método que muestre su información.
public class Libro {
    String titulo;
    String autor;
    int paginas;

    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }
    public static void main(String args[]) {
        Libro libro1 = new Libro("Java for dummies", "Juan Palomo", 324);
       
        libro1.mostrarInfo();
    }
    public void mostrarInfo() { // método
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + paginas);
    }
    
}
