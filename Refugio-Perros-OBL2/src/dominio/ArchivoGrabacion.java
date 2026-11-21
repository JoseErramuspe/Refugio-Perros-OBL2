// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package dominio;
import java.io.*;
import java.util.*;

public class ArchivoGrabacion {
    private Formatter out;
    
    public ArchivoGrabacion(String nombre){
        try {
            out = new Formatter(nombre);
        }
        catch(FileNotFoundException e){
            System.out.println("Error al crear el archivo");
        }
    }
    public ArchivoGrabacion(String nombre, boolean extender){
        try {
            FileWriter arch = new FileWriter(nombre, extender);
            out = new Formatter(arch);
        }
        catch(IOException e){
            System.out.println("Error al crear el archivo");
        }
    }
    public void grabarLinea(String linea){
        out.format("%s%n", linea);
    }
    public void cerrar(){
        out.close();
    }
}
