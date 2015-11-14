package Testers;

import CapaDomini.Tauler;
import CapaVista.DemanaTaulerAUsuari;

import java.util.Scanner;

/**
 * Created by daniel on 22/10/15.
 * Aquest tester mira si la funcionalitat de comprovar si un tauler és partit funciona bé.
 */

public class TaulerParticionat
{
    public static void run()
    {
        System.out.println("De quant vols que sigui el tauler? ");
        Tauler prova = new Tauler(new Scanner(System.in).nextInt());
        DemanaTaulerAUsuari.run(prova);
        if (!prova.esPartit()) System.out.println("No és partit!! Tot bé.");
        else System.out.println("Malament, és partit.");

    }
}