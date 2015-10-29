package Testers;

import CapaDomini.Tauler;
import CapaVista.DemanaTaulerAUsuari;

/**
 * Created by daniel on 22/10/15.
 * Aquest tester mira si la funcionalitat de comprovar si un tauler és partit funciona bé.
 */

public class TesterParticio
{
    public static void main(String[] args)
    {
        Tauler prova = new Tauler(4);
        DemanaTaulerAUsuari.run(prova);
        if (!prova.esPartit()) System.out.println("No és partit!! Tot bé.");
        else System.out.println("Malament, és partit.");

    }
}