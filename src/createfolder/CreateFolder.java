package createfolder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFolder {

    public static void main(String[] args) {

        String defaultPath = "D:/Users/suarpl/Documentos/";    //Ruta por defecto de mi carpeta Documentos       
        String path;
        Scanner sc = new Scanner(System.in);

        System.out.println("PROGRAMA PARA CREAR UN NUEVO DIRECTORIO ");
        System.out.println("     EN LA CARPETA DOCUMENTOS ");
        System.out.println("--------------------------------------- ");
        System.out.println("Introduce el nombre del directorio deseado"); //Pedimos nombre de directorio   

        path = sc.nextLine();

        File defaultPathFile = new File(defaultPath);   //Concatenamos con la ruta por defecto y creamos objeto File, se usará para comprobar
                                                       //que el directorio por defecto facilitado existe
                                                       
        File pathFile = new File(defaultPath + path);  //Concatenamos con la ruta por defecto y creamos objeto File con la ruta completa

        if (defaultPathFile.exists()) {    //Comprobamos si el directorio por defecto existe
            if (!pathFile.exists()) {   //Comprobamos si el directorio que queremos crear no existe. Si no existe, creamos el directorio
                System.out.println("El directorio " + pathFile.getName() + " no existe");

                if (pathFile.mkdir()) {
                    System.out.println("El directorio " + pathFile.getName() + " ha sido creado con éxito");

                }

            } else {    //Si ya existe, no lo creamos
                System.out.println("El directorio " + pathFile.getName() + " ya existe");
            }
        } else { 
            System.out.println("El directorio por defecto facilitado " + defaultPathFile.getAbsolutePath()+ " no existe, ");    //Si no existe (es errónea),
            System.out.println("por favor, corrija la ruta por defecto utilizada.");                                            //avisamos para que se corrija
        }

    }

}
