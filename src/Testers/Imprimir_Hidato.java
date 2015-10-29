package Testers;

/**
 * Created by oriol on 29/10/15.
 */

import CapaDomini.Hidato;

import java.util.Scanner;

public class Imprimir_Hidato {
    public static void main(){
        Hidato h = new Hidato();
        Scanner capt = new Scanner(System.in);
        h.pintar_hidato(2);
    }
}
