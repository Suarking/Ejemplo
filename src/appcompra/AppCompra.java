package appcompra;

public class AppCompra {

    public static void main(String[] args) {

//Creación de 3 objetos mediante Upcasting
        Producto p1 = new Leche(10);
        Producto p2 = new Salmon(1.2);
        Producto p3 = new Whisky(3);

        System.out.printf("Leche: %.2f€  ", p1.gastoConIva());
        System.out.printf("Salmón: %.2f€  ", p2.gastoConIva());
        System.out.printf("Whisky: %.2f€  ", p3.gastoConIva());

    }

}
//CLASE ABSTRACTA PRODUCTO

abstract class Producto {
//Atributos

    protected double gasto;

//Constructor
    public Producto() {
    }

//Declaración del método abstracto gastoConIva()
    public abstract double gastoConIva();
}

//CLASE ABSTRACTA LECHE (IMPLEMENTA MÉTODO ABSTRACTO gastoConIva())
class Leche extends Producto {
//Atributos

    private int litros_leche;

//Contructor
    public Leche() {

    }
//Parametrizado

    public Leche(int litros_leche) {
        this.litros_leche = litros_leche;
    }

//Implementación del método abstracto gastoConIva() heredado de la clase Producto
    @Override
    public double gastoConIva() { //Polimorfismo en método gastoConIva
        gasto = (double) litros_leche * 1.95 * 1.04;
        return gasto;
    }
}
//CLASE ABSTRACTA SALMÓN (IMPLEMENTA MÉTODO ABSTRACTO gastoConIva())

class Salmon extends Producto {
//Atributos

    private double kilos_salmon;

//Contructor
    public Salmon() {

    }

//Parametrizado
    public Salmon(double kilos_salmon) {
        this.kilos_salmon = kilos_salmon;
    }

//Implementación del método abstracto gastoConIva() heredado de la clase Producto
    @Override
    public double gastoConIva() {//Polimorfismo en método gastoConIva
        gasto = kilos_salmon * 11.85 * 1.08;
        return gasto;
    }

}
//CLASE ABSTRACTA WHISKY (IMPLEMENTA MÉTODO ABSTRACTO gastoConIva())

class Whisky extends Producto {
//Atributos

    private int litros_whisky;

//Constructor
    public Whisky() {

    }
//Parametrizado

    public Whisky(int litros_whisky) {

        this.litros_whisky = litros_whisky;
    }
//Implementación del método abstracto gastoConIva() heredado de la clase Producto

    @Override
    public double gastoConIva() {//Polimorfismo en método gastoConIva
        gasto = (double) litros_whisky * 11.90 * 1.21;
        return gasto;
    }

}
