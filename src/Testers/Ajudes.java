package Testers;

/**
 * Created by oriol on 5/11/15.
 */
import CapaDomini.Hidato;
import CapaDomini.ControladorAjudes;
import CapaDomini.Casella;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ajudes {
    public void ajuda1(Hidato h){
        ControladorAjudes ca = new ControladorAjudes();
        Casella c = new Casella();
        c = ca.help1(h);
        System.out.println("Jo de tu posaria el numero" + c.elem + " a les posicions x:" + c.x + " y:" + c.y);
    }
    public void ajuda2(Hidato h){
        ControladorAjudes ca = new ControladorAjudes();
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
        List<Integer> l = ca.help2(x, y, h);
        Iterator<Integer> it = l.iterator();
        System.out.println("Possibles Candidats:");
        while (it.hasNext()) {
            System.out.print(" " + it.next());

        }
        System.out.print("\n");
    }

}