package CapaVista;

import CapaDomini.Tauler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by daniel on 29/10/15.
 */
public class DemanaTaulerAUsuari
{
    public static void run (Tauler aModificar)
    {
        Scanner in = new Scanner(System.in);
        int costat = aModificar.getTamany();
        for (int i = 0; i < costat; ++i)
        {
            for (int j = 0; j < costat; ++j)
            {
                aModificar.setCasella(i,j,in.nextInt());
            }
        }
    }

}
