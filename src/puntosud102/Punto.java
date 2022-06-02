
package puntosud102;

import java.io.Serializable;

public class Punto implements Serializable {

    private int coordX;
    private int coordY;
    private double distOrigen;
    private String color;

    public Punto(int cx, int cy, String colorp) {
        coordX = cx;
        coordY = cy;
        distOrigen = Math.sqrt(cx * cx + cy * cy);
        color = colorp;
    }

    public int obtenerCoordX() {
        return coordX;
    }

    public int obtenerCoordY() {
        return coordY;
    }

    public double obtenerDistOrigen() {
        return distOrigen;
    }

    public String obtenerColor() {
        return color;
    }

    @Override
    public String toString() {
        String resul = "";
        resul += "(" + coordX + "," + coordY + ") Dist: " + distOrigen + " Color: " + color;
        return resul;
    }
}
