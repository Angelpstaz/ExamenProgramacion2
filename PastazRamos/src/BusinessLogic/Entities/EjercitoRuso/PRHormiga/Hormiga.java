package BusinessLogic.Entities.EjercitoRuso.PRHormiga;

public abstract class Hormiga {
    private int  tipo;
    private String Nombre;
    private int CodigoUnico;
    public Hormiga (){
        
    }

    //El codigo Unico se lo da al momento de crear a la Hormiga en la clase HKGD en el bucle for es el "1000+i"

    public int getPRCodigoUnico(){
        return CodigoUnico;
    }

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
    public Hormiga(int tipo, String Nombre, int CodigoUnico) {
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.CodigoUnico= CodigoUnico;
    }
}
