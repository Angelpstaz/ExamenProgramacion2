package BusinessLogic.Entities.EjercitoRuso.PRHormiga;

public class Larva extends Hormiga{
    //El codigo Unico se lo da al momento de crear a la Hormiga en la clase HKGD en el bucle for es el "1000+i"

    public Larva(int tipoHormiga, String Nombre, int CodigoUnico) {
        super(4, Nombre, CodigoUnico);
    }
    public Larva(){
    }
    
}
