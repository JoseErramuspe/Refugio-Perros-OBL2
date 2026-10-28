package Dominio;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Animal> listaAnimales;
    private ArrayList<Familia> listaFamilias;
    private ArrayList<Empresa> listaEmpresas;
    private ArrayList<Adopcion> listaAdopciones;
    private ArrayList<Donacion> listaDonaciones;
    
    public void registrarAnimal(String nombre, String temperamento, int peso) {
        int ultCod = -1;
        for(Animal animal : this.listaAnimales) {
            ultCod = Math.max(ultCod, animal.getCodigo());
        }
        Animal nuevoAnimal = new Animal(nombre, ultCod+1, temperamento, peso, "No disponible para adoptar");
        this.listaAnimales.add(nuevoAnimal);
    }
    
    public void registrarFamilia(String cedulaTitular, String apellido, int celular) {
        Familia nuevaFamilia = new Familia(cedulaTitular, apellido, celular);
        this.listaFamilias.add(nuevaFamilia);
    }
    
    public void registrarEmpresa(String nombre, int rut, String direccion) {
        Empresa nuevaEmpresa = new Empresa(nombre, rut, direccion);
        this.listaEmpresas.add(nuevaEmpresa);
    }
    
    public void registrarAdopcion(Animal animal, Familia familia) {
        Adopcion nuevaAdopcion = new Adopcion(animal, familia);
        this.listaAdopciones.add(nuevaAdopcion);
    }
    
    public void registrarDonacion(Empresa empresa, int tipoAlimento, int kilos) {
        int ultCod = -1;
        for(Donacion donacion : this.listaDonaciones) {
            ultCod = Math.max(ultCod, donacion.getCodigo());
        }
        Donacion nuevaDonacion = new Donacion(empresa, tipoAlimento, kilos, ultCod+1);
        this.listaDonaciones.add(nuevaDonacion);
    }
    
    public void anularAdopcion(Adopcion adopcion) {
        this.listaAdopciones.remove(adopcion);
    }

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public void setListaAnimales(ArrayList<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    public ArrayList<Familia> getListaFamilias() {
        return listaFamilias;
    }

    public void setListaFamilias(ArrayList<Familia> listaFamilias) {
        this.listaFamilias = listaFamilias;
    }

    public ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public ArrayList<Adopcion> getListaAdopciones() {
        return listaAdopciones;
    }

    public void setListaAdopciones(ArrayList<Adopcion> listaAdopciones) {
        this.listaAdopciones = listaAdopciones;
    }

    public ArrayList<Donacion> getListaDonaciones() {
        return listaDonaciones;
    }

    public void setListaDonaciones(ArrayList<Donacion> listaDonaciones) {
        this.listaDonaciones = listaDonaciones;
    }
}
