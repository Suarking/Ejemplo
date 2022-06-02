package fileorfolderlist;

import java.io.File;

public class FileOrFolderList {

    public static void main(String[] args) {
        
        listFoldersFiles("D:/3D Builder");

    }

    
//MÉTODO PARA RECORRER DIRECTORIOS Y LISTAR DIRECTORIOS O ARCHIVOS
    
    public static void listFoldersFiles(String path) {
//Se crea un objeto file con la ruta del directorio deseado
        File folder = new File(path);
//Se comprueba si la ruta existe
        if (!folder.exists()) {
            System.out.println("La ruta " + folder.getAbsolutePath()
                    + " no existe.");
            return;
        }
//Se comprueba si la ruta facilitada es un directorio
        if (!folder.isDirectory()) {
            System.out.println("La ruta " + folder.getAbsolutePath()
                    + " no es un directorio");
            return;
        }
        System.out.println(folder.getAbsolutePath());
//Se obtiene todo el contenido del directorio
        File[] list1 = folder.listFiles();
//Se recorre el directorio y se muestran primero los archivos
        for (File f : list1) {
            if (f.isFile()) {
                System.out.println("Nombre de archivo: " + f.getName());
            }
        }
//se recorre de nuevo el directorio y se obtienen los subdirectorios
        for (File sub : list1) {
//Si es un directorio se vuelve a llamar al método
            if (sub.isDirectory()) {
                listFoldersFiles(sub.getAbsolutePath());
            }
        }

    }}
