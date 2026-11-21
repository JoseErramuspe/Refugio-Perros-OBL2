// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package dominio;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    public ArchivoLectura(String nombre){
        try {
            in = new Scanner(Paths.get(nombre));
        }
        catch(IOException e){
            System.out.println("Error al leer el archivo");
        }
    }
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        if (in.hasNext()){
            hay = true;
            linea = in.nextLine();
        }
        return hay;
    }
    public String linea(){
        return linea;
    }
    public void cerrar(){
        in.close();
    }
}
