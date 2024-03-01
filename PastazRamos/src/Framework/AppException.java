package Framework;

public class AppException extends Exception {

    public AppException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR EN AntBot para el LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "NO sea sapo..";
    }    
}
