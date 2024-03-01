package BusinessLogic.Entities.EjercitoRuso.PRHormiga;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.HormigaDAO;
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| angelpstaz@gmail.com       Angelpstaz  |
| dilan.calvache@epn.edu.ec  SebasLS1’s  |
|----------------------------------------|
Autor : Angelpstaz, SebasLS1’s
Fecha : 29.feb.2k24
*/
import DataAccess.DTO.HormigaDTO;

public class HormigaReina{

    private Larva prLarva;

    private static String nombre;
    public HormigaReina(){

    }


    public static String getNombre() {
        return nombre;
    }
     
    public static void setNombre(String nombre) {
        HormigaReina.nombre = nombre;
    }
    //Angel
    // public String getAlimento(int numeroLinea) {
    //     String comidaEncontrada = "";
    //     try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Angel\\Pictures\\AhoraSiVamos\\ExamenProgramacion2\\PastazRamos\\src\\BusinessLogic\\Entities\\archivos\\SetAlimento.txt"))) {
    //         int numeroActual = 1;
    //         String linea;

    //         while ((linea = br.readLine()) != null) {
    //             if (numeroActual == numeroLinea) {
    //                 comidaEncontrada = linea.trim();
    //                 break;  // Terminar el bucle al encontrar la línea deseada
    //             }
    //             numeroActual++;
    //         }

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     if (comidaEncontrada.isEmpty()) {
    //         System.out.println("No se encontró hierba.");
    //     } else {
    //         System.out.println("Se recogió: " + comidaEncontrada);
    //     }

    //     return comidaEncontrada;
    // }

    
    // //Angel
    // public String prAlimentarLarva(Larva prLarva, String alimento){

    //         System.out.println("Se está alimentando a la larva " + prLarva.getNombre());
    //         if (alimento != null && alimento != null && alimento.equals("Herbivoro")) {                
    //             return "Viva";
    //         }
    //         else{
    //             System.out.println("La larva a muerto por comer "+ alimento);
    //             return "Muerta";
    //         }
        
    // }
        
/*
    //larva --> rastreadora

*/
    //Angel

///// test
    public static String getAlimento(int numeroLinea) {
        String comidaEncontrada = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Angel\\Pictures\\AhoraSiVamos\\ExamenProgramacion2\\PastazRamos\\src\\BusinessLogic\\Entities\\archivos\\SetAlimento.txt"))) {
            int numeroActual = 1;
            String linea;
            List<String> lineas = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                if (numeroActual == numeroLinea) {
                    comidaEncontrada = linea.trim();
                } else {
                    lineas.add(linea);
                }
                numeroActual++;
            }

            // Sobrescribir el archivo con las líneas restantes
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Angel\\Pictures\\AhoraSiVamos\\ExamenProgramacion2\\PastazRamos\\src\\BusinessLogic\\Entities\\archivos\\SetAlimento.txt"))) {
                for (String line : lineas) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (comidaEncontrada.isEmpty()) {
            System.out.println("No se encontró hierba.");
        } else {
            System.out.println("Se recogió: " + comidaEncontrada);
        }

        return comidaEncontrada;
    }

    public static void eliminarLineaArchivo(String filePath, int numeroLineaAEliminar) {
        // Puedes implementar este método según la lógica para eliminar la línea del archivo
    }

    public static String prAlimentarLarva(Larva prLarva, String alimento) {
        System.out.println("Se está alimentando a la larva " + prLarva.getNombre());
        if (alimento != null && alimento.equals("Herbivoro")) {
            return "Viva";
        } else {
            System.out.println("La larva ha muerto por comer " + alimento);
            return "Muerta";
        }
    }


    //////
    public void prConvertirRastreador(Larva nombre){
        
    }
    //Angel



//     public void prIniciarComer() throws IOException {
//         File archivo = new File("./PastazRamos/archivos/setAlimento.txt");
//         try {
//             BufferedReader entrada = new BufferedReader(new FileReader(archivo));
//             String linea = entrada.readLine();
//             int i = 0;
//             while ((linea = entrada.readLine()) != null) {
//                 Larva prL = new Larva("hormiga" + i);
//                 prAlimentarHormiga(prL, linea);
//                 prAlimentarLarva(prL, linea);
//                 linea = entrada.readLine();
//                 i++;
//             }
//             entrada.close();

//             // Eliminar líneas que contienen "Herbivoro" del archivo
//             eliminarLineasHerbivoras(archivo);

//         } catch (FileNotFoundException e) {
//             e.printStackTrace(System.out);
//         } catch (IOException e) {
//             e.printStackTrace(System.out);
//         }
// }

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




    // public void prAlimentarHormiga(Larva larva, String comida){
    //     HormigaDTO s = new HormigaDTO(larva.getTipo(), larva.getNombre());
    //     HormigaDAO d = new HormigaDAO();
    //     try {
    //         d.create(s);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     if (comida.equals("Herbivoro")){
    //         s.setIdHormiga(4);
            
    //         try {
    //             d.create(s);
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
        
    //         // Actualizar el campo idHormigaTipo de 4 a 2 para que la larva crezca
    //         s.setIdHormigaTipo(2); // Cambiar el idHormigaTipo a 2
        
    //         try {
    //             d.update(s);
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
        
    //         // Si la comida es "Herbivoro", entonces se convierte en una Rastreadora
    //         if (comida.equals("Herbivoro")) {
    //             Rastreadora r = new Rastreadora(larva.getNombre());
    //         } else {
    //             // Si no es "Herbivoro", se elimina la larva de la base de datos
    //             try {
    //                 d.delete(d.getLastidHormiga());
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }
}
