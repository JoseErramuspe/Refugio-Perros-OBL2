package dominio;

public class Animal {
    private String nombre;
    private String codigo;
    private String temperamento;
    private int peso;
    private String estado;

    public Animal(String nombre, String codigo, String temperamento, int peso, String estado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.temperamento = temperamento;
        this.peso = peso;
        this.estado = estado;
    }
    
    public void cambiarEstado() {
        if (this.estado.equals("No disponible para adoptar")) {
            this.estado = "Disponible para adoptar";
        } else {
            this.estado = "No disponible para adoptar";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.nombre+" ("+this.codigo+")";
    }
}
