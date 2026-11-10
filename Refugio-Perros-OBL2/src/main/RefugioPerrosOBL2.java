package main;
import dominio.*;
import interfaz.*;

public class RefugioPerrosOBL2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.agregarAnimal(new Animal("Juan","123","Bueno",12,"Disponible"));
        sistema.agregarAnimal(new Animal("Maria","124","Mala",121232453,"No disponible"));
        VentanaCambioEstado vent = new VentanaCambioEstado(sistema);
        vent.setVisible(true);
    }
}
