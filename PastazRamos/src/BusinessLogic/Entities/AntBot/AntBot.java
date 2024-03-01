package BusinessLogic.Entities.AntBot;

import BusinessLogic.Entities.IABot;
import BusinessLogic.Entities.EjercitoRuso.IHormigaBody;
import BusinessLogic.Entities.EjercitoRuso.Rastreadora;
import BusinessLogic.Entities.EjercitoRuso.Soldado;
import BusinessLogic.Entities.EjercitoRuso.Zangano;

public class AntBot extends IABot implements IHormigaBody {
    private Alas eAlas; 
    private Antena eAntena; 
    private Camara eCamara; 
    private CircuitoAnillado eCircuitoAnillado;
    private Pata ePata; 
    private FuntePoder eFuntePoder; 
    private Radio eRadio; 
    private SensorOptico eSensorOptico; 
    private Tenaza eTenaza; 

    public AntBot (IABot iaBot){
        super (iaBot);
     eAlas = new Alas(); 
     eAntena = new Antena();
     eCamara = new Camara(); 
     ePata= new Pata(); 
     eFuntePoder= new FuntePoder(); 

    if(AntBot.ala)
        System.out.println("ala");
    if(AntBot.pata)
        System.out.println("pata");
    if(AntBot.cabeza)
        System.out.println("cabeza");
    if(AntBot.tronco)
        System.out.println("tronco");
    }

    public Boolean inicializar(){
        return true;
    }

    public void unirseSoldado(Soldado soldado){
    Pata.Correr();
    Pata.Saltar();
    }
    public void unirseZangano(Zangano zangano){
    Alas.Volar();
    Pata.Correr();
    Pata.Saltar();
    }
    public void unirseRastreadora(Rastreadora rastreadora){
    Pata.Correr();
    Pata.Saltar();
    }
}