package Testers;

/**
 * Created by oriol on 29/10/15.
 */

import java.util.Scanner;
import CapaDomini.*;

public class Afegir_Valor {
    public void afegir() {
        Hidato h = new Hidato();
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > 6) {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > 6) {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        System.out.println("introdueix valor:");
        int n = capt.nextInt();
        while (h.getTauler().buscaCasella(n) != null) {
            System.out.println("Valor ja assignat");
            n = capt.nextInt();
        }
        while (n > 36) {
            System.out.println("Valorn no valid, introdueix una altra");
            n = capt.nextInt();
        }
        h.getTauler().setCasella(x, y, n);
        h.pintar_hidato(1);
    }
}
