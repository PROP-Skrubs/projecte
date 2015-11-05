package Testers;

/**
 * Created by oriol on 5/11/15.
 */
import CapaDomini.Hidato;
import CapaDomini.ControladorAjudes;
import CapaDomini.Casella;
import java.util.List;
import java.util.Scanner;

public class Ajudes {
    public void ajuda1(Hidato h){
        ControladorAjudes ca = new ControladorAjudes();
        Casella c = new Casella();
        c = ca.help1(h);
        Scanner capt = new Scanner(System.in);
        System.out.println("Jo de tu posaria el numero" + c.elem + " a les posicions x:" + c.x + " y:" + c.y);
    }
    public void ajuda2(Hidato h){
        ControladorAjudes ca = new ControladorAjudes();
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
        List<Integer> l = ca.help2(x, y, h);
    }
}
