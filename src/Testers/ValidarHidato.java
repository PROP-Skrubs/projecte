package Testers;

import CapaDomini.Hidato;
import CapaDomini.Tauler;
import CapaDomini.TaulerComplert;
import CapaDomini.ValidadorTauler;
import CapaVista.DemanaTaulerAUsuari;

import java.util.Scanner;

/**
 * Created by daniel on 09/11/15.
 */
public class ValidarHidato
{
    public static void main()
    {
        Scanner teclat = new Scanner(System.in);
        Tauler t1 = new Tauler(teclat);
        TaulerComplert t2 = new TaulerComplert();

        ValidadorTauler.validarTauler(t1,t2);

        t1.print();
        System.out.println("------");
        t2.print();
    }
}