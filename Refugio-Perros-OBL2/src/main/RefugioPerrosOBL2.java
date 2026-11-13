package main;
import dominio.*;
import interfaz.*;

public class RefugioPerrosOBL2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.agregarAnimal(new Animal("Juan","123","Bueno",12,"Disponible para adoptar"));
        sistema.agregarAnimal(new Animal("Maria","124","Mala",121232453,"No disponible para adoptar"));
        VentanaCambioEstado vent1 = new VentanaCambioEstado(sistema);
        VentanaAltaAnimales vent2 = new VentanaAltaAnimales(sistema);
        VentanaAltaEmpresas vent3 = new VentanaAltaEmpresas(sistema);
        VentanaAltaFamilias vent4 = new VentanaAltaFamilias(sistema);
        vent1.setVisible(true);
        vent2.setVisible(true);
        vent3.setVisible(false);
        vent4.setVisible(false);
    }
}
