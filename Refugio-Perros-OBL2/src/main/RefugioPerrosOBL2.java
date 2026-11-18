package main;
import dominio.*;
import interfaz.*;

public class RefugioPerrosOBL2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.agregarAnimal(new Animal("Juan","123","Bueno",12,"Disponible para adoptar"));
        sistema.agregarAnimal(new Animal("Maria","124","Mala",121232453,"No disponible para adoptar"));
        VentanaMenu ventM = new VentanaMenu(sistema);
        ventM.setVisible(true);
    }
}
