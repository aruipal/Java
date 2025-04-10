package Ejercicios;

class MiCoche {
String marca; // atributos
String modelo;
int velocidad;

    public MiCoche(String marca, String modelo, int velocidad) { // constructor
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    public static void main(String args[]) {
        MiCoche coche1 = new MiCoche("Ford", "Fiesta", 160); // instanciar clase
       
        coche1.mostrarInfo();

        MiCoche coche2 = new MiCoche("Fiat", "Panda", 100);
        
        coche2.mostrarInfo();
}
    public void mostrarInfo() { // método
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad: " + velocidad);
    }
}