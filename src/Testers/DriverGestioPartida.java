package Testers;

import java.util.Scanner;
import  CapaDomini.Hidato;
/**
 * Created by oriol on 12/11/15.
 */
public class DriverGestioPartida {
    public static void main() {
        while (true) {
            System.out.print("Introdueix Stub a probar:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            else if (s.equals("hidato play")){
                System.out.print("Introdueix id del hidato a jugar:");
                Hidato h = new Hidato();
                while (h.getTaulerComplert().comparaDiferencies(h.getTauler()) > 0){
                    System.out.println("Introdueix una comana:");
                    s = capt.nextLine();
                    if (s.equals("add")){
                        Afegir_Valor av = new Afegir_Valor();
                        av.afegir(h);
                    }

                    else if (s.equals("rm")){
                        Remove_valor rv = new Remove_valor();
                        rv.remove(h);
                    }

                    else if (s.equals("help1")){
                        Ajudes a = new Ajudes();
                        a.ajuda1(h);
                    }
                    else if (s.equals("help2")){
                        Ajudes a = new Ajudes();
                        a.ajuda2(h);
                    }
                    else if (s.equals("help3")){

                    }
                    else if (s.equals("stop")) {
                        break;
                    }
                }
            }
            else s.equals("Comana no valida");
        }
    }
}
