package CapaDomini;

import java.util.Scanner;

/**
 * Created by daniel on 12/10/15.
 */


public class Hidato
{
    private int uniqID;
    private Tauler tauler;
    private TaulerComplert taulerComplert;
    public String dificultat;

    public Hidato()
    {
        uniqID = -1;
        tauler = null;
        taulerComplert = null;
        dificultat = null;
    }

    public Hidato(int idHidato, Tauler tauler, TaulerComplert taulerComplert, String dificultat)
    {
        this.uniqID = idHidato;
        this.tauler.move(tauler);
        this.taulerComplert.move(taulerComplert);
        this.dificultat = dificultat;
    }


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
    public int getUniqID() {
        return uniqID;
    }

    public void setUniqID(int uniqID) {
        this.uniqID = uniqID;
    }

    public String isDificultat() {
        return dificultat;
    }

    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    public void afegir() { //todo arreglar aixo
        /**
         * Afegeix un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        Scanner capt = new Scanner(System.in);
        System.out.println("introdueix X:");
        int x = capt.nextInt();
        while (x < 1 | x > tauler.getTamany()) {
            System.out.println("X no valida, introdueix una altra");
            x = capt.nextInt();
        }

        System.out.println("introdueix Y:");
        int y = capt.nextInt();
        while (y < 1 | y > tauler.getTamany()) {
            System.out.println("Y no valida, introdueix una altra");
            y = capt.nextInt();
        }
        System.out.println("introdueix valor:");
        int n = capt.nextInt();
        while (tauler.buscaCasella(n) != null) {
            System.out.println("Valor ja assignat");
            n = capt.nextInt();
        }
        while(true){
            if (tauler.getTamany() * 2 < n)
                System.out.println("Valor massa gran");
            else if (n < 1)
                System.out.println("Valor massa petit");
            else break;
            n = capt.nextInt();
        }
        tauler.setCasella(x - 1, y - 1, n);
        tauler.pintar_tauler();
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
        tauler.setCasella(x - 1, y - 1, 0);
        tauler.pintar_tauler();
    }

    public void imprimir(){
        getTauler().pintar_tauler();
    }
}
