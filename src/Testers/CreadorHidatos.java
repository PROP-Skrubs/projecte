package Testers;

import CapaDomini.CapaDomini;

import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class CreadorHidatos {
    public void main() {
        System.out.println("Generador de Hidatos:");
        CapaDomini cd = new CapaDomini();
        while(true){
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1:Generar Hidato aleatori");
            System.out.println("\t- 2:Generar Hidato manualment");
            System.out.println("\t- x:Sortir generador Hidatos");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("1")){
                capt = new Scanner(System.in);
                System.out.println("introdueix tamany hidato:");
                int x = capt.nextInt();
                int y = capt.nextInt();
                int z = capt.nextInt();
                s = capt.nextLine();
                if(cd.validarparamscreacioTaulerpredeterminat(x, y, z, s)){
                    cd.creacioTaulerPredeterminat(x, y, z, s);
                }
            }
            else if (s.equals("2")){

            }
            else if (s.equals("x")){
                break;
            }
            else System.out.println("Comana no valida");
        }
    }
}
