package Testers;

import CapaDomini.Hidato;
import CapaDomini.Tauler;
import CapaDomini.ValidadorTauler;
import CapaVista.DemanaTaulerAUsuari;

import java.util.Scanner;

/**
 * Created by daniel on 09/11/15.
 */
public class ValidarHidato
{
    public static void run()
    {
        System.out.println("De quant vols que sigui el tauler? ");
        Tauler prova = new Tauler(new Scanner(System.in).nextInt());
        DemanaTaulerAUsuari.run(prova);
        Hidato h = new Hidato();
        h.setTauler(prova);

        System.out.println(ValidadorTauler.validarTauler(h.getTauler(),h.getTaulerComplert()));

    }
}
