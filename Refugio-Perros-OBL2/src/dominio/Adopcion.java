// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package dominio;

import java.io.Serializable;

public class Adopcion implements Serializable {
    private Animal animal;
    private Familia familia;
    private String comentarios;
    private int numero;

    public Adopcion(Animal animal, Familia familia, String comentarios, int numero) {
        this.animal = animal;
        this.familia = familia;
        this.comentarios = comentarios;
        this.numero = numero;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return this.animal + " - " + this.familia;
    }
    
}
