package Testers;

/**
 * Created by oriol on 29/10/15.
 */

import CapaDomini.Hidato;

import java.util.Scanner;

public class Imprimir_Hidato {

    public void imprimir(Hidato h){
        h.getTauler().pintar_tauler();
    }
}
