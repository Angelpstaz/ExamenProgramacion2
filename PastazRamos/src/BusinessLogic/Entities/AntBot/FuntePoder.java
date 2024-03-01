package BusinessLogic.Entities.AntBot;

public class FuntePoder {
    public static int nivelEnergia= 100; 
    public static void restarEnergia(int cantidad){
        nivelEnergia-=cantidad;
    }
}
