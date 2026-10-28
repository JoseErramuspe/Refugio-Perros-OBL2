package Dominio;

public class Familia {
    private String cedulaTitular;
    private String apellido;
    private int celular;

    public Familia(String cedulaTitular, String apellido, int celular) {
        this.cedulaTitular = cedulaTitular;
        this.apellido = apellido;
        this.celular = celular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return this.apellido;
    }
}
