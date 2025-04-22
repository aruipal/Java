package Ejercicios;
// Crea una clase base llamada Animal con un método hacerSonido(). 
// Luego crea dos clases derivadas: Perro y Gato, que sobrescriban ese método con los sonidos correspondientes. 
// Crea instancias de cada clase y llama al método para demostrar el polimorfismo.

class HerenciaAnimal {
    public void hacerSonido(){
        System.out.println("Este animal hace un sonido.");
    }
}

class Perro extends HerenciaAnimal{
    @Override
    public void hacerSonido(){
        System.out.println("Guau");
    }
}

class Gato extends HerenciaAnimal{
    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }
}

public class EjercicioHerencia{
    public static void main(String[] args){
        HerenciaAnimal[] animales = {new Perro(), new Gato(), new HerenciaAnimal()}; // array
        for (HerenciaAnimal a : animales){
            a.hacerSonido();
        }
    }
}