package puntosud10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabajarConPuntos1 {

    public static void main(String[] args) {


        
            
            String path = "D:/prueba/";  //Atributos de rutas
            String name = "puntos1.txt";

            ArrayList<Punto> ptList = new ArrayList(); //Colección de tipo Punto

            Punto pt1 = new Punto(1, 2, "rojo");      //Creando Puntos
            Punto pt2 = new Punto(3, 7, "verde");
            Punto pt3 = new Punto(4, 1, "azul");

            ptList.add(pt1);    //Añadiendo puntos
            ptList.add(pt2);
            ptList.add(pt3);

//LLAMADAS A LOS MÉTODOS
        try {   //Bloque try/Catch, Captura de excepciones
            almacenarColPuntosEnArchivo(path, name, ptList);

            ArrayList<Punto> result = new ArrayList(obtenerColPuntostDeArchivo(path, name)); //Almacenando el Arraylist devuelto en uno nuevo
            
            for (int i = 0; i < result.size(); i++) {   //Recorriendo el nuevo Arraylist                                       
                System.out.println(result.get(i));  //Imprimiendo puntos con el método toString() anulado por la subclase Punto
            }
            

        } catch (IOException ex) {  //IOException capturada
            Logger.getLogger(TrabajarConPuntos1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//MÉTODO ALMACENAR PUNTOS EN TXT
    public static void almacenarColPuntosEnArchivo(String path, String name, ArrayList<Punto> ptList) throws IOException {
        File ptFile = new File(path + name);
        FileWriter fw = new FileWriter(ptFile);

        for (int i = 0; i < ptList.size(); i++) {   //Leyendo el array y escribiendo los puntos con sus separadores
            fw.write(ptList.get(i).obtenerCoordX() + "#");
            fw.write(ptList.get(i).obtenerCoordY() + "#");
            fw.write(ptList.get(i).obtenerColor() + "\n");
        }
        fw.close();

    }

//MÉTODO LEER PUNTOS DESDE TXT
    public static ArrayList<Punto> obtenerColPuntostDeArchivo(String path, String name) throws IOException {

        ArrayList<Punto> myList = new ArrayList();  //Dato a devolver

        File ptFile = new File(path + name);
        BufferedReader ptBuff = new BufferedReader(new FileReader(ptFile));

        String[] datosLeidos;

        String linea = ptBuff.readLine();  //Leemos una línea
        datosLeidos = linea.split("#");   //Separamos los tres datos de la línea en diversas Strings
        Punto p1 = new Punto(Integer.parseInt(datosLeidos[0]), (Integer.parseInt(datosLeidos[1])), (datosLeidos[2]));//Creamos UN nuevo punto con los datos de esta línea
        myList.add(p1);  //Añadimos el punto a la colección
        String linea2 = ptBuff.readLine();
        datosLeidos = linea2.split("#");
        Punto p2 = new Punto(Integer.parseInt(datosLeidos[0]), (Integer.parseInt(datosLeidos[1])), (datosLeidos[2]));
        myList.add(p2);
        String linea3 = ptBuff.readLine();
        datosLeidos = linea3.split("#");
        Punto p3 = new Punto(Integer.parseInt(datosLeidos[0]), (Integer.parseInt(datosLeidos[1])), (datosLeidos[2]));
        myList.add(p3);

        ptBuff.close();

        return myList;

    }

}
