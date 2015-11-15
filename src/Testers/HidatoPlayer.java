package Testers;

import CapaDomini.CapaDomini;
import CapaDomini.Casella;
import CapaDomini.Hidato;
import CapaDomini.Tauler;
import CapaDomini.TaulerComplert;
import CapaPersistencia.*;

import java.util.List;
import java.util.Scanner;

import static CapaDomini.Tauler.*;

/**
 * Created by oriol on 7/11/15.
 */
public class HidatoPlayer {
    //Ya va con la BD
    public static void main(String[] args) {
        System.out.print("Ha comensat una partida nova:");
        String dificultad = null;
        //Enseño todas las id's y dificultades de los hidatos en BD
        List<Hidato> listah = ControladorHidato.getHidatos();
        for (int i = 0; i < listah.size(); ++i) {
            Hidato aux = listah.get(i);
            dificultad = aux.isDificultat();
            System.out.print(aux.getIdhidato() + aux.isDificultat() + "\t");
        }
        Scanner capt = new Scanner(System.in);
        int id = capt.nextInt();    //Eligo la id del hidato que quiero
        //Cojo el id qe pone el user
        Tauler t = TauleriniCP.getTaulerini(id);
        System.out.print("Parametres hidato escollit \t");
        Casella[][] vec = new Casella[t.getTamany()][];
        vec = t.getTauler();
        System.out.println("");
        for (int i = 0; i < vec.length; ++i) {
            for (int j = 0; j < vec.length; ++j) {
                System.out.print(vec[i][j].elem + "\t");
            }
            System.out.println(" ");
        }
        Hidato h = new Hidato();
        h.setIdhidato(id);
        h.setTauler(t);
        h.setDificultat(dificultad);
        TaulerComplert omplert = TaulerOmplertCP.getTaulerOmp(id);
        h.setTaulerComplert(omplert);
        Casella[][] auxi = new Casella[t.getTamany()][];
        auxi = omplert.getTauler();
        System.out.println("Imprimo el lleno, solucionado");
        for (int i = 0; i < auxi.length; ++i) {
            for (int j = 0; j < auxi.length; ++j) {
                System.out.print(vec[i][j].elem + "\t");
                if (j == auxi.length - 1) System.out.println("");
            }
        }
        //HASTA AQUI BIEN
        while (h.getTaulerComplert().comparaDiferencies(h.getTauler()) > 0) {
            String s;
            s = capt.nextLine();
            if (s.equals("add")) {
                Afegir_Valor av = new Afegir_Valor();
                av.afegir(h);
            } else if (s.equals("rm")) {
                Remove_valor rv = new Remove_valor();
                rv.remove(h);
            } else if (s.equals("help1")) {
                Ajudes a = new Ajudes();
                a.ajuda1(h);
            } else if (s.equals("help2")) {
                Ajudes a = new Ajudes();
                a.ajuda2(h);
            } else if (s.equals("help3")) {

            } else if (s.equals("stop")) {
                break;
            }

        }

    }
}
