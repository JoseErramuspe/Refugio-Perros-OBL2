// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package main;
import dominio.*;
import interfaz.*;

public class RefugioPerrosOBL2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        VentanaMenu ventM = new VentanaMenu(sistema);
        ventM.setVisible(true);
    }
}
