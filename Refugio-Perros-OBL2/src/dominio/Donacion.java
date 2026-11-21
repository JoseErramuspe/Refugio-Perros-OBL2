// José Gabriel Erramuspe Rodríguez - 353422
// Damián Agustín Torres Aramburu - 371643
package dominio;

import java.io.Serializable;

public class Donacion implements Serializable, Comparable<Donacion> {
    private Empresa empresaDonante;
    private int tipoAlimento;
    private int kilos;
    private int codigo;

    public Donacion(Empresa empresaDonante, int tipoAlimento, int kilos, int codigo) {
        this.empresaDonante = empresaDonante;
        this.tipoAlimento = tipoAlimento;
        this.kilos = kilos;
        this.codigo = codigo;
    }

    public Empresa getEmpresaDonante() {
        return empresaDonante;
    }

    public void setEmpresaDonante(Empresa empresaDonante) {
        this.empresaDonante = empresaDonante;
    }

    public int getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(int tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public int getKilos() {
        return kilos;
    }

    public void setKilos(int kilos) {
        this.kilos = kilos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return this.codigo + ". " + this.empresaDonante +" - "+this.tipoAlimento+" ("+this.kilos+"kg)";
    }

    @Override
    public int compareTo(Donacion o) {
        return this.codigo - o.getCodigo();
    }
}
