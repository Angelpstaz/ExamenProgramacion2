import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BusinessLogic.Entities.EjercitoRuso.PRHormiga.Hormiga;
import BusinessLogic.Entities.EjercitoRuso.PRHormiga.HormigaReina;
import BusinessLogic.Entities.EjercitoRuso.PRHormiga.Larva;

public class KGD {

    public void iniciar(){
        Scanner scanner = new Scanner(System.in);
        int numero;
        ArrayList<Larva> lstLarva = new ArrayList<>();
        System.out.println("\tBienvenido");

        try {
            System.out.print("Ingrese la cantidad de larvas que se desea crear: ");
            numero = scanner.nextInt();

            if (numero > 0) {
                HormigaReina prHr = new HormigaReina();

                for(int i = 1; i <= numero; i++)
                {
                    lstLarva.add(new Larva(i, "Larva"+String.valueOf(i),1000+i));
                }
                for (Larva larva : lstLarva) {
                    System.out.println("Nombre: " + larva.getNombre()+ " Codigo Unico: "+ larva.getPRCodigoUnico());
                    HormigaReina.prAlimentarLarva(larva,HormigaReina.getAlimento(larva.getPRCodigoUnico()));
                    System.out.println("Presiona Enter para continuar...");

                    scanner.nextLine();
                }
            } else {
                System.out.println("Por favor, ingrese un número entero positivo.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar el Scanner en el bloque finally para evitar posibles fugas de recursos
            scanner.close();
        }    
    }

    private static void esperarEntrada(Scanner scanner) {
        scanner.next();  // Espera a que el usuario presione Enter
    }
    
}
