package BusinessLogic.Entities.EjercitoRuso.PRHormiga;

public class Rastreadora extends Hormiga {
    private int fuerza;
    private int rapidez;
    //El codigo Unico se lo da al momento de crear a la Hormiga en la clase HKGD en el bucle for es el "1000+i"
    public Rastreadora(String tipo, int CodigoUnico) {
        super(2, tipo, CodigoUnico);
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
