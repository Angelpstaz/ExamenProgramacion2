package BusinessLogic.Entities.EjercitoRuso;

public class Soldado extends Hormiga {
    private int fuerza; 
    private int rapidez; 
    
    public Soldado(String nombre) {
        super(3, nombre);
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getRapidez() {
        return rapidez;
    }

    public void setRapidez(int rapidez) {
        this.rapidez = rapidez;
    }
    
}
