package main;
import dominio.*;
import interfaz.*;

public class RefugioPerrosOBL2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Animal ani1 = new Animal("Juan","123","Bueno",12,"Entregado");
        sistema.agregarAnimal(ani1);
        Animal ani2 = new Animal("Maria","124","Mala",121232453,"Entregado");
        sistema.agregarAnimal(ani2);
        Familia fam1 = new Familia("123","Perez","099123456");
        sistema.agregarFamilia(fam1);
        Familia fam2 = new Familia("456","Romero","099789876");
        sistema.agregarFamilia(fam2);
        Adopcion adop1 = new Adopcion(ani1,fam1,"Familia y animal muy contentos",1);
        sistema.agregarAdopcion(adop1);
        Adopcion adop2 = new Adopcion(ani2,fam2,"Familia y animal muy descontentos, no entiendo por qué adoptaron",2);
        sistema.agregarAdopcion(adop2);
        VentanaMenu vent = new VentanaMenu(sistema);
        vent.setVisible(true);
    }
}
