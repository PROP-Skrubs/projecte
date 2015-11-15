package Testers;

import java.util.Scanner;
import  CapaDomini.Hidato;
import CapaPersistencia.GestorHidato;

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
            else if (s.equals("play")){
                System.out.print("Introdueix id del hidato a jugar:");
                Hidato h;
                Integer i = capt.nextInt();
                h = GestorHidato.getHidato(i);
                while (h.getTaulerComplert().comparaDiferencies(h.getTauler()) > 0) {
                    System.out.println("Introdueix una comana:");
                    System.out.println("\t-add:  Afegir numero");
                    System.out.println("\t-rm:   Eliminar numero");
                    System.out.println("\t-help1: Seguent numero");
                    System.out.println("\t-help2: Possibles candidats");
                    System.out.println("\t-x: Sortir de la partida");
                    s = capt.nextLine();
                    if (s.equals("add")) {
                        h.afegir();
                    } else if (s.equals("rm")) {
                        h.remove();
                    } else if (s.equals("help1")) {
                        Ajudes a = new Ajudes();
                        a.ajuda1(h);
                    } else if (s.equals("help2")) {
                        Ajudes a = new Ajudes();
                        a.ajuda2(h);
                    } else if (s.equals("x")) {
                        break;
                    }
                }
                if (h.getTaulerComplert().comparaDiferencies(h.getTauler()) > 0)
                    System.out.println("HAS GUANYAT LA PARTIDA");
            }
        }
    }
}
