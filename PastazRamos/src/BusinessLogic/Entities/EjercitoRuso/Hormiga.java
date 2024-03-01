package BusinessLogic.Entities.EjercitoRuso;

public abstract class Hormiga {
    private int  tipo;
    private String Nombre;
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public Hormiga(int tipo, String Nombre) {
        this.Nombre = Nombre;
        this.tipo = tipo;
    }
}
