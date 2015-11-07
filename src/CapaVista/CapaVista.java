package CapaVista;

import CapaDomini.CapaDomini;

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

    public static void demanaTaulerAUsuari(Tauler aModificar)
    {
        Scanner in = new Scanner(System.in);
        int costat = aModificar.getLongitud();
        for (int i = 0; i < costat; ++i)
        {
            for (int j = 0; j < costat; ++j)
            {
                aModificar.setCasella(i,j,in.nextInt());
            }
        }
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