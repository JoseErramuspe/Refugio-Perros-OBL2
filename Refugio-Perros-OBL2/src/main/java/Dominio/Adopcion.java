package Dominio;

public class Adopcion {
    private Animal animal;
    private Familia familia;

    public Adopcion(Animal animal, Familia familia) {
        this.animal = animal;
        this.familia = familia;
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
}
