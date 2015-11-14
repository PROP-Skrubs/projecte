package CapaVista;

import CapaDomini.CapaDomini;
import CapaDomini.Tauler;
import java.util.Scanner;

/**
 * Created by daniel on 12/10/15.
 */


public class CapaVista
{
    public static void main(String[] args)
    {
        mostraMenuLogin();
    }

    public static void mostraMenuLogin()
    {
        new MenuLogin();
    }

    public static void mostraMenuPrincipal()
    {
        new MenuPrincipal();
    }

    public static Tauler demanaTauleraUsuariPredeterminat()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        /*InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine(); */

        String dificultat = "facil"; //como ejemplo
        Tauler ret = CapaDomini.creacioTaulerPredeterminat(n, m, x, dificultat);

        return ret;

    }
}