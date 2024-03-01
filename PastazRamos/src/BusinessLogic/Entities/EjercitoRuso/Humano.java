package BusinessLogic.Entities.EjercitoRuso;

public abstract class Humano {
    private String nombre;

    public Humano(String nombre) {
        this.nombre= nombre; 
    }
    public String getNombre(){
        return nombre;
    }
}
