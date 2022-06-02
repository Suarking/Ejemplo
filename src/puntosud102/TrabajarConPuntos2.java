package puntosud102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabajarConPuntos2 {

    public static void main(String[] args) {
        String path = "D:/prueba2/";    //Atributos de rutas
        String name = "puntos2.dat";

        ArrayList<Punto> ptList = new ArrayList();  //Colección de tipo Punto

        Punto pt1 = new Punto(1, 2, "naranja"); //Creando Puntos
        Punto pt2 = new Punto(5, 2, "gris");
        Punto pt3 = new Punto(2, 1, "negro");

        ptList.add(pt1);    //Añadiendo puntos
        ptList.add(pt2);
        ptList.add(pt3);

//LLAMADAS A MÉTODOS PARA ESCRIBIR EL FICHERO DAT Y ALMACENAR PUNTOS        
        try {   //Bloque try/Catch, Captura de excepciones
            almacenarColPuntosComoObjetos(path, name, ptList);
            
            ArrayList<Punto> result = new ArrayList(obtenerColPuntostComoObjetos(path, name));  //Almacenando el Arraylist devuelto en uno nuevo
            for (int i = 0; i < result.size(); i++) {   //Recorriendo el nuevo Arraylist  
                System.out.println(result.get(i));  //Imprimiendo puntos con el método toString() anulado por la subclase Punto
            }
            
                        
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TrabajarConPuntos2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MÉTODO ALMACENAR PUNTOS COMO OBJETOS EN UN ARCHIVO .DAT
    public static void almacenarColPuntosComoObjetos(String path, String name, ArrayList<Punto> ptList) throws FileNotFoundException, IOException {

        ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(path + name));

        writeFile.writeObject(ptList);

        writeFile.close();

    }
    
    //MÉTODO LEER PUNTOS DESDE TXT
    public static ArrayList<Punto> obtenerColPuntostComoObjetos(String path, String name) throws IOException, ClassNotFoundException {

        ObjectInputStream recoverFile =new ObjectInputStream(new FileInputStream(path+name));
        
        ArrayList<Punto> recover = (ArrayList<Punto>) recoverFile.readObject();  //Dato a devolver
        
        recoverFile.close();
        
        return recover;

        
    }
}
