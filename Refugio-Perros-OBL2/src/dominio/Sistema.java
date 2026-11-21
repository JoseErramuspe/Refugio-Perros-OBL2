package dominio;

import java.io.Serializable;
import java.util.*;

public class Sistema extends Observable implements Serializable {

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
    
    /** 0. Animales total - 1. Animales disponibles - 2. Animales no disponibles - 3. Animales entregados - 4. Adopciones - 5. Empresas - 6. Donaciones t1 - 7. Donaciones t2 - 8. Donaciones t3 - 9. Donaciones t4 */
    public int[] datosRefugio() {
        int[] datos = new int[10];
        datos[0] = this.listaAnimales.size();
        datos[4] = this.listaAdopciones.size();
        datos[5] = this.listaEmpresas.size();
        for (Animal ani : this.listaAnimales) {
            if (ani.getEstado().equals("Disponible para adoptar")) {
                datos[1]++;
            } else if (ani.getEstado().equals("No disponible para adoptar")) {
                datos[2]++;
            } else {
                datos[3]++; // Entregados a familias
            }
        }
        for (Donacion don : this.listaDonaciones) {
            if (don.getTipoAlimento() == 1) {
                datos[6] += don.getKilos();
            } else if (don.getTipoAlimento() == 2) {
                datos[7] += don.getKilos();
            } else if (don.getTipoAlimento() == 3) {
                datos[8] += don.getKilos();
            } else if (don.getTipoAlimento() == 4) {
                datos[9] += don.getKilos();
            }
        }
        return datos;
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
        adopcion.getAnimal().setEstado("No disponible para adoptar");
        this.listaAdopciones.remove(adopcion);
    }
    
    public Empresa getEmpresaPorRut(String rutBuscado) {
        Empresa buscada = null;
        for (Empresa emp : this.listaEmpresas) {
            if (buscada == null && emp.getRut().equals(rutBuscado)) {
                buscada = emp;
            }
        }
        return buscada;
    }
    
    public void notificarObs(){
        setChanged();
        notifyObservers();
    }
}
