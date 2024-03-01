package BusinessLogic.Entities.EjercitoRuso;

public class Rastreadora extends Hormiga {
    private int fuerza;
    private int rapidez;
    public Rastreadora(String tipo) {
        super(2, tipo);
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
