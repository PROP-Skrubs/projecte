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

<<<<<<< HEAD
public class Ajudes {
    public void ajuda1(Hidato h){
        /**
         * Imprimeix per pantalla on s’ha de posar el següent número de l’Hidato
         */
=======
public class Ajudes
{
    public void ajuda1(Hidato h)
    {
>>>>>>> 5dff060f7f6193ffe6252985ba83b1b18cc66b96
        ControladorAjudes ca = new ControladorAjudes();
        Casella c = new Casella();
        c = ca.help1(h);
        System.out.println("Jo de tu posaria el numero" + c.elem + " a les posicions x:" + (c.x + 1) + " y:" + (c.y + 1));
    }
<<<<<<< HEAD
    public void ajuda2(Hidato h){
        /**
         * Imprimeix per a una casella de l’Hidato, els possibles candidats
         */
=======

    public void ajuda2(Hidato h)
    {
>>>>>>> 5dff060f7f6193ffe6252985ba83b1b18cc66b96
        ControladorAjudes ca = new ControladorAjudes();
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > 6)
        {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > 6)
        {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        List<Integer> l = ca.help2(x - 1, y - 1, h);

        if (l.isEmpty()) System.out.print("Estoy vacia");

        Iterator<Integer> it = l.iterator();
        System.out.println("Possibles Candidats:");
        while (it.hasNext())
        {
            System.out.print(" " + it.next());

        }
        System.out.print("\n");
    }

}
