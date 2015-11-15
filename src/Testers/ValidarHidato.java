package Testers;

import CapaDomini.Tauler;
import CapaDomini.TaulerComplert;
import CapaDomini.ValidadorTauler;

import java.util.Scanner;

/**
 * Created by daniel on 09/11/15.
 */
public class ValidarHidato
{
    public static void main(String[] args)
    {
        Scanner teclat = new Scanner(System.in);
        Tauler t1 = new Tauler(teclat);
        TaulerComplert t2 = new TaulerComplert();

        int resultat = ValidadorTauler.validarTauler(t1, t2);

        System.out.println(resultat);

        if (resultat == 0) t2.print();
    }
}