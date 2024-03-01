package BusinessLogic.Entities.EjercitoRuso;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import DataAccess.HormigaDAO;
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pdavila0113@gmail.com      BaphomeT-T  |
| dilan.calvache@epn.edu.ec  MSetoo      |
|----------------------------------------|
Autor : BaphomeT-T, MSetoo
Fecha : 29.feb.2k24
*/
import DataAccess.DTO.HormigaDTO;

public class HormigaReina{


    private static String nombre;
    private static HormigaReina instancia;
    public HormigaReina(){

    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        HormigaReina.nombre = nombre;
    }

    public static HormigaReina getInstancia(String nombre) {
        if(instancia == null){
            instancia = new HormigaReina();
            HormigaReina.nombre = nombre;

        }
        return instancia;
    }

    public static void setInstancia(HormigaReina instancia) {
        HormigaReina.instancia = instancia;
    }

    protected HormigaReina(HormigaReina reina){
        if(reina!=null){
            instancia = reina;
        }
    }
    public void prIniciarComer() throws IOException {
        File archivo = new File("archivos/setAlimento.txt");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            int i = 0;
            while (linea != null && i < 40) {
                Larva l = new Larva("hormiga" + i);
                prAlimentarHormiga(l, linea);
                linea = entrada.readLine();
                i++;
            }
            entrada.close();

            // Eliminar líneas que contienen "Herbivoro" del archivo
            eliminarLineasHerbivoras(archivo);

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
}

private void eliminarLineasHerbivoras(File archivo) throws IOException {
    File archivoTemporal = new File("archivos/setAlimentoTemp.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo));
         BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {
            archivo.delete();
            archivoTemporal.renameTo(archivo);
        
            // Actualizar el estado de las larvas a rastreadoras en la base de datos
           // Obtener las larvas desde la base de datos y actualizar su estado a rastreadoras
           HormigaDAO hormigaDAO = new HormigaDAO();
           try {
               List<HormigaDTO> larvas = hormigaDAO.prObtenerLarvas(); // Suponiendo que tienes un método obtenerLarvas en HormigaDAO
               for (HormigaDTO larva : larvas) {
                   if (larva.getEstado().equals("Larva")) {
                       larva.setEstado("Rastreadora");
                       hormigaDAO.update(larva);
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
        String linea;
        while ((linea = reader.readLine()) != null) {
            // Si la línea no contiene "Herbivoro", se escribe en el archivo temporal
            if (!linea.contains("Herbivoro")) {
                writer.write(linea + System.lineSeparator());
            }
        }
    }

    // Reemplazar el archivo original con el archivo temporal
   
}




    public void prAlimentarHormiga(Larva larva, String comida){
        HormigaDTO s = new HormigaDTO(larva.getTipo(), larva.getNombre());
        HormigaDAO d = new HormigaDAO();
        try {
            d.create(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (comida.equals("Herbivoro")){
            s.setIdHormiga(4);
            
            try {
                d.create(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
            // Actualizar el campo idHormigaTipo de 4 a 2 para que la larva crezca
            s.setIdHormigaTipo(2); // Cambiar el idHormigaTipo a 2
        
            try {
                d.update(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
            // Si la comida es "Herbivoro", entonces se convierte en una Rastreadora
            if (comida.equals("Herbivoro")) {
                Rastreadora r = new Rastreadora(larva.getNombre());
            } else {
                // Si no es "Herbivoro", se elimina la larva de la base de datos
                try {
                    d.delete(d.getLastidHormiga());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
