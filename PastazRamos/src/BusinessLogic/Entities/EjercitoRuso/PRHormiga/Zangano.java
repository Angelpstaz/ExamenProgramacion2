package BusinessLogic.Entities.EjercitoRuso.PRHormiga;

public class Zangano extends Hormiga {
    private int fuerza; 
    private int rapidez; 
    //El codigo Unico se lo da al momento de crear a la Hormiga en la clase HKGD en el bucle for es el "1000+i"

    public Zangano(String tipo, int prCodigoUnico) {
        super(3,tipo, prCodigoUnico);
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
