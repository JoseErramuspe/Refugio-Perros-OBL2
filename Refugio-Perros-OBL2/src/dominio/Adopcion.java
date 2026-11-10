package dominio;

public class Adopcion {
    private Animal animal;
    private Familia familia;
    private String comentarios;

    public Adopcion(Animal animal, Familia familia, String comentarios) {
        this.animal = animal;
        this.familia = familia;
        this.comentarios = comentarios;
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

    @Override
    public String toString() {
        return this.animal + " - " + this.familia;
    }
    
}
