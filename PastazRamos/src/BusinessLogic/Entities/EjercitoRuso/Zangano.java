package BusinessLogic.Entities.EjercitoRuso;

public class Zangano extends Hormiga {
    private int fuerza; 
    private int rapidez; 
    public Zangano(String tipo) {
        super(3,tipo);
        //TODO Auto-generated constructor stub
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
