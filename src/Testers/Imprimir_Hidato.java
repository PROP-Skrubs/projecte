package Testers;

/**
 * Created by oriol on 29/10/15.
 */

import CapaDomini.Hidato;

import java.util.Scanner;

public class Imprimir_Hidato {

    public void imprimir(Hidato h){
        Scanner capt = new Scanner(System.in);
        h.getTauler().pintar_tauler(1);
    }

    public void imprimir_sol(Hidato h){
        Scanner capt = new Scanner(System.in);
        h.getTauler().pintar_tauler(1);
    }
}
