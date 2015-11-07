package Testers;

import CapaDomini.Hidato;
import java.util.Scanner;
/**
 * Created by oriol on 7/11/15.
 */
public class HidatoPlayer {
    public static void main(String[] args) {
        System.out.print("Ha comensat una partida nova:");
        Hidato h = new Hidato();
        Scanner capt = new Scanner(System.in);
        while (h.getTaulerComplert().comparaDiferencies(h.getTauler()) > 0){
            String s;
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
}