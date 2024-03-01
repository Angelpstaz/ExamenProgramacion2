package BusinessLogic.Entities;

import BusinessLogic.Entities.EjercitoRuso.Hormiga;

public class IABot {

     private static IABot instance;
     private static String nombre;
 

     private IABot() { }
     protected IABot(IABot iaBot) { 
         if (iaBot != null)
             instance = iaBot;
     }
 
     public static IABot getInstance(String nombre) {
         if (instance == null){
             instance = new IABot();
             instance.setNombre(nombre);
         }
         return instance;
     }
 
     public String getNombre() {
         return nombre;
     }
 
     private void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public void Buscar(Hormiga hormiga, String Comida){
        
     }
     
}
