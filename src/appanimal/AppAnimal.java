package appanimal;

import java.util.Scanner;

public class AppAnimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alimento;
        Mamifero a = new Mamifero();
        System.out.println("Qué animal es? ");
        a.nombre = sc.nextLine();
        System.out.println("Indica qué come el " + a.nombre + "[carne, vegetales, ambos]");
        alimento = sc.nextLine();
        a.comer(alimento);
        a.segunAlimento(alimento);
        a.nacer();

    }

}
//CLASE ABSTRACTA ANIMAL
abstract class Animal {
//Atributos
    protected String nombre;

    public Animal() {

    }
//Métodos abstractos
    public abstract void comer(String alimento);

    public abstract void nacer();
}
//CLASE MAMÍFERO, HEREDA DE ANIMAL E IMPLEMENTA LA INTERFAZ ALIMENTABLE
class Mamifero extends Animal implements Alimentable {
//Constructor
    public Mamifero() {

    }
//Parametrizado
    public Mamifero(String nombre, String alimento) {
        this.nombre = nombre;
    }
//Implementación de métodos abstractos con polimorfismo
    @Override
    public void comer(String alimento) {
        System.out.println("El " + this.nombre + " come " + alimento);

    }

    @Override
    public void nacer() {
        System.out.println("Los mamíferos son vivíparos.");
    }

    @Override
    public void segunAlimento(String alimento) {
        String carne = "carne";
        String vegetales = "vegetales";
        String ambos = "ambos";
        if (alimento.equalsIgnoreCase(carne)) {
            System.out.println("Es carnívoro.");

        } else if (alimento.equalsIgnoreCase(vegetales)) {
            System.out.println("Es hervíboro.");
        } else if (alimento.equalsIgnoreCase(ambos)) {
            System.out.println("Es omnívoro.");
        }
    }

}
