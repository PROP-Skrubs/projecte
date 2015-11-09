package Testers;

import CapaDomini.Hidato;

import java.util.Scanner;

/**
 * Created by oriol on 29/10/15.
 */
public class Remove_valor {
    public void remove(Hidato h) {
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > h.getTauler().getLongitud()) {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > h.getTauler().getLongitud()) {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        System.out.println("Eliminat");
        h.getTauler().setCasella(x, y, 0);
        h.getTauler().pintar_tauler();
    }
}
