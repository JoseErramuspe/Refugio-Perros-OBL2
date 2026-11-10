package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Animal> listaAnimales;
    private ArrayList<Familia> listaFamilias;
    private ArrayList<Empresa> listaEmpresas;
    private ArrayList<Adopcion> listaAdopciones;
    private ArrayList<Donacion> listaDonaciones;

    public Sistema() {
        this.listaAnimales = new ArrayList<>();
        this.listaFamilias = new ArrayList<>();
        this.listaEmpresas = new ArrayList<>();
        this.listaAdopciones = new ArrayList<>();
        this.listaDonaciones = new ArrayList<>();
    }

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public void agregarAnimal(Animal animal) {
        this.listaAnimales.add(animal);
    }

    public ArrayList<Familia> getListaFamilias() {
        return listaFamilias;
    }

    public void agregarFamilia(Familia familia) {
        this.listaFamilias.add(familia);
    }

    public ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void agregarEmpresa(Empresa empresa) {
        this.listaEmpresas.add(empresa);
    }

    public ArrayList<Adopcion> getListaAdopciones() {
        return listaAdopciones;
    }

    public void agregarAdopcion(Adopcion adopcion) {
        this.listaAdopciones.add(adopcion);
    }

    
    public ArrayList<Donacion> getListaDonaciones() {
        return listaDonaciones;
    }

    public void agregarDonacion(Donacion donacion) {
        this.listaDonaciones.add(donacion);
    }
    
    public void anularAdopcion(Adopcion adopcion) {
        adopcion.getAnimal().cambiarEstado();
        this.listaAdopciones.remove(adopcion);
    }
}
