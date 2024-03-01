package BusinessLogic.Entities;

import java.io.*;
public class ManejoArchivos {
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File("files/" + nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null) {
              System.out.println(linea);
              linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
     public static void eliminarArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        archivo.delete();
    }
}
