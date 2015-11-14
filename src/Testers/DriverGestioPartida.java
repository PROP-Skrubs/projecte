package Testers;

import java.util.Scanner;
import  CapaDomini.Hidato;
/**
 * Created by oriol on 12/11/15.
 */
public class DriverGestioPartida {
    public static void main() {
        while (true) {
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            System.out.print("Introdueix id del hidato a jugar:");
            Hidato h = new Hidato();
            while (h.getTaulerComplert().comparaDiferencies(h.getTauler()) > 0){
                System.out.println("Introdueix una comana:");
                System.out.println("\t-add:  Afegir numero");
                System.out.println("\t-rm:   Eliminar numero");
                System.out.println("\t-help1: Seguent numero");
                System.out.println("\t-help2: Possibles candidats");
                System.out.println("\t-stop: Sortir de la partida");
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
            System.out.println("HAS GUANYAT LA PARTIDA");
        }
    }
}
