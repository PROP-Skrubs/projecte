package CapaDomini;

import java.util.Scanner;

/**
 * Created by daniel on 12/10/15.
 */


public class Hidato
{
    private Tauler tauler;
    private TaulerComplert taulerComplert;
    public boolean dificultat;

    public Tauler getTauler()
    {
        return tauler;
    }
    public TaulerComplert getTaulerComplert()
    {
        return taulerComplert;
    }

    public void setTauler(Tauler nou)
    {
        tauler = nou;
    }
    public void setTaulerComplert(TaulerComplert nou)
    {
        taulerComplert = nou;
    }


    public void afegir() { //todo arreglar aixo
        /**
         * Afegeix un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > getTauler().getTamany()) {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > getTauler().getTamany()) {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        System.out.println("introdueix valor:");
        int n = capt.nextInt();
        while (getTauler().buscaCasella(n) != null) {
            System.out.println("Valor ja assignat");
            n = capt.nextInt();
        }
        getTauler().setCasella(x, y, n);
        getTauler().pintar_tauler();
    }

    public void remove() {
        /**
         * Treu un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > getTauler().getTamany()) {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > getTauler().getTamany()) {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        System.out.println("Eliminat");
        getTauler().setCasella(x, y, 0);
        getTauler().pintar_tauler();
    }

    public void imprimir(){
        getTauler().pintar_tauler();
    }
}
