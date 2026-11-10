package main;
import dominio.*;
import interfaz.*;

public class RefugioPerrosOBL2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        VentanaAltaAnimales vent = new VentanaAltaAnimales(sistema);
        vent.setVisible(true);
    }
}
